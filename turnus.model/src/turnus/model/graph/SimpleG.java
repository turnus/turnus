package turnus.model.graph;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;


public class SimpleG<V> {
    private final List<V> vertices;
    private final Map<V, Collection<V>> edges;

    public SimpleG() {
        this.vertices = new ArrayList<>();
        this.edges = new HashMap<>();
    }

    // Method to add a node to the graph
    public void addNode(V object) {
        if (!vertices.contains(object)) {
            vertices.add(object);
            edges.put(object, new ArrayList<>());
        }
    }

    // Method to add an edge between two nodes
    public void addEdge(V source, V destination) {
        if (!vertices.contains(source)) {
            addNode(source);
        }
        if (!vertices.contains(destination)) {
            addNode(destination);
        }

        edges.get(source).add(destination);
    }

    // Method to get the vertices of the graph
    public List<V> getVertices() {
        return new ArrayList<>(vertices);
    }

    // Method to perform topological sort on the graph
    public List<V> topologicalSort() {
        Set<V> visited = new HashSet<>();
        Stack<V> stack = new Stack<>();
        
        for (V vertex : vertices) {
            if (!visited.contains(vertex)) {
                topologicalSortUtil(vertex, visited, stack);
            }
        }

        List<V> result = new ArrayList<>();
        while (!stack.isEmpty()) {
            result.add(stack.pop());
        }

        return result;
    }

    private void topologicalSortUtil(V vertex, Set<V> visited, Stack<V> stack) {
        visited.add(vertex);

        for (V neighbor : edges.get(vertex)) {
            if (!visited.contains(neighbor)) {
                topologicalSortUtil(neighbor, visited, stack);
            }
        }

        stack.push(vertex);
    }

}