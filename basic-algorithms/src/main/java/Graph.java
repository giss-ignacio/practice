import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

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

    public String BFS(int s) {
        boolean[] visited = new boolean[vertNum];

        visited[s] = true;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            int actualVertex =queue.poll();
            sb.append(actualVertex + " ");

            for (int vi : adj[actualVertex]) {
                if (!visited[vi]) {
                    visited[vi] = true;
                    queue.add(vi);
                }
            }
        }
        return sb.toString();
    }
}
