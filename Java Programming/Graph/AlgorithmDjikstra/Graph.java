import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Stack;

public class Graph {

    ArrayList<Node> nodeList;
    int[][] adjacencyMatrix;

    public Graph(int numberOfNodes) {
        nodeList = new ArrayList<>();
        adjacencyMatrix = new int[numberOfNodes][numberOfNodes];
    }

    public void addNode(char letter) {
        Node nodeToAdd = new Node(letter);
        nodeList.add(nodeToAdd);
    }

    public void addConnection(char letter1, char letter2, int cost) {
        Node node1 = getNode(letter1);
        Node node2 = getNode(letter2);

        if (node1 == null || node2 == null) {
            return;
        }

        int row = convertLetterToIndex(letter1);
        int col = convertLetterToIndex(letter2);
        adjacencyMatrix[row][col] = cost;
    }

    private int findNode(char letter) {
        int foundIndex = -1;

        for (int i = 0; i < nodeList.size(); i++) {
            Node n = nodeList.get(i);

            if (n.getLetter() == letter) {
                foundIndex = i;
                break;
            }
        }

        return foundIndex;
    }

    private Node getNode(char letter) {
        int nodeIndex = findNode(letter);

        if (nodeIndex == -1) {
            return null;
        }

        return nodeList.get(nodeIndex);
    }

    private int convertLetterToIndex(char letter) {
        return findNode(letter);
    }

    private char convertIndexToLetter(int index) {
        return nodeList.get(index).getLetter();
    }

    private void printColumnLetters() {
        System.out.print("  ");
        for (int i = 0; i < adjacencyMatrix.length; i++) {
            char rowLetter = (char) (i + 'A');
            System.out.print(rowLetter + " ");
        }
        System.out.println();
    }

    public void printGraph() {
        printColumnLetters();

        for (int i = 0; i < adjacencyMatrix.length; i++) {
            char rowLetter = (char) (i + 'A');
            System.out.print(rowLetter + " ");
            for (int j = 0; j < adjacencyMatrix[i].length; j++) {
                System.out.print(adjacencyMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void getShortestPath(char startLetter) {
        getShortestPath(startLetter, null);
        printNodeList();
    }

    public void getShortestPath(char startLetter, Character endLetter) {
        PriorityQueue<Node> nodes = new PriorityQueue<>();
        Node startNode = getNode(startLetter);
        if (startNode == null) {
            return;
        }
        startNode.setTotalCost(0);
        nodes.offer(startNode);

        while (!nodes.isEmpty()) {
            Node nodeBeingExpanded = nodes.poll();

            int rowIndex = convertLetterToIndex(nodeBeingExpanded.getLetter());
            int[] row = adjacencyMatrix[rowIndex];

            for (int i = 0; i < row.length; i++) {
                if (row[i] == 0) {
                    continue;
                }

                Node currentNode = getNode(convertIndexToLetter(i));

                if (currentNode == null) {
                    return;
                }

                if (currentNode.isVisited()) {
                    continue;
                }

                int cost = nodeBeingExpanded.getTotalCost() + row[i];

                if (cost < currentNode.getTotalCost()) {
                    currentNode.setPreviousLetter(nodeBeingExpanded.getLetter());
                    currentNode.setTotalCost(cost);
                }

                if (!nodes.contains(currentNode)) {
                    nodes.offer(currentNode);
                }
            }

            nodeBeingExpanded.setVisited(true);
        }

        System.out.println();

        if (endLetter == null) {
            return;
        }

        System.out.println("The shortest path from " + startLetter + " to " + endLetter + " is show below:");
        printShortestPath(endLetter);
    }

    public void printNodeList() {
        for (Node n : nodeList) {
            System.out.println(n);
        }
    }

    public void printShortestPath(char endLetter) {
        Stack<Node> shortestPath = new Stack<>();
        Node currentNode = getNode(endLetter);

        if (currentNode == null) {
            return;
        }

        int shortestDistance = currentNode.getTotalCost();

        while (currentNode != null && currentNode.getPreviousLetter() != null) {
            shortestPath.push(currentNode);
            currentNode = getNode(currentNode.getPreviousLetter());
        }

        shortestPath.push(currentNode);

        while (!shortestPath.empty()) {
            Node node = shortestPath.pop();
            System.out.print(node.getLetter());
            if (!shortestPath.empty()) {
                System.out.print(" --> ");
            }
        }

        System.out.println("\nTotal cost = " + shortestDistance);
    }
}