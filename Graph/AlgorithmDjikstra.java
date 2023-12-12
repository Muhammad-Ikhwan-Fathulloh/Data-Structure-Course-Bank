import java.util.*;

class Graph {
    private final Map<String, Map<String, Integer>> adjacencyList;

    public Graph() {
        this.adjacencyList = new HashMap<>();
    }

    public void addVertex(String vertex) {
        adjacencyList.put(vertex, new HashMap<>());
    }

    public void addEdge(String source, String destination, int weight) {
        adjacencyList.get(source).put(destination, weight);
        adjacencyList.get(destination).put(source, weight); // Uncomment this line for undirected graph
    }

    public Map<String, Integer> djikstra(String start) {
        Map<String, Integer> distances = new HashMap<>();
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(node -> node.distance));

        for (String vertex : adjacencyList.keySet()) {
            distances.put(vertex, vertex.equals(start) ? 0 : Integer.MAX_VALUE);
            priorityQueue.add(new Node(vertex, distances.get(vertex)));
        }

        while (!priorityQueue.isEmpty()) {
            Node current = priorityQueue.poll();

            for (Map.Entry<String, Integer> neighborEntry : adjacencyList.get(current.vertex).entrySet()) {
                String neighbor = neighborEntry.getKey();
                int newDistance = distances.get(current.vertex) + neighborEntry.getValue();

                if (newDistance < distances.get(neighbor)) {
                    distances.put(neighbor, newDistance);
                    priorityQueue.add(new Node(neighbor, newDistance));
                }
            }
        }

        return distances;
    }

    private static class Node {
        private final String vertex;
        private final int distance;

        public Node(String vertex, int distance) {
            this.vertex = vertex;
            this.distance = distance;
        }
    }
}

public class AlgorithmDjikstra {
    public static void main(String[] args) {
        Graph graph = new Graph();

        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E");

        graph.addEdge("A", "B", 1);
        graph.addEdge("A", "C", 4);
        graph.addEdge("B", "C", 2);
        graph.addEdge("B", "D", 5);
        graph.addEdge("C", "D", 1);
        graph.addEdge("C", "E", 7);
        graph.addEdge("D", "E", 3);

        String startVertex = "A";
        Map<String, Integer> distances = graph.djikstra(startVertex);

        for (Map.Entry<String, Integer> entry : distances.entrySet()) {
            System.out.println("Shortest distance from " + startVertex + " to " + entry.getKey() + " is: " + entry.getValue());
        }
    }
}
