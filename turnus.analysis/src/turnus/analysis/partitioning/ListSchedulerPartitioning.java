/* 
 * TURNUS - www.turnus.co
 * 
 * Copyright (C) 2023 Endri Bezati
 *
 * This file is part of TURNUS.
 *
 * TURNUS is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * TURNUS is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with TURNUS.  If not, see <http://www.gnu.org/licenses/>.
 * 
 * Additional permission under GNU GPL version 3 section 7
 * 
 * If you modify this Program, or any covered work, by linking or combining it
 * with Eclipse (or a modified version of Eclipse or an Eclipse plugin or 
 * an Eclipse library), containing parts covered by the terms of the 
 * Eclipse Public License (EPL), the licensors of this Program grant you 
 * additional permission to convey the resulting work.  Corresponding Source 
 * for a non-source form of such a combination shall include the source code 
 * for the parts of Eclipse libraries used as well as that of the  covered work.
 * 
 */

package turnus.analysis.partitioning;

import static turnus.common.TurnusOptions.ANALYSIS_PARTITIONING_UNITS;
import static turnus.common.TurnusOptions.SCHEDULING_POLICY;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.annotation.Target;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Vector;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Stream;

import turnus.analysis.Analysis;
import turnus.analysis.buffer.BoundedBufferAnalysis;
import turnus.common.TurnusException;
import turnus.common.io.Logger;
import turnus.common.util.FileUtils;
import turnus.model.analysis.buffers.BoundedBuffersReport;
import turnus.model.analysis.partitioning.MetisPartitioning;
import turnus.model.analysis.partitioning.MetisPartitioningReport;
import turnus.model.analysis.partitioning.PartitioningFactory;
import turnus.model.analysis.profiling.util.MemoryAndBuffers;
import turnus.model.common.EScheduler;
import turnus.model.dataflow.Actor;
import turnus.model.dataflow.Buffer;
import turnus.model.dataflow.Network;
import turnus.model.dataflow.Port;
import turnus.model.dataflow.util.ActorsSorter;
import turnus.model.mapping.BufferSize;
import turnus.model.mapping.NetworkPartitioning;
import turnus.model.trace.Step;
import turnus.model.trace.Trace.Order;
import turnus.model.trace.TraceDecorator;
import turnus.model.trace.TraceProject;
import turnus.model.trace.weighter.TraceWeighter;

/**
 * Partitioning based on Metis graph partitioner
 * 
 * @author Endri Bezati
 */
public class ListSchedulerPartitioning extends Analysis<MetisPartitioningReport> {

	public static final int DEFAULT_UNITS = 2;
	public static final String DEFAULT_SCHEDULING_POLICY = "ROUND_ROBIN";
	private static final String METIS_APP = "gpmetis";
	private TraceWeighter traceWeighter;
	private int units;
	private EScheduler schedulingPolicy;

	private Map<Buffer, Long> bufferVolume;

	private Map<Actor, Double> actorWorkload;

	private TraceDecorator decorator;

	public ListSchedulerPartitioning(TraceProject project, TraceWeighter traceWeighter) {
		super(project);
		this.traceWeighter = traceWeighter;
		this.actorWorkload = new HashMap<>();
		this.bufferVolume = new HashMap<>();
		this.decorator = project.getTraceDecorator();
	}

	private boolean execInPath(String exec) {
		return Stream.of(System.getenv("PATH").split(Pattern.quote(File.pathSeparator))).map(Paths::get)
				.anyMatch(path -> Files.exists(path.resolve(exec)));
	}

	private int bitsToMegaBytes(Long value) {
		long ret = value / 8 / 1024;
		return (int) (ret == 0L ? 1 : ret);
	}

	private long getTotalBitsOfBuffer(BufferSize bufferSize, Buffer buffer) {
		int depth = bufferSize.getSize(buffer);
		long bits = buffer.getType().getBits();
		return depth * bits;
	}

	private String metisDot(Network network, BufferSize minBufferConfiguration, Vector<Actor> actor_map, Map<String, Integer> nodeLabelsToIntegers) {

		List<String> lines = new ArrayList<>();	
			
		int div = 1000000;
		
		long total= 0;
		
		lines.add("digraph  {\n");
		System.out.println("strict digraph  {");
		for (Actor actor : actor_map) {

			long persistentMemory = MemoryAndBuffers.getActorPersistentMemmory(actor);
			System.out.println(actor);
			
			for (Buffer outgoing : actor.getOutgoingBuffers()) {
				persistentMemory += getTotalBitsOfBuffer(minBufferConfiguration, outgoing);
			}
			
			total += persistentMemory;
	
			int actorWeight = (int) (actorWorkload.get(actor).longValue());
			if (actorWeight == 0) {
				actorWeight = 1;
			}

			lines.add(String.format("%s[work_weight=%d mem_weight=%s comm_weight=%s]\n", nodeLabelsToIntegers.get(actor.getName()), actorWeight, persistentMemory/8/1024/1024, 1));

			System.out.println(
					String.format("%s [workload=%d, memory=%s]", actor.getName(), actorWeight, persistentMemory/8/1024/1024));
		}

		for (Actor actor : network.getActors()) {
			for (Port port : actor.getOutputPorts()) {
				for (Buffer buffer : port.getOutputs()) {
					String tagetActorLabel = buffer.getTarget().getOwner().getName();
					Long bufferWeight = bufferVolume.get(buffer);
					lines.add(String.format("%s->%s [comm_weight=%d]\n", nodeLabelsToIntegers.get(actor.getName()), nodeLabelsToIntegers.get(tagetActorLabel), bufferWeight / div ));
					
					//System.out
					//		.println(String.format("%s -> %s [data=%d]", actor.getName(), tagetActorLabel, bufferWeight));
				}
			}

		}
		
		lines.add("}");
		System.out.println("}");
		System.out.println("total mem: " + total/8/1024/1024/1024);
		
		String ret = "";
		
		try {
			File metisInput = FileUtils.createTempFile(network.getName(), ".dot", false);

			FileWriter writer = new FileWriter(metisInput);
			StringBuffer sb = new StringBuffer();
			
			
			lines.stream().forEach(l -> {
				// sb.append(String.valueOf(actor));
				sb.append(l);
			});

			sb.append("\n");
			writer.write(sb.toString());
			System.out.println("file written");
			ret = metisInput.getAbsolutePath();
			
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}			
		
		return ret;
	}

	private NetworkPartitioning metisPartitioning(Network network, BufferSize minBufferConfiguration) {
		NetworkPartitioning partitioning = new NetworkPartitioning(network);
		Map<String, Integer> nodeLabelsToIntegers = new HashMap<>(network.getActors().size());
		Map<Integer, String> integerToNodeLables = new HashMap<>(network.getActors().size());
		int i = 1;

		// -- Topological sort actors
		List<Actor> topologicalSort = ActorsSorter.topologicalOrder(network.getActors());

		Vector<Actor> actor_map = new Vector<Actor>(network.getActors().size());
		
		// -- Node labels to integers
		int j = 0;
		for (Actor actor : topologicalSort) {
			actor_map.add(j, actor);
			
			nodeLabelsToIntegers.put(actor.getName(), j);
			integerToNodeLables.put(j, actor.getName());
			j++;
			i++;
		}

		String file_path = metisDot(network, minBufferConfiguration, actor_map, nodeLabelsToIntegers);
		

			List<String> commands = new ArrayList<>();
			// -- app
			commands.add("./oneStopParallel");
			// -- input graph

						
			System.out.println(file_path);
			
			commands.add("-g");
			commands.add(file_path);
			
			commands.add("-m");
			commands.add(Integer.toString(units));

			String algo_name = "CoarseWavefront";
			
			 commands.add("--"+ algo_name);
			 commands.add("-o");
			// -- units
//			commands.add(" -m "+ Integer.toString(units));
			
//			commands.add(" --greedyetf ");
			// -- ptype
			//commands.add("-ptype=kway");
			// -- objtype
			//commands.add("-objtype=vol");
			// -- ubvec
			//commands.add("-ufactor=1.001");
			//commands.add("-ubvec=1.5 1.5");
			//commands.add("-ncuts=10");
			//commands.add("-contig");
			
			System.out.println(commands);
			
		try {
			ProcessBuilder metisPB = new ProcessBuilder(commands);
			metisPB.redirectErrorStream(true);
			metisPB.directory(new File(System.getProperty("java.io.tmpdir")));

			Process metis = metisPB.start();
			metis.waitFor();
			String result = new String(metis.getInputStream().readAllBytes());

			Logger.info("\n" + result);
			// -- Read metis output
			
		    int lastSeparator = file_path.lastIndexOf(".");
		    
			String metisOutput = file_path.substring(0, lastSeparator) + "_p" + Integer.toString(units) + "_"+algo_name+"_schedule.txt";

			System.out.println(metisOutput);
			
			
			try (BufferedReader br = new BufferedReader(new FileReader(metisOutput))) {
				String line;
				int actorIndex = 0;
					
	

				while ((line = br.readLine()) != null) {
					try {

		
						String[] split = line.split(" ");
						
						if (split.length > 3) {
							continue;
						}
						
						int partition = Integer.parseInt(split[1]);
						
						String actor = integerToNodeLables.get(actorIndex);
						
			
						
						partitioning.setPartition(actor, "p" + partition);
						actorIndex++;
						if (actorIndex == network.getActors().size()) {
							break;
						}

					} catch (NumberFormatException e) {
						// Handle non-integer lines if needed
						System.err.println("Skipping non-integer line: " + line);
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}

			partitioning.setSchedulerToAll(schedulingPolicy.getName());

			} catch (Exception e) {
				e.printStackTrace();
			}	

		return partitioning;

	}

	private void processTrace() {

		for (Buffer buffer : project.getNetwork().getBuffers()) {
			bufferVolume.put(buffer, 0L);
		}

		for (Actor actor : project.getNetwork().getActors()) {
			Iterator<Step> steps = project.getTrace().getSteps(Order.INCREASING_ID, actor.getName()).iterator();
			double sum = 0;
			while (steps.hasNext()) {
				Step next = steps.next();

				for (Entry<Buffer, Integer> entry : decorator.getWriteTokens(next).entrySet()) {
					Long current = bufferVolume.get(entry.getKey());
					Port port = entry.getKey().getSource();
					Long neccessaryBitsPerWrtie = entry.getValue() * port.getType().getBits();

					bufferVolume.put(entry.getKey(), current + neccessaryBitsPerWrtie);
				}

				sum += traceWeighter.getWeight(next);
			}
			actorWorkload.put(actor, sum);
		}

	}

	@Override
	public MetisPartitioningReport run() throws TurnusException {
		units = configuration.getValue(ANALYSIS_PARTITIONING_UNITS, DEFAULT_UNITS);
		schedulingPolicy = EScheduler.get(configuration.getValue(SCHEDULING_POLICY, DEFAULT_SCHEDULING_POLICY));
		PartitioningFactory f = PartitioningFactory.eINSTANCE;
		MetisPartitioningReport report = f.createMetisPartitioningReport();
		report.setNetwork(project.getNetwork());
		report.setAlgorithm("Metis partitioner");
		report.setSchedulinPolicy(schedulingPolicy);

		if (!execInPath(METIS_APP)) {
			throw new TurnusException("gpmetis not found in the path, please install metis.");
		}

		// -- Run bounded buffer analysis for a total cost of memory
		BoundedBuffersReport minimalBufferData = null;
		BufferSize minBufferConfiguration = null;
		// evaluate the minimal non-blocking buffer size
		Logger.info("Evaluate the minimal buffer size configuration");
		BoundedBufferAnalysis boundedBufferAnalysis = new BoundedBufferAnalysis(project);
		boundedBufferAnalysis.setConfiguration(configuration);
		minimalBufferData = boundedBufferAnalysis.run();
		minBufferConfiguration = minimalBufferData.asBufferSize();

		// -- Calculate workload and total communication volume
		processTrace();

		// -- Metis partitioning
		NetworkPartitioning partitioning = metisPartitioning(project.getNetwork(), minBufferConfiguration);
		for (String partition : partitioning.asPartitionActorsMap().keySet()) {
			MetisPartitioning mp = f.createMetisPartitioning();
			Double workload = 0.0;
			for (String actorName : partitioning.asPartitionActorsMap().get(partition)) {
				Actor actor = project.getNetwork().getActor(actorName);
				mp.getActors().add(actor);
				workload += actorWorkload.get(actor);
			}
			mp.setWorkload(workload);
			report.getPartitions().add(mp);
		}

		return report;
	}

}
