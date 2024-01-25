package turnus.adevs.schedulers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import turnus.adevs.model.AtomicActorPartition;
import turnus.model.dataflow.Actor;
import turnus.model.dataflow.Buffer;

public class DataDemandDrivenPartition extends AtomicActorPartition {

	private Queue<Actor> waitingList;
	private Actor currentActor;
	private boolean start;

	public DataDemandDrivenPartition(List<Actor> actors, String partitionId) {
		super(actors, partitionId);
		waitingList = new LinkedList<>();
		start = true;
	}

	private List<Actor> getPredecessors(Actor actor) {
		List<Actor> predecessors = new ArrayList<>();
		for (Buffer buffer : actor.getIncomingBuffers()) {
			predecessors.add(buffer.getSource().getOwner());
		}

		return predecessors;
	}

	private List<Actor> getSuccessors(Actor actor) {
		List<Actor> successors = new ArrayList<>();
		for (Buffer buffer : actor.getOutgoingBuffers()) {
			successors.add(buffer.getTarget().getOwner());
		}
		return successors;
	}

	@Override
	public List<Actor> getSchedulables() {
		List<Actor> actorsToExecute = new ArrayList<>();

		if (!schedulableActors.isEmpty()) {
			//System.out.println("S:" + schedulableActors);
			//System.out.println("WB:" + waitingList);
			if (waitingList.isEmpty()) {
				// -- inverse order 
				//Collections.reverse(schedulableActors);
				
				if(start) {
					waitingList.addAll(schedulableActors);
					start = false;
				} else {
					waitingList.offer(schedulableActors.get(schedulableActors.size() - 1));
				}
				
			
				currentActor = waitingList.poll();
				//System.out.println("WA:" + waitingList);
				if (partitionId.equals("0")) {
					System.out.println(currentActor);
					System.out.println();
				}
				actorsToExecute.add(currentActor);
			} else {
				// -- Successors
				List<Actor> successors = getSuccessors(currentActor);

				for (Actor actor : successors) {
					if (schedulableActors.contains(actor)) {
						if (!waitingList.contains(actor)) {
							waitingList.offer(actor);
						}
					}
				}

				// -- Predecessors
				List<Actor> predecessors = getPredecessors(currentActor);
				for (Actor actor : predecessors) {
					if (schedulableActors.contains(actor)) {
						if (!waitingList.contains(actor)) {
							//if(!actor.getIncomingBuffers().isEmpty()) {
								waitingList.offer(actor);								
							//}
						}
					}
				}

				currentActor = waitingList.poll();
				//System.out.println("WA:" + waitingList);
				if (partitionId.equals("0")) {
					System.out.println(currentActor);
					System.out.println();
				}

	
				actorsToExecute.add(currentActor);
			}

		}

		return actorsToExecute;
	}

	@Override
	public boolean canExecute() {
		return runningActors.isEmpty();
	}

	@Override
	public int parallelActors() {
		return 1;
	}

}
