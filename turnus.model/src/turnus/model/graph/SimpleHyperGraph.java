/* 
 * TURNUS - www.turnus.co
 * 
 * Copyright (C) 2023 EPFL SCI STI MM
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
package turnus.model.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * A simple hyper graph class
 * 
 * @author Endri Bezati
 *
 */
public class SimpleHyperGraph<V, E> {

	protected Map<E, Set<V>> hyperedges;

	public SimpleHyperGraph() {
		hyperedges = new HashMap<>();
	}

	public void addHyperedge(E edge, Set<V> vertices) {
		hyperedges.put(edge, new HashSet<>(vertices));
	}

	public Set<V> getVerticesOfHyperedge(E edge) {
		return hyperedges.get(edge);
	}

	public void removeHyperedge(E edge) {
		hyperedges.remove(edge);
	}

	public void addVertexToHyperedge(E edge, V vertex) {
		hyperedges.get(edge).add(vertex);
	}

	public void removeVertexFromHyperedge(E edge, V vertex) {
		hyperedges.get(edge).remove(vertex);
	}

	public int getHyperedgeSize() {
		return hyperedges.size();
	}

	public Set<V> getVertices() {
		Set<V> allVertices = new HashSet<>();
		for (Set<V> vertices : hyperedges.values()) {
			allVertices.addAll(vertices);
		}
		return allVertices;
	}

}
