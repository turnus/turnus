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
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import turnus.model.graph.SimpleHyperGraph;

public class WeightedHyperGraph extends SimpleHyperGraph<WeightedActor, WeightedEdge> {

	public StringBuffer tohMetis() {
		StringBuffer sb = new StringBuffer();

		int nbHyperEdges = hyperedges.size();
		int nbNodes = getVertices().size();

		sb.append(String.format("%d %d 11\n", nbHyperEdges, nbNodes));

		Comparator<WeightedEdge> weightedEdgeComparator = Comparator.comparing(WeightedEdge::getId);
		Comparator<WeightedActor> weightedActorComparator = Comparator.comparing(WeightedActor::getId);

		List<WeightedEdge> edges = new ArrayList<>(hyperedges.keySet());
		Collections.sort(edges, new Comparator<WeightedEdge>() {
			@Override
			public int compare(WeightedEdge o1, WeightedEdge o2) {
				return weightedEdgeComparator.compare(o1, o2);
			}
		});

		for (WeightedEdge e : edges) {
			Set<WeightedActor> weightedActors = hyperedges.get(e);

			sb.append(String.format("%s %s\n", e.getWeight(),
					weightedActors.stream().map(WeightedActor::getId).collect(Collectors.joining(" "))));
		}

		// -- Node weights
		List<WeightedActor> nodes = new ArrayList<>(getVertices());
		Collections.sort(nodes, new Comparator<WeightedActor>() {
			@Override
			public int compare(WeightedActor o1, WeightedActor o2) {
				return weightedActorComparator.compare(o1, o2);
			}
		});

		for (WeightedActor node : nodes) {
			sb.append(String.format("%s\n", (int) node.getWorkload()));
		}

		sb.append("\n");
		return sb;
	}

}
