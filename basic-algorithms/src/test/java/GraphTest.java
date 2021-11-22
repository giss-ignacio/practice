import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GraphTest {
    private Graph g;

    @Before
    public void setup() {
        /*
         *  ┌─0──────►1
         *  │ ▲      │
         *  │ │      │   ◄──┐
         *  └►2◄─────┘  3└──┘
         *    │         ▲
         *    └─────────┘
         */

        g = new Graph(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
    }

    @Test
    public void BFS() {
        String expected = "2 0 3 1 ";
        assertEquals(expected, g.BFS(2));
    }

    @Test
    public void DFS() {
        String expected = "2 0 1 3 ";
        assertEquals(expected, g.DFS(2));
    }

    @Test
    public void DFSOnDisconnectedGraph() {
        Graph gd = new Graph(4);

        gd.addEdge(0, 1);
        gd.addEdge(0, 2);
        gd.addEdge(1, 2);
        gd.addEdge(2, 0);
        gd.addEdge(3, 3);
        String expected = "2 0 1 3 ";
        assertEquals(expected, gd.DFS(2));
    }

}
