package turnus.analysis.hypergraph;

import java.util.Objects;

import turnus.model.analysis.profiling.util.MemoryAndBuffers;
import turnus.model.dataflow.Actor;

public class WeightedActor {
	private int id;
	private Actor actor;
	private double workload;

	public WeightedActor(int id, Actor actor, double workload) {
		this.id = id;
		this.actor = actor;
		this.workload = workload;
	}

	public Actor getActor() {
		return actor;
	}

	public String getId() {
		return String.valueOf(id);
	}

	public double getWorkload() {
		return workload;
	}

	public long getMemory() {
		return MemoryAndBuffers.getActorPersistentMemmory(actor);
	}

	@Override
	public int hashCode() {
		return Objects.hash(actor, id, workload);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		WeightedActor other = (WeightedActor) obj;
		return Objects.equals(actor, other.actor) && id == other.id
				&& Double.doubleToLongBits(workload) == Double.doubleToLongBits(other.workload);
	}
	


	
}
