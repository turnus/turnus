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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.google.common.collect.ImmutableList;

import adevs.Atomic;
import adevs.Digraph.PortValue;
import turnus.adevs.logging.AdevsDataLogger;
import turnus.model.dataflow.Action;
import turnus.model.dataflow.Actor;

/**
 * This is an implementation of the Atomic Actor Partition.
 * 
 * @author Simone Casale-Brunet 
 * @author Malgorzata Michalska
 *
 */

public abstract class AtomicActorPartition extends Atomic<PortValue> {

	protected final String partitionId;
	protected final List<Actor> actors; // all actors belonging to this partition

	protected AdevsDataLogger dataLogger;

	// ----- THE OVERALL ACTORS PORT ID MAP
	private Map<Integer, Actor> ACTORS_PORTS_ID_MAP;

	// --- THE ACTORS PARTITIONER SCHEDULER PORTS
	private Map<Actor, Integer> PORT_PARTITION_SEND_ASK_SCHEDULABILITY;
	private Map<Actor, Integer> PORT_PARTITION_RECEIVE_SCHEDULABILITY;
	private Map<Actor, Integer> PORT_PARTITION_SEND_ENABLE;
	private Map<Actor, Integer> PORT_PARTITION_RECEIVE_END_OF_FIRING;
	private Map<Actor, Integer> PORT_PARTITION_RECEIVE_END_OF_READING;

	public enum Status {
		IDLE, CHECK_SCHEDULABILITY, WAITING, SCHEDULING;
	}

	protected Status status = Status.CHECK_SCHEDULABILITY;

	
	protected List<Actor> runningActors = new ArrayList<Actor>();
	protected List<Actor> schedulableActors = new ArrayList<Actor>();
	
	private List<Actor> aliveActors; // actors that have not terminated yet
	private List<Actor> actorsToCheck = new ArrayList<Actor>(); // actors whose schedulability must be verified
	private List<Actor> blockedReadingActors = new ArrayList<Actor>();
	private List<Actor> blockedWritingActors = new ArrayList<Actor>();
	
	private List<Actor> endReadingQueue = new ArrayList<Actor>();
	private Map<Actor, Object[]> endFiringQueue = new HashMap<Actor, Object[]>(); // used to store the received end-of-firing signals, 
																				// if they arrive simultaneously to the check schedulability procedure
	private double schedulabilityReceived = 0;
	protected double localTime = 0;
	
	private Action lastExecutedAction = null;
	protected double lastPartitionFinishTime = 0;
	
	protected AtomicActorPartition(List<Actor> actors, String partitionId){
		this.actors = ImmutableList.copyOf(actors);
		this.aliveActors = new ArrayList<Actor>(actors);
		this.partitionId = partitionId;
		this.actorsToCheck.addAll(aliveActors);
	}

	public void configure(PortsIdentifier portIds) {
		ACTORS_PORTS_ID_MAP = portIds.ACTORS_PORTS_ID_MAP;
		PORT_PARTITION_SEND_ASK_SCHEDULABILITY = portIds.PORT_PARTITION_SEND_ASK_SCHEDULABILITY;
		PORT_PARTITION_RECEIVE_SCHEDULABILITY = portIds.PORT_PARTITION_RECEIVE_SCHEDULABILITY;
		PORT_PARTITION_SEND_ENABLE = portIds.PORT_PARTITION_SEND_ENABLE;
		PORT_PARTITION_RECEIVE_END_OF_FIRING = portIds.PORT_PARTITION_RECEIVE_END_OF_FIRING;
		PORT_PARTITION_RECEIVE_END_OF_READING = portIds.PORT_PARTITION_RECEIVE_END_OF_READING;
	}

	@Override
	public void delta_conf(Collection<PortValue> xb) {
		delta_int();
		delta_ext(0.0, xb);
	}

	@Override
	public void delta_int() {
		//Logger.debug("delta_int at %f : actor partition=%s", localTime, this.toString());
	}

	@Override
	public void delta_ext(double e, Collection<PortValue> xb) {
		//Logger.debug("delta_ext at %f : actor partition=%s", localTime, this.toString());
		localTime += e;
		for (PortValue inPortValue : xb) {
			int port = inPortValue.getPort();
			Actor actor = ACTORS_PORTS_ID_MAP.get(port);
			if (port == PORT_PARTITION_RECEIVE_END_OF_FIRING.get(actor)) {
				if (actors.contains(actor)) {
					lastPartitionFinishTime = localTime;
				}
				if (status == Status.IDLE) {
					Object[] receivedEndData = (Object[])inPortValue.getValue();
					processEndFiring(actor, (boolean)receivedEndData[1], (Action)receivedEndData[0]);
					if (canExecute())
						status = Status.CHECK_SCHEDULABILITY;
				} else { // ongoing schedulability check procedure
					endFiringQueue.put(actor, (Object[])inPortValue.getValue());
				}
			} else if (port == PORT_PARTITION_RECEIVE_END_OF_READING.get(actor)) { // this part should be deactivated if an option is used
				if (status == Status.IDLE) {
					processEndReading(actor);
					if (canExecute())
						status = Status.CHECK_SCHEDULABILITY;
				} else { // ongoing schedulability check procedure
					endReadingQueue.add(actor);
				}
			} else if (port == PORT_PARTITION_RECEIVE_SCHEDULABILITY.get(actor)) {
				int value = (int) inPortValue.getValue();
				schedulabilityReceived++;
				if (value == 0) { // 0 = is schedulable
					schedulableActors.add(actor);
				}
				else if (value == 1) { // 1 = is blocked reading
					blockedReadingActors.add(actor);
				}
				else if (value == 2) { // 2 = is blocked writing
					blockedWritingActors.add(actor);
				}
				// remove the first condition?
				if (status == Status.WAITING && schedulabilityReceived == actorsToCheck.size())
					status = Status.SCHEDULING; // start scheduling if schedulability information received from all actors
			}
		}
	}
	
	private void processEndFiring(Actor actor, boolean isAlive, Action executedAction) {
		if (actors.contains(actor)) // update only if it is an actor of THIS partition
			lastExecutedAction = executedAction;
		
		if (!isAlive) { // isAlive: true if there is at least one more step to be fired.
			aliveActors.remove(actor);
			dataLogger.logActorTerminated(partitionId, actor, localTime);
		}
		
		runningActors.remove(actor);
		blockedReadingActors.removeAll(actor.getSuccessors()); // successors in the blocked reading state must be re-checked
		blockedWritingActors.removeAll(actor.getPredecessors()); // predecessors in the blocked writing state must be re-checked
		
		actorsToCheck.clear();
		actorsToCheck.addAll(aliveActors); 
		actorsToCheck.removeAll(runningActors); 
		actorsToCheck.removeAll(schedulableActors); 
		actorsToCheck.removeAll(blockedReadingActors); 
		actorsToCheck.removeAll(blockedWritingActors); 
		
		// at this stage actorsToCheck should contain only the actors 
		// whose schedulability cannot be deduced and must be checked
	}
	
	private void processEndReading(Actor actor) {
		if (!actors.contains(actor)) { // applies only if it's an actor from ANOTHER partition
			blockedWritingActors.removeAll(actor.getPredecessors()); // predecessors in the blocked writing state must be re-checked
			
			actorsToCheck.clear();
			actorsToCheck.addAll(aliveActors); 
			actorsToCheck.removeAll(runningActors); 
			actorsToCheck.removeAll(schedulableActors); 
			actorsToCheck.removeAll(blockedReadingActors); 
			actorsToCheck.removeAll(blockedWritingActors); 
			
			// at this stage actorsToCheck should contain only the actors 
			// whose schedulability cannot be deduced and must be checked
		}
	}

	@Override
	public void output_func(Collection<PortValue> yb) {
		//Logger.debug("output_func at %f : actor partition=%s", localTime, this.toString());
		switch (status) {
		case CHECK_SCHEDULABILITY: {
			if (!actorsToCheck.isEmpty()) {
				for (Actor actor : actorsToCheck) {
					yb.add(new PortValue(PORT_PARTITION_SEND_ASK_SCHEDULABILITY.get(actor), true));
				}
				schedulabilityReceived = 0;
				status = Status.WAITING;
			} else if (!schedulableActors.isEmpty() && canExecute()) {
				status = Status.SCHEDULING;
			} else if (endReadingQueue.isEmpty() && endFiringQueue.isEmpty()) {
				status = Status.IDLE;
				actorsToCheck.clear();
			} else if (!endReadingQueue.isEmpty()) {
				Actor endReading = endReadingQueue.iterator().next();
				processEndReading(endReading);
				endReadingQueue.remove(endReading);
			} else { 
				Entry<Actor, Object[]> endFiring = endFiringQueue.entrySet().iterator().next();
				processEndFiring(endFiring.getKey(), (boolean)endFiring.getValue()[1], (Action)endFiring.getValue()[0]);
				endFiringQueue.remove(endFiring.getKey());
			}
			// stay in CHECK_SCHEDULABILITY state till all enqueued end-of-reading / end-of-firing signals are processed
				
			break;
		}
		case SCHEDULING: {
			for (Actor actor : getSchedulables()) { // getSchedulables() is implemented differently for different scheduler types
				runningActors.add(actor);
				schedulableActors.remove(actor);
				yb.add(new PortValue(PORT_PARTITION_SEND_ENABLE.get(actor), lastExecutedAction));
				dataLogger.logScheduleActor(partitionId, actor, localTime);
			}
			if (endReadingQueue.isEmpty() && endFiringQueue.isEmpty()) {
				status = Status.IDLE;
				actorsToCheck.clear();
			} else if (!endReadingQueue.isEmpty()) {
				Actor endReading = endReadingQueue.iterator().next();
				processEndReading(endReading);
				endReadingQueue.remove(endReading);
				status = Status.CHECK_SCHEDULABILITY;
			} else { // process the enqueued end-of-firing signals
				Entry<Actor, Object[]> endFiring = endFiringQueue.entrySet().iterator().next();
				processEndFiring(endFiring.getKey(), (boolean)endFiring.getValue()[1], (Action)endFiring.getValue()[0]);
				endFiringQueue.remove(endFiring.getKey());
				status = Status.CHECK_SCHEDULABILITY;
			}
			break;
		}
		default:
			break;
		}
	}

	@Override
	public double ta() {
		switch (status) {
		case IDLE:
			return Double.MAX_VALUE;
		case CHECK_SCHEDULABILITY:
			return 0;
		case WAITING:
			return Double.MAX_VALUE;
		case SCHEDULING:
			return 0;
		}
		return Double.MAX_VALUE;
	}

	public String getId() {
		return partitionId;
	}

	public void setDataLogger(AdevsDataLogger dataLogger) {
		this.dataLogger = dataLogger;
	}

	public abstract List<Actor> getSchedulables();

	public abstract boolean canExecute();
}
