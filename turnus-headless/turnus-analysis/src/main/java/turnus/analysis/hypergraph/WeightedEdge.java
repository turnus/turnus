package turnus.analysis.hypergraph;

public class WeightedEdge implements Comparable<WeightedEdge>{
	private int id;
	private long weight;

	public WeightedEdge(int id, long weight) {
		this.id = id;
		this.weight = weight;
	}

	public int getId() {
		return id;
	}

	public long getWeight() {
		return weight;
	}

	@Override
	public int compareTo(WeightedEdge o) {
		return Integer.compare(this.getId(), o.getId());
	}
}
