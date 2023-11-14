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
import static turnus.common.TurnusOptions.EXTERNAL_PARTITIONING_TOOL;
import static turnus.common.TurnusOptions.SCHEDULING_POLICY;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Stream;

import org.apache.commons.lang3.SystemUtils;

import turnus.analysis.Analysis;
import turnus.analysis.hypergraph.WeightedActor;
import turnus.analysis.hypergraph.WeightedEdge;
import turnus.analysis.hypergraph.WeightedHyperGraph;
import turnus.common.TurnusException;
import turnus.common.io.Logger;
import turnus.common.util.FileUtils;
import turnus.model.analysis.partitioning.MetisPartitioning;
import turnus.model.analysis.partitioning.MetisPartitioningReport;
import turnus.model.analysis.partitioning.PartitioningFactory;
import turnus.model.common.EScheduler;
import turnus.model.dataflow.Actor;
import turnus.model.dataflow.Buffer;
import turnus.model.dataflow.Network;
import turnus.model.dataflow.Port;
import turnus.model.dataflow.util.ActorsSorter;
import turnus.model.mapping.NetworkPartitioning;
import turnus.model.trace.Step;
import turnus.model.trace.Trace.Order;
import turnus.model.trace.TraceDecorator;
import turnus.model.trace.TraceProject;
import turnus.model.trace.weighter.TraceWeighter;

/**
 * Partitioning based on different hypergraph partitioning based on hmetis
 * format
 * 
 * @author Endri Bezati
 */
public class HypergraphPartitioning extends Analysis<MetisPartitioningReport> {

	public static final int DEFAULT_UNITS = 2;
	public static final String DEFAULT_SCHEDULING_POLICY = "ROUND_ROBIN";
	private static final String DEFAULT_PARTITIONING_TOOL = "khmetis";
	private TraceWeighter traceWeighter;
	private int units;
	private EScheduler schedulingPolicy;

	private Map<Buffer, Long> bufferVolume;

	private Map<Actor, Double> actorWorkload;

	private TraceDecorator decorator;

	private String externalTool;

	public HypergraphPartitioning(TraceProject project, TraceWeighter traceWeighter) {
		super(project);
		this.traceWeighter = traceWeighter;
		this.actorWorkload = new HashMap<>();
		this.bufferVolume = new HashMap<>();
		this.decorator = project.getTraceDecorator();
	}

	private boolean execInPath(String exec) {
		final String app = SystemUtils.IS_OS_WINDOWS ? exec + ".exe" : exec;

		return Stream.of(System.getenv("PATH").split(Pattern.quote(File.pathSeparator))).map(Paths::get)
				.anyMatch(path -> Files.exists(path.resolve(app)));
	}

	private int bitsToMegaBytes(Long value) {
		long ret = value / 8 / 1024 / 1024;
		return (int) (ret == 0L ? 1 : ret);
	}

	@SuppressWarnings("resource")
	private NetworkPartitioning metisPartitioning(Network network) {
		NetworkPartitioning partitioning = new NetworkPartitioning(network);
		Map<Integer, String> integerToNodeLables = new HashMap<>(network.getActors().size());

		Long minBufferVol = Collections.min(bufferVolume.values());
		Double minWorkload = Collections.min(actorWorkload.values());
		// -- Topological sort actors
		List<Actor> topologicalSort = ActorsSorter.topologicalOrder(network.getActors());

		int hyperEdgeCounter = 0;
		WeightedHyperGraph hg = new WeightedHyperGraph();

		// -- Create hyper-edges
		for (Actor actor : topologicalSort) {
			Long bufferWeight = 0L;
			if (!actor.getOutgoingBuffers().isEmpty()) {
				Set<Actor> nodes = new HashSet<>();
				nodes.add(actor);
				for (Buffer outgoing : actor.getOutgoingBuffers()) {
					nodes.add(outgoing.getTarget().getOwner());
					bufferWeight += bufferVolume.get(outgoing);
				}
				WeightedEdge edge = new WeightedEdge(hyperEdgeCounter, bitsToMegaBytes(bufferWeight/minBufferVol));

				Set<WeightedActor> weightedNodes = new HashSet<>();
				for (Actor actorNode : nodes) {
					WeightedActor weightedActor = new WeightedActor(topologicalSort.indexOf(actorNode) + 1, actorNode,
							actorWorkload.get(actorNode)/minWorkload);
					weightedNodes.add(weightedActor);
				}

				hg.addHyperedge(edge, weightedNodes);
				hyperEdgeCounter++;
			}
			integerToNodeLables.put(topologicalSort.indexOf(actor) + 1, actor.getName());
		}

		// -- hMetis file
		try {
			File metisInput = FileUtils.createTempFile(network.getName(), ".hgraph", false);

			FileWriter writer = new FileWriter(metisInput);
			

			// -- Call metis
			String fileOutput;
			if (externalTool.equals("khmetis")) {
				// -- Populate input
				StringBuffer sb = hg.tohMetis();
				writer.write(sb.toString());
				writer.close();
				
				List<String> commands = new ArrayList<>();
				if (SystemUtils.IS_OS_WINDOWS) {
					commands.add("khmetis.exe");
				} else {
					commands.add("khmetis");
				}
				// -- input file
				commands.add(metisInput.getAbsolutePath());
				// -- units
				commands.add(Integer.toString(units));
				// -- UBfactor
				commands.add(Integer.toString(5));
				// -- Nruns
				commands.add(Integer.toString(20));
				// -- CType
				commands.add(Integer.toString(1));
				// -- OType
				commands.add(Integer.toString(2));
				// -- Vcycle
				commands.add(Integer.toString(3));
				// -- dglvl
				commands.add(Integer.toString(24));
				
				ProcessBuilder metisPB = new ProcessBuilder(commands);
				metisPB.redirectErrorStream(true);
				metisPB.directory(new File(System.getProperty("java.io.tmpdir")));

				Process metis = metisPB.start();
				int exitCode = metis.waitFor();
				String result = new String(metis.getInputStream().readAllBytes());
				if (exitCode > 1) {
					throw new TurnusException(externalTool + " error: \n" + result);
				}
				Logger.info("\n" + result);
				
				// -- Read metis output
				fileOutput = metisInput.getAbsolutePath() + ".part." + Integer.toString(units);

			} else if (externalTool.equals("KaHyPar")) {
				// -- Populate input
				StringBuffer sb = hg.tohMetis();
				writer.write(sb.toString());
				writer.close();
				
				URL resource = HypergraphPartitioning.class.getClassLoader()
						.getResource("kahypar/km1_kKaHyPar_sea20.ini");
				File resourceFile = org.apache.commons.io.FileUtils.toFile(resource);
				double epsilon = 0.01;
				String epsilonString = String.valueOf(epsilon);
				final List<String> commands = new ArrayList<String>();
				commands.add("KaHyPar");
				// -- hyper-graph
				commands.add("-h");
				commands.add(metisInput.getAbsolutePath());
				// -- K parts
				commands.add("-k");
				commands.add(String.valueOf(units));
				// -- epsilon
				commands.add("-e");
				commands.add(epsilonString);
				// --
				commands.add("-o");
				commands.add("km1");
				// --
				commands.add("-m");
				commands.add("direct");
				// -- profile
				commands.add("-p");
				commands.add(resourceFile.getAbsolutePath());
				// -- write file
				commands.add("-w");
				commands.add("1");

				ProcessBuilder pb = new ProcessBuilder(commands);
				pb.redirectErrorStream(true);
				pb.directory(new File(System.getProperty("java.io.tmpdir")));

				Process partitioner = pb.start();
				int exitCode = partitioner.waitFor();
				String result = new String(partitioner.getInputStream().readAllBytes());
				if (exitCode != 0) {
					throw new TurnusException("partitioner error: \n" + result);
				}
				Logger.info("\n" + result);

				fileOutput = metisInput.getAbsolutePath() + ".part" + Integer.toString(units) + ".epsilon"
						+ epsilonString + ".seed-1.KaHyPar";
			} else if (externalTool.equals("patoh")) {
				// -- Populate input
				StringBuffer sb = hg.toPatoh();
				writer.write(sb.toString());
				writer.close();
				
				List<String> commands = new ArrayList<>();
				if (SystemUtils.IS_OS_WINDOWS) {
					throw new TurnusException(externalTool + " Not supported in Windows \n");
				} else {
					commands.add("patoh");
				}
				// -- input file
				commands.add(metisInput.getAbsolutePath());
				// -- units
				commands.add(Integer.toString(units));
				
				ProcessBuilder metisPB = new ProcessBuilder(commands);
				metisPB.redirectErrorStream(true);
				metisPB.directory(new File(System.getProperty("java.io.tmpdir")));

				Process metis = metisPB.start();
				int exitCode = metis.waitFor();
				String result = new String(metis.getInputStream().readAllBytes());
				if (exitCode >= 1) {
					throw new TurnusException(externalTool + " error: \n" + result);
				}
				Logger.info("\n" + result);
				
				// -- Read metis output
				fileOutput = metisInput.getAbsolutePath() + ".part." + Integer.toString(units);
			} else {
				throw new TurnusException("This partitioning tool is not supported: \n" + externalTool);
			}

			try (BufferedReader br = new BufferedReader(new FileReader(fileOutput))) {
				String line;
				int actorIndex = 1;
				while ((line = br.readLine()) != null) {
					try {
						int partition = Integer.parseInt(line);
						String actor = integerToNodeLables.get(actorIndex);
						partitioning.setPartition(actor, "p" + partition);
						System.out.println(actor + " : " + "p" + partition);
						actorIndex++;

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
			// TODO Auto-generated catch block
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
		externalTool = configuration.getValue(EXTERNAL_PARTITIONING_TOOL, DEFAULT_PARTITIONING_TOOL);
		PartitioningFactory f = PartitioningFactory.eINSTANCE;
		MetisPartitioningReport report = f.createMetisPartitioningReport();
		report.setNetwork(project.getNetwork());
		report.setAlgorithm("Metis partitioner");
		report.setSchedulinPolicy(schedulingPolicy);

		if (!execInPath(externalTool)) {
			throw new TurnusException(externalTool + " not found in the path !");
		}

		// -- Calculate workload and total communication volume
		processTrace();

		// -- Metis partitioning
		NetworkPartitioning partitioning = metisPartitioning(project.getNetwork());
		for (String partition : partitioning.asPartitionActorsMap().keySet()) {
			MetisPartitioning mp = f.createMetisPartitioning();
			Double workload = 0.0;
			for (String actorName : partitioning.asPartitionActorsMap().get(partition)) {
				Actor actor = project.getNetwork().getActor(actorName);
				mp.getActors().add(actor);
				workload += actorWorkload.get(actor);
			}
			mp.setPartitionId(partition);
			mp.setWorkload(workload);
			report.getPartitions().add(mp);
		}

		return report;
	}

}
