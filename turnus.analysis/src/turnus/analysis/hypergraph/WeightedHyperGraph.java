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
package turnus.analysis.hypergraph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import turnus.model.graph.SimpleHyperGraph;

public class WeightedHyperGraph extends SimpleHyperGraph<WeightedActor, WeightedEdge> {

	public StringBuffer tohMetis() {
		return tohMetis(true, true);
	}

	public StringBuffer tohMetis(boolean withNodeWeights, boolean withHyperedgeWeight) {
		StringBuffer sb = new StringBuffer();

		int nbHyperEdges = hyperedges.size();
		int nbNodes = getVertices().size();

		if (!withNodeWeights && !withHyperedgeWeight) {
			sb.append(String.format("%d %d\n", nbHyperEdges, nbNodes));
		} else {
			sb.append(String.format("%d %d %s%s\n", nbHyperEdges, nbNodes, withNodeWeights ? 1 : 0,
					withHyperedgeWeight ? 1 : 0));
		}

		List<WeightedEdge> edges = new ArrayList<>(hyperedges.keySet());
		Collections.sort(edges);

		for (WeightedEdge e : edges) {
			Set<WeightedActor> weightedActors = hyperedges.get(e);
			if (withHyperedgeWeight) {
				sb.append(String.format("%s %s\n", e.getWeight(), weightedActors.stream().map(WeightedActor::getId)
						.map(String::valueOf).collect(Collectors.joining(" "))));
			} else {
				sb.append(String.format("%s\n", weightedActors.stream().map(WeightedActor::getId).map(String::valueOf)
						.collect(Collectors.joining(" "))));
			}
		}

		// -- Node weights
		List<WeightedActor> nodes = new ArrayList<>(getVertices());
		Collections.sort(nodes);

		if (withNodeWeights) {
			for (WeightedActor node : nodes) {
				sb.append(String.format("%s\n", (int) node.getWorkload()));
			}
		}

		sb.append("\n");
		return sb;
	}

	public StringBuffer toPatoh() {
		return toPatoh(true, true, true);
	}

	public StringBuffer toPatoh(boolean withNodeWeights, boolean withHyperedgeWeight, boolean withMemoryWeight) {
		StringBuffer sb = new StringBuffer();

		int nbHyperEdges = hyperedges.size();
		int nbNodes = getVertices().size();

		List<WeightedEdge> edges = new ArrayList<>(hyperedges.keySet());
		Collections.sort(edges);

		int pins = 0;
		for (WeightedEdge e : edges) {
			Set<WeightedActor> weightedActors = hyperedges.get(e);
			pins += weightedActors.size();
		}

		int weights = 0;

		if (withNodeWeights) {
			weights += 1;
		}

		if (withHyperedgeWeight) {
			weights += 2;
		}

		if (weights == 0) {
			sb.append(String.format("1 %d %d %d\n", nbNodes, nbHyperEdges, pins));
		} else {
			sb.append(String.format("1 %d %d %d %d %s \n", nbNodes, nbHyperEdges, pins, weights,
					withMemoryWeight ? 2 : 1));
		}

		for (WeightedEdge e : edges) {
			Set<WeightedActor> weightedActors = hyperedges.get(e);
			if (withHyperedgeWeight) {
				sb.append(String.format("%s %s\n", e.getWeight(), weightedActors.stream().map(WeightedActor::getId)
						.map(String::valueOf).collect(Collectors.joining(" "))));
			} else {
				sb.append(String.format("%s\n", weightedActors.stream().map(WeightedActor::getId).map(String::valueOf)
						.collect(Collectors.joining(" "))));
			}
		}

		// -- Node weights
		List<WeightedActor> nodes = new ArrayList<>(getVertices());
		Collections.sort(nodes);

		if (withNodeWeights) {
			for (WeightedActor node : nodes) {
				if (withMemoryWeight) {
					sb.append(String.format("%s %d ", (int) node.getWorkload(), node.getMemory()));
				} else {
					sb.append(String.format("%s ", (int) node.getWorkload()));
				}
			}
		}

		sb.append("\n");
		return sb;

	}

}
