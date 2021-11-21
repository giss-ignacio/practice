import java.util.LinkedList;

public class Graph {
    private int vertNum;
    private LinkedList<Integer> adj[];

    public Graph(int verticesNumber) {
        this.vertNum = verticesNumber;
        adj = new LinkedList[verticesNumber];
        for (int i=0; i < verticesNumber; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int v, int w) {
        adj[v].add(w);
    }

    public void BFS(int s) {

    }
}
