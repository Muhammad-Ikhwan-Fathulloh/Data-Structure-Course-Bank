public class Node implements Comparable<Node> {

    private char letter;
    private Character previousLetter;
    private int totalCost;
    private boolean visited;
    private static final int INFINITY = (int) Double.POSITIVE_INFINITY;

    public Node(char letter) {
        this.letter = letter;
        previousLetter = null;
        totalCost = INFINITY;
        visited = false;
    }

    public char getLetter() {
        return letter;
    }

    public Character getPreviousLetter() {
        return previousLetter;
    }

    public void setPreviousLetter(char previousLetter) {
        this.previousLetter = previousLetter;
    }

    public int getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(int totalCost) {
        this.totalCost = totalCost;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    @Override
    public int compareTo(Node n) {
        return totalCost - n.getTotalCost();
    }

    @Override
    public String toString() {
        return "Node: Letter = " + letter +
                ", Previous = " + previousLetter + ", Total Cost = " + totalCost;
    }
}