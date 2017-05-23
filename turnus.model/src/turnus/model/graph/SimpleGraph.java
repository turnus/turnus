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
package turnus.model.graph;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Stack;

/**
 * 
 * @author Simone Casale-Brunet
 *
 */
public class SimpleGraph<V> {

	private ArrayList<V> vertices;
	private Map<V, Collection<V>> edges;

	public SimpleGraph() {
		vertices = new ArrayList<>();
		edges = new HashMap<>();
	}

	public boolean addNode(V object){
		if (vertices.contains(object))
			return false;

		vertices.add(object);
		return true;
	}

	public boolean addEdge(V source, V target){
		if (vertices.contains(source) && vertices.contains(target)) {
			if(!edges.containsKey(source)){
				edges.put(source, new HashSet<V>());
			}
			edges.get(source).add(target);
			return true;
		} else {
			return false;
		}

	}
	
	 // The function to do Topological Sort. It uses
    // recursive topologicalSortUtil()
	@SuppressWarnings({ "unchecked", "rawtypes" })
    public List<V> topologicalSort()
    {
        Stack<V> stack = new Stack<V>();
 
        // Mark all the vertices as not visited
        // Initialize adjacency list
        int V = vertices.size();
        boolean visited[] = new boolean[V];
        
		LinkedList<Integer> adj[] = new LinkedList[V];
        for (int i = 0; i < V; i++){
        	 visited[i] = false;
        	 adj[i] = new LinkedList();
        }
           
        // create an adicency list
        for(Entry<V, Collection<V>> e : edges.entrySet()){
        	V source = e.getKey();
        	int sourceId = vertices.indexOf(source);
        	for(Object target : e.getValue()){
        		int targetId = vertices.indexOf(target);
        		adj[sourceId].add(targetId);
        	}
        }
 
        // Call the recursive helper function to store
        // Topological Sort starting from all vertices
        // one by one
        for (int i = 0; i < V; i++)
            if (visited[i] == false)
                topologicalSortUtil(i, visited, adj, stack);
 
        // Create List
        List<V> sorted = new ArrayList<>();
        while (stack.empty()==false)
        	sorted.add(stack.pop());
        return sorted;
    }
	
	
	// A recursive function used by topologicalSort
    void topologicalSortUtil(int v, boolean visited[], LinkedList<Integer> adj[], Stack<V> stack)
    {
        // Mark the current node as visited.
        visited[v] = true;
        Integer i;
 
        // Recur for all the vertices adjacent to this
        // vertex
        Iterator<Integer> it = adj[v].iterator();
        while (it.hasNext())
        {
            i = it.next();
            if (!visited[i])
                topologicalSortUtil(i, visited, adj, stack);
        }
 
        // Push current vertex to stack which stores result
        V object = vertices.get(v);
        stack.push(object);
    }

}
