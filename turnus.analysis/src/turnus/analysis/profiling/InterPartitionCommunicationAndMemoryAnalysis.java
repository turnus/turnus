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
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import turnus.analysis.Analysis;
import turnus.common.TurnusException;
import turnus.model.analysis.profiling.InterPartitionCommunicationAndMemoryReport;
import turnus.model.analysis.profiling.InterPartitionData;
import turnus.model.analysis.profiling.ProfilingFactory;
import turnus.model.analysis.profiling.util.MemoryAndBuffers;
import turnus.model.dataflow.Actor;
import turnus.model.dataflow.Buffer;
import turnus.model.dataflow.Network;
import turnus.model.mapping.BufferSize;
import turnus.model.mapping.NetworkPartitioning;
import turnus.model.trace.Step;
import turnus.model.trace.Trace.Order;
import turnus.model.trace.TraceProject;
import turnus.model.trace.weighter.TraceWeighter;

/**
 * @author Endri Bezati
 */
public class InterPartitionCommunicationAndMemoryAnalysis extends Analysis<InterPartitionCommunicationAndMemoryReport> {

	private TraceWeighter weighter;

	private BufferSize bufferSize;

	private NetworkPartitioning partitioning;

	private Network network;

	private boolean outgoingBufferOwnedBySource;

	public InterPartitionCommunicationAndMemoryAnalysis(TraceProject project, TraceWeighter weighter,
			BufferSize bufferSize, NetworkPartitioning partitioning, boolean outgoingBufferOwnedBySource) {
		super(project);
		this.weighter = weighter;
		this.bufferSize = bufferSize;
		this.partitioning = partitioning;
		this.outgoingBufferOwnedBySource = outgoingBufferOwnedBySource;
		this.network = project.getNetwork();
	}

	private Map<Actor, Double> calculateActorWorkloads() {
		Map<Actor, Double> workloads = new HashMap<Actor, Double>();

		for (Actor actor : project.getNetwork().getActors()) {
			Iterator<Step> steps = project.getTrace().getSteps(Order.INCREASING_ID, actor.getName()).iterator();
			double sum = 0;
			while (steps.hasNext()) {
				Step next = steps.next();
				sum += weighter.getWeight(next);
			}
			workloads.put(actor, sum);
		}

		return workloads;
	}

	private InterPartitionCommunicationAndMemoryReport generateReport(List<InterPartitionData> data) {
		ProfilingFactory f = ProfilingFactory.eINSTANCE;
		InterPartitionCommunicationAndMemoryReport report = f.createInterPartitionCommunicationAndMemoryReport();
		report.setNetwork(network);
		report.setOutgoingBufferOwnedBySource(outgoingBufferOwnedBySource);
		report.setAlgorithm("Inter Partition Communication and Memory Analysis");

		for (InterPartitionData datum : data) {
			report.getPartitionData().add(datum);
		}

		return report;
	}

	private long getTotalBitsOfBuffer(Buffer buffer) {
		int depth = bufferSize.getSize(buffer);
		long bits = buffer.getType().getBits();
		return depth * bits;
	}

	@Override
	public InterPartitionCommunicationAndMemoryReport run() throws TurnusException {
		ProfilingFactory f = ProfilingFactory.eINSTANCE;
		List<InterPartitionData> partitionData = new ArrayList<>();

		// -- Visit Partitions
		Map<String, List<String>> pMap = partitioning.asPartitionActorsMap();

		// -- Calculate workload for each actor
		Map<Actor, Double> workload = calculateActorWorkloads();

		for (String partId : pMap.keySet()) {
			List<String> actorInstances = pMap.get(partId);

			// -- Create an InterPartitionData
			InterPartitionData partitionDatum = f.createInterPartitionData();

			// -- Set partition Id
			partitionDatum.setPartitionId(partId);

			// -- Add actor instances
			for (String actorInstance : actorInstances) {
				Actor actor = network.getActor(actorInstance);
				partitionDatum.getActors().add(actor);
			}

			// -- Partition workload
			long partitionWorkload = 0L;
			for (Actor actor : partitionDatum.getActors()) {
				partitionWorkload += workload.get(actor);
			}

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

			// -- Check if the owner of the incoming/outgoing is the current partition
			if (outgoingBufferOwnedBySource) {				
				List<Buffer> outgoingBuffers = MemoryAndBuffers
						.getOutgoingBuffersOfPartition(partitionDatum.getActors());
				partitionDatum.getExternalBuffers().addAll(outgoingBuffers);
				for (Buffer buffer : outgoingBuffers) {
					internalBuffersPersistentMemory += getTotalBitsOfBuffer(buffer);
				}
			} else {
				List<Buffer> incomingBuffers = MemoryAndBuffers
						.getIncomingBuffersOfPartition(partitionDatum.getActors());
				partitionDatum.getExternalBuffers().addAll(incomingBuffers);
				for (Buffer buffer : incomingBuffers) {
					internalBuffersPersistentMemory += getTotalBitsOfBuffer(buffer);
				}
			}

			// -- Set partition persistent actors memory and buffers
			partitionDatum.setPersistentMemory(actorsPersistentMemory);
			partitionDatum.setPersistentBuffers(internalBuffersPersistentMemory);
			

			// -- END
			// -- Add partitionDatum to partitionData
			partitionData.add(partitionDatum);
		}

		return generateReport(partitionData);
	}

}
