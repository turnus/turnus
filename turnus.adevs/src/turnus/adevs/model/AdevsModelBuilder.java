/* 
 * TURNUS - www.turnus.co
 * 
 * Copyright (C) 2010-2016 EPFL SCI STI MM
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
package turnus.adevs.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

import turnus.adevs.schedulers.FullParallelPartition;
import turnus.adevs.schedulers.NonPreemptivePartition;
import turnus.adevs.schedulers.RoundRobinPartition;
import turnus.common.TurnusRuntimeException;
import turnus.model.dataflow.Actor;
import turnus.model.dataflow.Buffer;
import turnus.model.dataflow.Network;
import turnus.model.mapping.BufferSize;
import turnus.model.mapping.CommunicationWeight;
import turnus.model.mapping.NetworkPartitioning;
import turnus.model.mapping.SchedulingWeight;
import turnus.model.trace.Step;
import turnus.model.trace.Trace;
import turnus.model.trace.Trace.Order;
import turnus.model.trace.TraceDecorator;
import turnus.model.trace.TraceProject;
import turnus.model.trace.weighter.TraceWeighter;

/**
 * 
 * @author Simone Casale-Brunet 
 * @author Malgorzata Michalska
 *
 */
public class AdevsModelBuilder {

	private TraceProject traceProject;
	private TraceWeighter traceWeighter;
	private NetworkPartitioning partitioning;
	private BufferSize bufferSize;
	private CommunicationWeight communicationWeight;
	private SchedulingWeight schedulingWeight;
	private boolean releaseAfterProcessing;
	
	public AdevsModelBuilder(TraceProject traceProject, TraceWeighter traceWeighter, NetworkPartitioning partitioning, 
			BufferSize bufferSize, CommunicationWeight communicationWeight, SchedulingWeight schedulingWeight, boolean release) {
		this.traceProject = traceProject;
		this.traceWeighter = traceWeighter;
		this.partitioning = partitioning;
		this.bufferSize = bufferSize;
		this.communicationWeight = communicationWeight;
		this.schedulingWeight = schedulingWeight;
		this.releaseAfterProcessing = release;
	}
	
	public AdevsModel build() {
		Network network = traceProject.getNetwork();
		Trace trace = traceProject.getTrace();
		TraceDecorator traceDecorator = traceProject.getTraceDecorator();
		AdevsModel model = new AdevsModel();
		PortsIdentifier portsIdentifier = new PortsIdentifier(network);
		
		for (Buffer buffer : network.getBuffers()) {
			AtomicBuffer atomicBuffer = new AtomicBuffer(buffer, bufferSize.getSize(buffer));
			if (communicationWeight != null) {
				atomicBuffer.setReadCommunicationCost(communicationWeight.getReadWeights(buffer));
				atomicBuffer.setWriteConstants(communicationWeight.getWriteHitConstant(), communicationWeight.getWriteMissConstant());
				atomicBuffer.setWriteCommunicationCost(communicationWeight.getWriteWeights(buffer));
			}
			model.add(atomicBuffer);
		}
		
		for (Actor actor : network.getActors()) {
			Iterator<Step> steps = trace.getSteps(Order.INCREASING_ID, actor.getName()).iterator();
			AtomicActor atomicActor = new AtomicActor(actor, steps, traceWeighter, schedulingWeight, traceDecorator);
			if (releaseAfterProcessing)
				atomicActor.setReleaseAfterProcessinng();
			atomicActor.configure(portsIdentifier);
			model.add(atomicActor);
			
			// couple each actor with incoming fifos
			for (Buffer buffer : actor.getIncomingBuffers()) {
				AtomicBuffer atomicBuffer = model.getBuffer(buffer);
				model.couple(atomicBuffer, AtomicBuffer.PORT_TX_SEND_HAS_TOKENS, atomicActor, portsIdentifier.PORT_IN_RECEIVE_HAS_TOKENS.get(buffer));
				model.couple(atomicBuffer, AtomicBuffer.PORT_TX_SEND_TOKENS, atomicActor, portsIdentifier.PORT_IN_RECEIVE_TOKENS.get(buffer));	
				model.couple(atomicActor, portsIdentifier.PORT_IN_SEND_ASK_TOKENS.get(buffer), atomicBuffer, AtomicBuffer.PORT_TX_RECEIVE_ASK_TOKENS);
				model.couple(atomicActor, portsIdentifier.PORT_IN_SEND_HAS_TOKENS.get(buffer), atomicBuffer, AtomicBuffer.PORT_TX_RECEIVE_HAS_TOKENS);
				model.couple(atomicActor, portsIdentifier.PORT_IN_RELEASE_BUFFER.get(buffer), atomicBuffer, AtomicBuffer.PORT_TX_RECEIVE_RELEASE_BUFFER);
			}
			
			// couple each actor with outgoing fifos
			for (Buffer buffer : actor.getOutgoingBuffers()) {
				AtomicBuffer atomicBuffer = model.getBuffer(buffer);
				model.couple(atomicActor, portsIdentifier.PORT_OUT_SEND_HAS_SPACE.get(buffer), atomicBuffer, AtomicBuffer.PORT_RX_RECEIVE_HAS_SPACE);
				model.couple(atomicActor, portsIdentifier.PORT_OUT_SEND_TOKENS.get(buffer), atomicBuffer, AtomicBuffer.PORT_RX_RECEIVE_TOKENS);
				model.couple(atomicBuffer, AtomicBuffer.PORT_RX_SEND_HAS_SPACE, atomicActor, portsIdentifier.PORT_OUT_RECEIVE_HAS_SPACE.get(buffer));
				model.couple(atomicBuffer, AtomicBuffer.PORT_RX_SEND_TOKENS_RECEIVED, atomicActor, portsIdentifier.PORT_OUT_RECEIVE_TOKENS_RECEIVED.get(buffer));
			}
		}
		
		// build a single buffer partition (all fifos together, all enabled - TODO: communication interfaces)
		Collection<Buffer> buffers = network.getBuffers();
		AtomicBufferPartition bufferPartition = new AtomicBufferPartition(buffers);
		bufferPartition.configure(portsIdentifier);
		model.add(bufferPartition);
				
		for (Buffer buffer : buffers) {
			AtomicBuffer atomicBuffer = model.getBuffer(buffer);
			model.couple(bufferPartition, portsIdentifier.PORT_OUT_SEND_ENABLE_RX.get(buffer), atomicBuffer, AtomicBuffer.PORT_RX_ENABLE);
			model.couple(bufferPartition, portsIdentifier.PORT_OUT_SEND_ENABLE_TX.get(buffer), atomicBuffer, AtomicBuffer.PORT_TX_ENABLE);
		}
		
		// build actor partitions according to a NetworkPartitioning Object (read from file or given by an algorithm)
		for (Entry<String, List<String>> partitionUnit : partitioning.asPartitionActorsMap().entrySet()) {
			String component = partitionUnit.getKey();
			List<Actor> targetActors = getActorObjectsList(partitionUnit.getValue(), network);
			
			AtomicActorPartition actorPartition = getPartitionObject(partitioning.getScheduler(component), component, targetActors);
			actorPartition.configure(portsIdentifier);
			model.add(actorPartition);
			
			for (Actor actor : targetActors) {
				AtomicActor atomicActor = model.getActor(actor);
				model.couple(actorPartition, portsIdentifier.PORT_PARTITION_SEND_ASK_SCHEDULABILITY.get(actor), atomicActor, AtomicActor.PORT_PARTITION_RECEIVE_ASK_SCHEDULABILITY);
				model.couple(actorPartition, portsIdentifier.PORT_PARTITION_SEND_ENABLE.get(actor), atomicActor, AtomicActor.PORT_PARTITION_RECEIVE_ENABLE);
				model.couple(atomicActor, AtomicActor.PORT_PARTITION_SEND_SCHEDULABILITY, actorPartition, portsIdentifier.PORT_PARTITION_RECEIVE_SCHEDULABILITY.get(actor));
			}
		}
		
		for (Actor actor : network.getActors()) {
			AtomicActor atomicActor = model.getActor(actor);
			for (String partitionId : partitioning.asPartitionActorsMap().keySet()) {
				AtomicActorPartition atomicActorPartition = model.getAtomicActorPartition(partitionId);
				model.couple(atomicActor, AtomicActor.PORT_PARTITION_SEND_END_OF_FIRING, atomicActorPartition, portsIdentifier.PORT_PARTITION_RECEIVE_END_OF_FIRING.get(atomicActor.getActor()));
				model.couple(atomicActor, AtomicActor.PORT_PARTITION_SEND_END_OF_READING, atomicActorPartition, portsIdentifier.PORT_PARTITION_RECEIVE_END_OF_READING.get(atomicActor.getActor()));
			}
		}
		
		return model;
	}
	
	private List<Actor> getActorObjectsList(List<String> actorsName, Network network) {
		List<Actor> targetActors = new ArrayList<Actor>();
		for(String actorName : actorsName){
			Actor actor = network.getActor(actorName);
			if(actor == null){
				throw new TurnusRuntimeException("Actor "+actorName+" not found on this network");
			}
			targetActors.add(actor);
			
		}
		
		return targetActors;
	}
	
	private AtomicActorPartition getPartitionObject(String scheduling, String partitionId, List<Actor> targetActors) {
		switch (scheduling) {
		case "FULL_PARALLEL":
			return new FullParallelPartition(targetActors, partitionId);
		case "ROUND_ROBIN":
			return new RoundRobinPartition(targetActors, partitionId);
		case "NON_PREEMPTIVE":
			return new NonPreemptivePartition(targetActors, partitionId);
		default:
			return new FullParallelPartition(targetActors, partitionId);
		}
	}
}
