package binary.search.tree;

public class Node {
    
    int key;
    Node parent;
    Node left;
    Node right;
    int height;

    public Node(int data) {
        
        this.key = data;
        this.parent = null;
        this.left = null;
        this.right = null;
        this.height = 0;
        
    }
        
}
