package turnus.analysis.hypergraph;

import java.util.Objects;

import turnus.model.dataflow.Actor;

public class WeightedActor implements Comparable<WeightedActor>{
	private int id;
	private Actor actor;
	private double workload;
	private long memory;

	public WeightedActor(int id, Actor actor, double workload) {
		this.id = id;
		this.actor = actor;
		this.workload = workload;
		this.memory = 0;
	}

	public Actor getActor() {
		return actor;
	}

	public int getId() {
		return id;
	}

	public double getWorkload() {
		return workload;
	}

	public void setMemory(long memory) {
		this.memory = memory;
	}
	
	public long getMemory() {
		return memory;
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

	@Override
	public int compareTo(WeightedActor o) {
		return Integer.compare(this.getId(), o.getId());
	}
	


	
}
