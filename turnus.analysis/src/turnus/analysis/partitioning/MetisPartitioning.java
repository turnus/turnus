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

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Stream;

import turnus.analysis.Analysis;
import turnus.common.TurnusException;
import turnus.model.analysis.partitioning.MetisPartitioningReport;
import turnus.model.analysis.partitioning.PartitioningFactory;
import turnus.model.common.EScheduler;
import turnus.model.dataflow.Actor;
import turnus.model.dataflow.Buffer;
import turnus.model.dataflow.Network;
import turnus.model.dataflow.Port;
import turnus.model.trace.TraceProject;
import turnus.model.trace.weighter.TraceWeighter;

/**
 * Partitioning based on Metis graph partitioner
 * 
 * @author Endri Bezati
 */
public class MetisPartitioning extends Analysis<MetisPartitioningReport> {

	public static final int DEFAULT_UNITS = 2;
	public static final String DEFAULT_SCHEDULING_POLICY = "ROUND_ROBIN";
	private static final String METIS_APP = "gpmetis";
	private TraceWeighter traceWeighter;
	private int units;
	private EScheduler schedulingPolicy;

	public MetisPartitioning(TraceProject project, TraceWeighter tWeighter) {
		super(project);
		this.traceWeighter = tWeighter;
	}

	private boolean execInPath(String exec) {
		return Stream.of(System.getenv("PATH").split(Pattern.quote(File.pathSeparator))).map(Paths::get)
				.anyMatch(path -> Files.exists(path.resolve(exec)));
	}

	private void networkToMetis(Network network) {
		Map<String, Integer> nodeLabelsToIntegers = new HashMap<>(network.getActors().size());
		Map<Integer, String> integerToNodeLables = new HashMap<>(network.getActors().size());
		int i = 1;

		// -- Node labels to integers
		for (Actor actor : network.getActors()) {
			nodeLabelsToIntegers.put(actor.getName(), i);
			integerToNodeLables.put(i, actor.getName());
			i++;
		}

		// -- Number of Actors and connections
		int nbNodes = network.getActors().size();
		int nbEdges = 0;
		List<String> lines = new ArrayList<>();

		for (int n = 1; n < network.getActors().size() + 1; n++) {
			Set<String> adj = new HashSet<>();
			Actor actor = network.getActor(integerToNodeLables.get(n));

			for (Port port : actor.getOutputPorts()) {
				for (Buffer buffer : port.getOutputs()) {
					String tagetActorLabel = buffer.getTarget().getOwner().getName();
					int target = nodeLabelsToIntegers.get(tagetActorLabel);
					adj.add(Integer.toString(target));
				}
			}

			for (Port port : actor.getInputPorts()) {
				String sourceActorLabel = port.getInput().getSource().getOwner().getName();
				int source = nodeLabelsToIntegers.get(sourceActorLabel);
				adj.add(Integer.toString(source));
			}
			nbEdges += adj.size();
			lines.add(String.join(" ", adj));
		}

		System.out.println(String.format("%d %d", nbNodes, nbEdges/2));
		lines.stream().forEach(l -> {
			System.out.println(l);
		});

	}

	@Override
	public MetisPartitioningReport run() throws TurnusException {
		PartitioningFactory f = PartitioningFactory.eINSTANCE;
		MetisPartitioningReport report = f.createMetisPartitioningReport();
		report.setNetwork(project.getNetwork());
		report.setAlgorithm("Metis partitioner");

		if (!execInPath(METIS_APP)) {
			throw new TurnusException("gpmetis not found in the path, please install metis.");
		}

		networkToMetis(project.getNetwork());

		return report;
	}

}
