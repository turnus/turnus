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

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import turnus.adevs.logging.impl.ActorStatisticsCollector;
import turnus.analysis.Analysis;
import turnus.analysis.bottlenecks.AlgorithmicPartialCriticalPathAnalysis;
import turnus.analysis.bottlenecks.ScheduledPartialCriticalPathAnalysis;
import turnus.common.TurnusException;
import turnus.model.analysis.bottlenecks.BottlenecksReport;
import turnus.model.analysis.bottlenecks.BottlenecksWithSchedulingReport;
import turnus.model.analysis.postprocessing.ActorStatisticsReport;
import turnus.model.analysis.profiling.InterPartitionCommunicationAndMemoryReport;
import turnus.model.analysis.profiling.InterPartitionData;
import turnus.model.analysis.profiling.ProfilingFactory;
import turnus.model.analysis.profiling.util.MemoryAndBuffers;
import turnus.model.dataflow.Actor;
import turnus.model.dataflow.Buffer;
import turnus.model.dataflow.Network;
import turnus.model.dataflow.Port;
import turnus.model.mapping.BufferSize;
import turnus.model.mapping.CommunicationWeight;
import turnus.model.mapping.NetworkPartitioning;
import turnus.model.trace.Step;
import turnus.model.trace.Trace.Order;
import turnus.model.trace.TraceDecorator;
import turnus.model.trace.TraceProject;
import turnus.model.trace.weighter.TraceWeighter;

/**
 * @author Endri Bezati
 */
public class InterPartitionCommunicationAndMemoryAnalysis extends Analysis<InterPartitionCommunicationAndMemoryReport> {

	private TraceWeighter weighter;

	private BufferSize bufferSize;

	private NetworkPartitioning partitioning;

	private CommunicationWeight communication;

	private Network network;

	private boolean outgoingBufferOwnedBySource;

	private Map<Actor, Double> actorWorkloadMap;

	private Map<Buffer, Long> bufferMaxIncomingBitsMap;
	private Map<Buffer, Long> bufferMaxOutgoingBitsMap;

	private TraceDecorator decorator;

	public InterPartitionCommunicationAndMemoryAnalysis(TraceProject project, TraceWeighter weighter,
			BufferSize bufferSize, NetworkPartitioning partitioning, CommunicationWeight communication,
			boolean outgoingBufferOwnedBySource) {
		super(project);
		this.weighter = weighter;
		this.bufferSize = bufferSize;
		this.partitioning = partitioning;
		this.outgoingBufferOwnedBySource = outgoingBufferOwnedBySource;
		this.network = project.getNetwork();
		this.actorWorkloadMap = new HashMap<Actor, Double>();
		this.bufferMaxIncomingBitsMap = new HashMap<>();
		this.bufferMaxOutgoingBitsMap = new HashMap<>();

		this.communication = communication;
		this.decorator = project.getTraceDecorator();
	}

	/**
	 * Calculate the actor workload and the max incoming and outgoing data from an
	 * actor
	 */
	private void processTrace() {

		for (Buffer buffer : project.getNetwork().getBuffers()) {
			bufferMaxIncomingBitsMap.put(buffer, 0L);
			bufferMaxOutgoingBitsMap.put(buffer, 0L);
		}

		for (Actor actor : project.getNetwork().getActors()) {
			Iterator<Step> steps = project.getTrace().getSteps(Order.INCREASING_ID, actor.getName()).iterator();
			double sum = 0;
			while (steps.hasNext()) {
				Step next = steps.next();
				for (Entry<Buffer, Integer> entry : decorator.getReadTokens(next).entrySet()) {
					Long currentMax = bufferMaxIncomingBitsMap.get(entry.getKey());
					Port port = entry.getKey().getTarget();
					Long neccessaryBitsPerRead = entry.getValue() * port.getType().getBits();
					if (neccessaryBitsPerRead > currentMax) {
						bufferMaxIncomingBitsMap.put(entry.getKey(), neccessaryBitsPerRead);
					}
				}
				for (Entry<Buffer, Integer> entry : decorator.getWriteTokens(next).entrySet()) {
					Long currentMax = bufferMaxOutgoingBitsMap.get(entry.getKey());
					Port port = entry.getKey().getSource();
					Long neccessaryBitsPerWrtie = entry.getValue() * port.getType().getBits();
					if (neccessaryBitsPerWrtie > currentMax) {
						bufferMaxOutgoingBitsMap.put(entry.getKey(), neccessaryBitsPerWrtie);
					}
				}

				sum += weighter.getWeight(next);
			}
			actorWorkloadMap.put(actor, sum);
		}

	}

	private long getTotalBitsOfBuffer(Buffer buffer) {
		int depth = bufferSize.getSize(buffer);
		long bits = buffer.getType().getBits();
		return depth * bits;
	}

	@Override
	public InterPartitionCommunicationAndMemoryReport run() throws TurnusException {
		ProfilingFactory f = ProfilingFactory.eINSTANCE;
		InterPartitionCommunicationAndMemoryReport report = f.createInterPartitionCommunicationAndMemoryReport();
		report.setNetwork(network);
		report.setOutgoingBufferOwnedBySource(outgoingBufferOwnedBySource);
		report.setAlgorithm("Inter Partition Communication and Memory Analysis");

		// -- Populate actor partition map
		for (Actor actor : network.getActors()) {
			report.getActorPartitionMap().put(actor, partitioning.getPartition(actor));
		}

		// -- Populate Buffer depth map
		for (Buffer buffer : network.getBuffers()) {
			report.getBufferDepthMap().put(buffer, bufferSize.getSize(buffer));
		}

		// -- Initialize partial critical path
		AlgorithmicPartialCriticalPathAnalysis cpAnalysis = new AlgorithmicPartialCriticalPathAnalysis(project);
		cpAnalysis.setConfiguration(configuration);
		cpAnalysis.setWeighter(weighter);
		cpAnalysis.setBufferSize(bufferSize);

		// -- Run partial critical path analysis
		BottlenecksReport initialCp = cpAnalysis.run();
		double cpLength = initialCp.getCpWeight();
		report.setCpWeight(cpLength);

		// -- Scheduled partial critical path analysis, contains also post-processing
		// simulation
		ScheduledPartialCriticalPathAnalysis cpAnalysisScheduled = new ScheduledPartialCriticalPathAnalysis(project);
		cpAnalysisScheduled.setConfiguration(configuration);
		ActorStatisticsCollector actorStatsCollector = new ActorStatisticsCollector(network, partitioning);
		cpAnalysisScheduled.registerCollector(actorStatsCollector);
		if (communication != null) {
			cpAnalysisScheduled.setCommunicationWeight(communication);
		}

		// -- Get scheduled partial critical path analysis, and set necessary values to
		// the report
		BottlenecksWithSchedulingReport bottlenecksWithSchedulingReport = cpAnalysisScheduled.run();
		double cpLengthScheduled = bottlenecksWithSchedulingReport.getCpWeight();
		double scheduledExecutionTime = bottlenecksWithSchedulingReport.getExecutionTime();

		report.setCpWeightScheduled(cpLengthScheduled);
		report.setTime(scheduledExecutionTime);
		report.setDeadlock(bottlenecksWithSchedulingReport.isDeadlock());

		// -- Visit Partitions
		Map<String, List<String>> pMap = partitioning.asPartitionActorsMap();

		// -- Calculate workload for each actor
		processTrace();

		ActorStatisticsReport actorStatsReport = actorStatsCollector.generateReport();

		for (String partId : pMap.keySet()) {
			List<String> actorInstances = pMap.get(partId);

			// -- Create an InterPartitionData
			InterPartitionData partitionDatum = f.createInterPartitionData();

			// -- Set partition Id
			partitionDatum.setPartitionId(partId);

			// -- Set occupancy
			double occupancy = actorStatsReport.getPartitions().get(partId).getOccupancy();
			partitionDatum.setOccupancy(occupancy);

			// -- Add actor instances
			for (String actorInstance : actorInstances) {
				Actor actor = network.getActor(actorInstance);
				partitionDatum.getActors().add(actor);
			}

			// -- Partition workload
			long partitionWorkload = 0L;
			for (Actor actor : partitionDatum.getActors()) {
				partitionWorkload += actorWorkloadMap.get(actor);
			}

			// -- Partition maxIncomingData
			List<Buffer> incomingBuffers = MemoryAndBuffers.getIncomingBuffersOfPartition(partitionDatum.getActors());
			Long maxIncomingData = 0L;
			for (Buffer buffer : incomingBuffers) {
				if (bufferMaxIncomingBitsMap.get(buffer) > maxIncomingData) {
					maxIncomingData = bufferMaxIncomingBitsMap.get(buffer);
				}
			}

			// -- Partition maxOutgoingData
			List<Buffer> outgoingBuffers = MemoryAndBuffers.getOutgoingBuffersOfPartition(partitionDatum.getActors());
			Long maxOutgoingData = 0L;
			for (Buffer buffer : outgoingBuffers) {
				if (bufferMaxOutgoingBitsMap.get(buffer) > maxOutgoingData) {
					maxOutgoingData = bufferMaxOutgoingBitsMap.get(buffer);
				}
			}

			// -- Set max incoming and outgoing
			partitionDatum.setMaxIncomingBitsPerFiring(maxIncomingData);
			partitionDatum.setMaxOutgoingBitsPerFiring(maxOutgoingData);

			partitionDatum.setWorkload(partitionWorkload);

			// -- Get actors persistent memory
			long actorsPersistentMemory = MemoryAndBuffers.getActorsPesistenMemory(partitionDatum.getActors());

			// -- Get internal buffers persistent memory
			List<Buffer> internalBuffers = MemoryAndBuffers.getInternalBuffersOfPartition(partitionDatum.getActors());
			partitionDatum.getInternalBuffers().addAll(internalBuffers);
			long internalBuffersPersistentMemory = 0L;

			for (Buffer buffer : internalBuffers) {
				internalBuffersPersistentMemory += getTotalBitsOfBuffer(buffer);
			}

			partitionDatum.getOutgoingBuffers().addAll(outgoingBuffers);
			partitionDatum.getIncomingBuffers().addAll(incomingBuffers);

			if (outgoingBufferOwnedBySource) {
				for (Buffer buffer : outgoingBuffers) {
					internalBuffersPersistentMemory += getTotalBitsOfBuffer(buffer);
				}
			} else {
				for (Buffer buffer : incomingBuffers) {
					internalBuffersPersistentMemory += getTotalBitsOfBuffer(buffer);
				}
			}
			// -- Set partition persistent actors memory and buffers
			partitionDatum.setPersistentMemory(actorsPersistentMemory);
			partitionDatum.setPersistentBuffers(internalBuffersPersistentMemory);

			// -- END
			// -- Add partitionDatum to partitionData
			report.getPartitionData().add(partitionDatum);
		}

		return report;
	}

}
