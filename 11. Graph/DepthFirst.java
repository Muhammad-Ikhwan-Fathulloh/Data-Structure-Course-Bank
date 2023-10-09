package depthfirst;

class StackX {

    private final int SIZE = 20;
    private int[] st;
    private int top;

    public StackX() {
        
        st = new int[SIZE]; // make array
        top = -1;
    
    }
  
    public void push(int j) { 
        st[++top] = j; 
    }
  
    public int pop() { 
        return st[top--]; 
    }
  
    public int peek() { 
        return st[top]; 
    }
  
    public boolean isEmpty() { 
        return (top == -1); 
    }
  
}

class Vertex {
    
    public char label;
    public boolean wasVisited;

    public Vertex(char lab) {
        
        label = lab;
        wasVisited = false;
      
    }

}

class Graph {
    
    private final int MAX_VERTS = 20;
    private final Vertex vertexList[];
    private final int adjMat[][];
    private int nVerts;
    private final StackX theStack;

    public Graph() {
        
        vertexList = new Vertex[MAX_VERTS];
        adjMat = new int[MAX_VERTS][MAX_VERTS];
        nVerts = 0;
        
        for(int j=0; j<MAX_VERTS; j++) {
            for(int k=0; k<MAX_VERTS; k++) {
                adjMat[j][k] = 0;
            }
        }

        theStack = new StackX();
      
    }

    public void addVertex(char lab) {
        vertexList[nVerts++] = new Vertex(lab);
    }
  
    public void addEdge(int start, int end) {
        adjMat[start][end] = 1;
        adjMat[end][start] = 1;
    }
 
    public void displayVertex(int v) {
        System.out.print(vertexList[v].label + " ");
    }
    
    public void cetakSimpul(int v) {
        System.out.println("Simpul " + v + " adalah " + vertexList[v].label);
    }    
    
    public void dfs() {
        
        vertexList[0].wasVisited = true;
        displayVertex(0);
        theStack.push(0);

        while( !theStack.isEmpty()) {

            int v = getAdjUnvisitedVertex(theStack.peek());
            
            if(v == -1){
                theStack.pop();
            } else {
                vertexList[v].wasVisited = true;
                displayVertex(v);
                theStack.push(v);
            }
            
        }
        
        for(int j=0; j<nVerts; j++) {
            vertexList[j].wasVisited = false;
        }
        
    }
    
    public int getAdjUnvisitedVertex(int v) {
        
        for(int j=0; j<nVerts; j++){
            
            if(adjMat[v][j]==1 && vertexList[j].wasVisited==false){
                return j;
            }
            
        }
        
        return -1;
      
    }

}

public class DepthFirst {
    
    public static void main(String[] args) {
        
        System.out.println("");

        Graph theGraph = new Graph();
        theGraph.addVertex('A');
        theGraph.addVertex('B');
        theGraph.addVertex('C');
        theGraph.addVertex('D');
        theGraph.addVertex('E');
        theGraph.addEdge(0, 1);
        theGraph.addEdge(1, 2);
        theGraph.addEdge(0, 3);
        theGraph.addEdge(3, 4);
        
        System.out.print("Grafik -> ");
        theGraph.dfs();
        System.out.println("\n");
        
        theGraph.cetakSimpul(0);
        theGraph.cetakSimpul(1);
        theGraph.cetakSimpul(2);
        theGraph.cetakSimpul(3);
        theGraph.cetakSimpul(4);
        
        System.out.println("\n");

    }
  
}