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
package turnus.analysis.profiling;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import turnus.adevs.model.AtomicActor;
import turnus.adevs.model.AtomicActor.Status;
import turnus.adevs.simulation.SimEngine;
import turnus.analysis.Analysis;
import turnus.common.TurnusException;
import turnus.common.util.Pair;
import turnus.model.analysis.postprocessing.PostProcessingReport;
import turnus.model.analysis.profiling.LatencyData;
import turnus.model.analysis.profiling.LatencyReport;
import turnus.model.analysis.profiling.ProfilingFactory;
import turnus.model.dataflow.Action;
import turnus.model.dataflow.Actor;
import turnus.model.dataflow.Network;
import turnus.model.mapping.BufferSize;
import turnus.model.mapping.NetworkPartitioning;
import turnus.model.trace.TraceProject;
import turnus.model.trace.weighter.TraceWeighter;

/**
 * @author Endri Bezati
 */
public class LatencyAnalysis extends Analysis<LatencyReport> {

	private TraceWeighter weighter;

	private BufferSize bufferSize;

	private NetworkPartitioning partitioning;

	private Network network;

	Pair<String, String> srcLatency;

	List<Pair<String, String>> tgtLatencies;

	public LatencyAnalysis(TraceProject project, TraceWeighter weighter, BufferSize bufferSize,
			NetworkPartitioning partitioning, Pair<String, String> srcLatency,
			List<Pair<String, String>> tgtLatencies) {
		super(project);
		this.weighter = weighter;
		this.bufferSize = bufferSize;
		this.partitioning = partitioning;
		this.network = project.getNetwork();
		this.srcLatency = srcLatency;
		this.tgtLatencies = tgtLatencies;

	}

	private class LatencySimEngine extends SimEngine {

		Map<Pair<String, String>, List<Double>> measuredLatencies;
		List<Pair<String, String>> pairsToMeasure;

		public LatencySimEngine() {
			super();
			this.printActorStatus = true;
			pairsToMeasure = new ArrayList<>();
			pairsToMeasure.add(srcLatency);
			pairsToMeasure.addAll(tgtLatencies);

			measuredLatencies = new HashMap<>();
			measuredLatencies.put(srcLatency, new ArrayList<>());
			for (Pair<String, String> tgt : tgtLatencies) {
				measuredLatencies.put(tgt, new ArrayList<>());
			}

		}

		@Override
		protected void printActorStatus(double timer) {
			for (AtomicActor actor : model.getActors()) {
				for (Pair<String, String> tgt : pairsToMeasure) {
					if (actor.getCurrentStatus() == Status.END_FIRING) {
						if (actor.getActor().getName().equals(tgt.v1)) {
							if (actor.getCurrentAction().getName().equals(tgt.v2)) {
								measuredLatencies.get(tgt).add(timer);
							}
						}
					}
				}
			}
		}

		public Map<Pair<String, String>, List<Double>> getMeasuredLatencies() {
			return measuredLatencies;
		}

	}

	@Override
	public LatencyReport run() throws TurnusException {

		LatencySimEngine simulation = new LatencySimEngine();
		simulation.setTraceProject(project);
		simulation.setTraceWeighter(weighter);
		simulation.setNetworkPartitioning(partitioning);
		simulation.setBufferSize(bufferSize);
		simulation.setReleaseAfterProcessing();
		PostProcessingReport ppReport = simulation.run();

		ProfilingFactory f = ProfilingFactory.eINSTANCE;
		LatencyReport report = f.createLatencyReport();
		report.setNetwork(network);
		report.setAlgorithm("Latency Estimation");

		Map<Pair<String, String>, List<Double>> measuredLatencies = simulation.getMeasuredLatencies();
		List<Double> srcStartLatency = measuredLatencies.get(srcLatency);

		// -- Source latency
		{
			LatencyData data = f.createLatencyData();
			data.getLatency().addAll(srcStartLatency);
			Actor actor = network.getActor(srcLatency.v1);
			Action action = actor.getAction(srcLatency.v2);
			data.setActor(actor);
			data.setAction(action);

			Double throughput = srcStartLatency.get(srcStartLatency.size() - 1) / srcStartLatency.size();
			data.setThroughput(throughput);
			report.setSource(data);
		}

		// -- Target latencies
		for (Pair<String, String> tgt : tgtLatencies) {
			LatencyData data = f.createLatencyData();
			List<Double> tgtEndLatency = measuredLatencies.get(tgt);

			for (int i = 0; i < tgtEndLatency.size(); i++) {
				double latency = tgtEndLatency.get(i) - srcStartLatency.get(i);
				data.getLatency().add(latency);
			}

			Double throughput = tgtEndLatency.get(tgtEndLatency.size() - 1) / tgtEndLatency.size();

			Actor actor = network.getActor(tgt.v1);
			Action action = actor.getAction(tgt.v2);
			data.setActor(actor);
			data.setAction(action);
			data.setThroughput(throughput);
			report.getTargets().add(data);
		}
		report.setTime(ppReport.getTime());

		return report;
	}

}
