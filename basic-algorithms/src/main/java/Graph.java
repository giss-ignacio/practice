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
            sb.append(actualVertex).append(" ");

            for (int vi : adj[actualVertex]) {
                if (!visited[vi]) {
                    visited[vi] = true;
                    queue.add(vi);
                }
            }
        }
        return sb.toString();
    }

    public String DFS(int s) {
        boolean[] visited = new boolean[vertNum];

        StringBuilder sb = new StringBuilder();
        DFSRecursive(s, visited, sb);

        // check for disconnected vertices
        for (int i=0; i<vertNum; i++) {
            if (!visited[i]) {
                DFSRecursive(i, visited, sb);
            }
        }
        return sb.toString();
    }

    private StringBuilder DFSRecursive(int s, boolean[] visited, StringBuilder sb) {
        visited[s] = true;
        sb.append(s).append(" ");

        for (int vi : adj[s]) {
            if (!visited[vi]) {
                DFSRecursive(vi, visited, sb);
            }
        }

        return sb;
    }
}
