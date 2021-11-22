import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.NoSuchElementException;

import static org.junit.Assert.assertEquals;

public class DoublyLinkedListTest {
    private DoublyLinkedList dllist;

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Before
    public void setup() {
        dllist = new DoublyLinkedList();

        dllist.insertAtHead(2);
        dllist.insertAtHead(3);
        dllist.insertAtHead(1);
    }

    @Test
    public void insertAtHeadOneElementTest() {
        DoublyLinkedList dl = new DoublyLinkedList();

        dl.insertAtHead(2);
        assertEquals("2 ", dl.toString());
        assertEquals(2, dl.getHead());
    }

    @Test
    public void insertAtHeadTwoElementsTest() {
        DoublyLinkedList dl = new DoublyLinkedList();

        dl.insertAtHead(2);
        dl.insertAtHead(3);
        assertEquals("3 2 ", dl.toString());
        assertEquals(3, dl.getHead());
    }

    @Test
    public void insertAtHeadThreeElementsTest() {
        DoublyLinkedList dl = new DoublyLinkedList();

        dl.insertAtHead(2);
        dl.insertAtHead(3);
        dl.insertAtHead(1);
        assertEquals("1 3 2 ", dl.toString());
        assertEquals(1, dl.getHead());
    }

    @Test
    public void moveToHeadTest() {
        dllist.moveToHead(3);
        assertEquals("3 1 2 ", dllist.toString());
        assertEquals(3, dllist.getHead());
    }

    @Test
    public void moveToHeadNotFoundExpectException() {
        expectedException.expect(NoSuchElementException.class);
        expectedException.expectMessage("Cannot move element to head. The value is not in the list.");
        dllist.moveToHead(111);
    }

    @Test
    public void moveToHeadEmptyExpectException() {
        DoublyLinkedList emptyList = new DoublyLinkedList();
        expectedException.expect(NoSuchElementException.class);
        expectedException.expectMessage("Cannot move element to head. The value is not in the list.");
        emptyList.moveToHead(2);
    }
}
