import java.util.NoSuchElementException;

public class DoublyLinkedList {
    private Node head;
    private Node tail;


    public void insertAtHead(int value) {
        Node newHead = new Node(value);
        if (head == null) {
            head = newHead;
            tail = newHead;
            return;
        }
        head.prev = newHead;
        newHead.next = head;
        head = newHead;
    }

    public void insertAtTail(int value) {
        Node newTail = new Node(value);
        if (tail == null) {
            tail = newTail;
            head = newTail;
            return;
        }
        tail.next = newTail;
        newTail.prev = tail;
        tail = newTail;
    }

    public void moveToHead(int value) {
        Node node = findNode(value);
        if (node == null) {
            throw new NoSuchElementException("Cannot move element to head. The value is not in the list.");
        }
        if (node.equals(head)) {
            return;
        }
        node.prev.next = node.next;
        node.next = head;
        head.prev = node;
        head = node;
    }

    private Node findNode(int value) {
        if (head == null) {
            return null;
        }
        Node result = head;
        while (result != null && result.value != value) {
            result = result.next;
        }
        return result;
    }

    public int getHead() {
        if (head == null) {
            throw new NoSuchElementException("The list has no head because it's empty");
        }
        return head.value;
    }

    @Override
    public String toString() {
        Node actualNode = head;
        StringBuilder sb = new StringBuilder();
        while (actualNode != null) {
            sb.append(actualNode.value).append(" ");
            actualNode = actualNode.next;
        }

        return sb.toString();
    }

    /**
     * List node class.
     */
    private static class Node {
        int value;
        Node prev;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }

}
