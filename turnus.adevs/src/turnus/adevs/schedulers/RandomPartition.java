package turnus.adevs.schedulers;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import turnus.adevs.model.AtomicActorPartition;
import turnus.model.dataflow.Actor;

/**
 * A Random partition scheduler
 * 
 * @author Endri Bezati
 *
 */

public class RandomPartition extends AtomicActorPartition {

	public RandomPartition(List<Actor> actors, String partitionId) {
		super(actors, partitionId);
	}

	@Override
	public List<Actor> getSchedulables() {
		List<Actor> actorsToExecute = new ArrayList<>();
		if (!schedulableActors.isEmpty()) {
			Random random = new Random();
			int randomIndex = random.nextInt(schedulableActors.size());

			actorsToExecute.add(schedulableActors.get(randomIndex));
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
