import java.util.NoSuchElementException;

public class DoublyLinkedList<K, V> {
    private Node<K, V> head;
    private Node<K, V> tail;


    public void insertAtHead(K key, V value) {
        Node<K, V> newHead = new Node<>(key, value);
        if (head == null) {
            head = newHead;
            tail = newHead;
            return;
        }
        head.prev = newHead;
        newHead.next = head;
        head = newHead;
    }

    public void insertAtTail(K key, V value) {
        Node<K, V> newTail = new Node<>(key, value);
        if (tail == null) {
            tail = newTail;
            head = newTail;
            return;
        }
        tail.next = newTail;
        newTail.prev = tail;
        tail = newTail;
    }

    public void moveToHead(K key) {
        Node<K, V> node = findNode(key);
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

    private Node<K, V> findNode(K key) {
        if (head == null) {
            return null;
        }
        Node<K, V> result = head;
        while (result != null && result.value != key) {
            result = result.next;
        }
        return result;
    }

    public V getHead() {
        if (head == null) {
            throw new NoSuchElementException("The list has no head because it's empty");
        }
        return head.getValue();
    }

    @Override
    public String toString() {
        Node<K, V> actualNode = head;
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
    private static class Node<K, V> {
        K key;
        V value;
        Node<K, V> prev;
        Node<K, V> next;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public V getValue() {
            return value;
        }
    }

}
