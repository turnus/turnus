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
package turnus.model.dataflow.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.DirectedMultigraph;
import org.jgrapht.traverse.TopologicalOrderIterator;

import turnus.model.dataflow.Actor;
import turnus.model.dataflow.Buffer;
import turnus.model.graph.SimpleGraph;

/**
 * 
 * @author Simone Casale-Brunet
 *
 */
public class ActorsSorter {

	public static List<Actor> topologicalOrder(Collection<Actor> actors) {
		return topologicalOrder(actors, false);
	}

	public static List<Actor> topologicalOrder(Collection<Actor> actors, boolean removeCycles) {
		SimpleGraph<Actor> g = new SimpleGraph<>();
		for (Actor actor : actors) {
			g.addNode(actor);
		}

		for (Actor actor : actors) {
			for (Buffer outgoing : actor.getOutgoingBuffers()) {
				g.addEdge(actor, outgoing.getTarget().getOwner());
			}
		}
		if (removeCycles)
			g.detectAndRemoveCycles();
		return g.topologicalSort();
	}

	public static List<Actor> newTopologicalOrder(Collection<Actor> actors) {
		DirectedMultigraph<Actor, DefaultEdge> g = new DirectedMultigraph<>(DefaultEdge.class);

		for (Actor actor : actors) {
			g.addVertex(actor);
		}

		for (Actor actor : actors) {
			for (Buffer outgoing : actor.getOutgoingBuffers()) {
				g.addEdge(actor, outgoing.getTarget().getOwner());
			}
		}

		TopologicalOrderIterator<Actor, DefaultEdge> topoIterator = new TopologicalOrderIterator<>(g);

		List<Actor> topologicalOrder = new ArrayList<>();
		while (topoIterator.hasNext()) {
			Actor actor = topoIterator.next();
			topologicalOrder.add(actor);
		}
		return topologicalOrder;
	}

	public static List<Actor> alphabeticalOrder(Collection<Actor> actors) {
		List<Actor> sortedList = new ArrayList<>(actors);
		Collections.sort(sortedList, new Comparator<Actor>() {
			@Override
			public int compare(Actor o1, Actor o2) {
				return o1.getName().compareTo(o2.getName());
			}
		});

		return sortedList;
	}

}
