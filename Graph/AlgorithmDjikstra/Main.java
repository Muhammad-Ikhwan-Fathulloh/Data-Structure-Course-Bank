public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph(7);

        graph.addNode('A');
        graph.addNode('B');
        graph.addNode('C');
        graph.addNode('D');
        graph.addNode('E');
        graph.addNode('F');
        graph.addNode('G');

        graph.addConnection('A', 'B', 1);
        graph.addConnection('A', 'C', 3);
        graph.addConnection('A', 'F', 10);
        graph.addConnection('B', 'A', 1);
        graph.addConnection('B', 'C', 1);
        graph.addConnection('B', 'D', 7);
        graph.addConnection('B', 'E', 5);
        graph.addConnection('B', 'G', 2);
        graph.addConnection('C', 'A', 3);
        graph.addConnection('C', 'B', 1);
        graph.addConnection('C', 'D', 9);
        graph.addConnection('C', 'E', 3);
        graph.addConnection('D', 'B', 7);
        graph.addConnection('D', 'C', 9);
        graph.addConnection('D', 'E', 2);
        graph.addConnection('D', 'F', 1);
        graph.addConnection('D', 'G', 12);
        graph.addConnection('E', 'B', 5);
        graph.addConnection('E', 'C', 3);
        graph.addConnection('E', 'D', 2);
        graph.addConnection('E', 'F', 2);
        graph.addConnection('F', 'A', 10);
        graph.addConnection('F', 'D', 1);
        graph.addConnection('F', 'E', 2);
        graph.addConnection('G', 'B', 2);
        graph.addConnection('G', 'D', 12);

        graph.printGraph();
        System.out.println();

        graph.getShortestPath('A','F');
    }
}