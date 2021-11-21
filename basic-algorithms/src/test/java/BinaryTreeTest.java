import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BinaryTreeTest {

    private BinaryTree bt;

    @Before
    public void setup() {
        /*    3
         *   / \
         *  2   6
         *     /
         *    5
         */
        bt = new BinaryTree();
        bt.insert(3);
        bt.insert(2);
        bt.insert(6);
        bt.insert(5);
    }

    @Test
    public void insert() {
        assertEquals(4, bt.countNodes());
    }

    @Test
    public void contains() {
        assertTrue(bt.contains(5));
        assertFalse(bt.contains(7));
    }

    @Test
    public void printBFS() {
        bt.printLevelOrder();
        //bt.printBFS();
    }

    @Test
    public void height() {
        BinaryTree btg = new BinaryTree();
        btg.insert(3);
        btg.insert(2);
        btg.insert(1);
        btg.insert(6);
        btg.insert(5);
        btg.insert(4);
        assertEquals(4, btg.height());
    }

    @Test
    public void toStringInorder() {
        String expected = "2 3 5 6 ";
        assertEquals(expected, bt.toStringInorder());
    }

    @Test
    public void toStringPreorder() {
        String expected = "3 2 6 5 ";
        assertEquals(expected, bt.toStringPreorder());
    }

    @Test
    public void toStringPostorder() {
        String expected = "2 5 6 3 ";
        assertEquals(expected, bt.toStringPostorder());
    }
}
