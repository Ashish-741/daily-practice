import java.util.*;

public class Graph {
    // Adjacency list: vertex -> (neighbor -> cost)
    private HashMap<Integer, HashMap<Integer, Integer>> map;

    // Constructor: initialize graph with v vertices
    public Graph(int v) {
        map = new HashMap<>();
        for (int i = 1; i <= v; i++) {
            map.put(i, new HashMap<>());
        }
    }

    // Add an undirected edge with cost
    public void addEdge(int v1, int v2, int cost) {
        map.get(v1).put(v2, cost);
        map.get(v2).put(v1, cost);
    }

    // Check if an edge exists between v1 and v2
    public boolean containsEdge(int v1, int v2) {
        return map.get(v1).containsKey(v2);
    }

    // Check if a vertex exists
    public boolean containsVertex(int v1) {
        return map.containsKey(v1);
    }

    // Count total number of edges
    public int noOfEdge() {
        int sum = 0;
        for (int vtx : map.keySet()) {
            sum += map.get(vtx).size();
        }
        return sum / 2; // each edge counted twice
    }

    // Remove an edge
    public void removeEdge(int v1, int v2) {
        map.get(v1).remove(v2);
        map.get(v2).remove(v1);
    }

    // Remove a vertex and all its edges
    public void removeVertex(int v1) {
        for (int nbrs : new HashSet<>(map.get(v1).keySet())) {
            map.get(nbrs).remove(v1);
        }
        map.remove(v1);
    }

    // Display adjacency list
    public void Display() {
        for (int v : map.keySet()) {
            System.out.println(v + " -> " + map.get(v));
        }
    }

    // Check if a path exists between src and des using DFS
    public boolean hasPath(int src, int des) {
        Set<Integer> visited = new HashSet<>();
        return hasPathDFS(src, des, visited);
    }

    // Helper DFS function
    private boolean hasPathDFS(int src, int des, Set<Integer> visited) {
        if (src == des) return true;
        visited.add(src);

        for (int nbr : map.get(src).keySet()) {
            if (!visited.contains(nbr)) {
                boolean ans = hasPathDFS(nbr, des, visited);
                if (ans) return true;
            }
        }
        return false;
    }

    // Main method to test the graph
    public static void main(String[] args) {
        Graph g = new Graph(4);

        g.addEdge(1, 2, 10);
        g.addEdge(1, 3, 5);
        g.addEdge(2, 4, 7);

        System.out.println("Graph after adding edges:");
        g.Display();

        System.out.println("Contains edge 1-2? " + g.containsEdge(1, 2));
        System.out.println("Contains vertex 3? " + g.containsVertex(3));
        System.out.println("No of edges: " + g.noOfEdge());

        g.removeEdge(1, 3);
        System.out.println("After removing edge 1-3:");
        g.Display();
        System.out.println("No of edges: " + g.noOfEdge());

        g.removeVertex(2);
        System.out.println("After removing vertex 2:");
        g.Display();
        System.out.println("No of edges: " + g.noOfEdge());

        System.out.println("Path exists from 1 to 4? " + g.hasPath(1, 4));
        System.out.println("Path exists from 1 to 3? " + g.hasPath(1, 3));
    }
}
