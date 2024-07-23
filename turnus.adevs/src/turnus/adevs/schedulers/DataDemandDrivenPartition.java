package turnus.adevs.schedulers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import turnus.adevs.model.AtomicActorPartition;
import turnus.model.dataflow.Actor;
import turnus.model.dataflow.Buffer;

/**
 * 
 * @author Endri Bezati
 *
 */
public class DataDemandDrivenPartition extends AtomicActorPartition {

	private Queue<Actor> waitingList;
	private Actor currentActor;
	private int next;

	public DataDemandDrivenPartition(List<Actor> actors, String partitionId, int processingElements) {
		super(actors, partitionId, processingElements);
		waitingList = new LinkedList<>();
		next = 0;
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
			if (currentActor != null) {
				if (blockedReadingActors.contains(currentActor)) {
					for (Actor actor : getPredecessors(currentActor)) {
						if (schedulableActors.contains(actor)) {
							if (!waitingList.contains(actor))
								waitingList.add(actor);
						}
					}
				} else {
					for (Actor actor : getSuccessors(currentActor)) {
						if (schedulableActors.contains(actor)) {
							if (!waitingList.contains(actor))
								waitingList.add(actor);
						}
					}
				}

				if (waitingList.isEmpty()) {
					currentActor = getNextRR();
				} else {
					currentActor = getNextDD();
				}
			} else {
				currentActor = getNextRR();
			}

			// System.out.println(currentActor);

			actorsToExecute.add(currentActor);
		}

		return actorsToExecute;
	}

	private Actor getNextRR() {
		List<Actor> actorsToExecute = new ArrayList<>();
		while (actorsToExecute.isEmpty()) {
			if (next == actors.size())
				next = 0;
			Actor nextActor = actors.get(next);
			if (schedulableActors.contains(nextActor)) {
				actorsToExecute.add(actors.get(next));
			}
			next++;
		}

		return actorsToExecute.get(0);
	}

	private Actor getNextDD() {
		Actor actor = waitingList.poll();
		next = actors.indexOf(actor);
		next++;
		return actor;
	}

	@Override
	public boolean canExecute() {
		return runningActors.isEmpty();
	}

	
}
