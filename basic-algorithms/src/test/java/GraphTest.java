import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GraphTest {

    @Test
    public void BFS() {
        /*
         *  ┌─0──────►1
         *  │ ▲      │
         *  │ │      │   ◄──┐
         *  └►2◄─────┘  3└──┘
         *    │         ▲
         *    └─────────┘
         */

        Graph g = new Graph(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        String expected = "2 0 3 1 ";
        assertEquals(expected, g.BFS(2));
    }
}
