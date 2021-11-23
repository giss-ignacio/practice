import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Stack;


public class LRUCache {
    private final int MAX_SIZE = 4;
    private Map<Integer, CacheNode> cache;
    private CacheNode head, tail;

    public int get(int key) {
        if (cache.containsKey(key)) {
            CacheNode node = cache.get(key);
            moveToHead(node);
            return head.value;
        }
        throw new NoSuchElementException("The element with key " + key + " is not present");
    }

    public void insert(int key, int value) {
        if (cache.containsKey(key)) {
            CacheNode node = cache.get(key);
            node.value = value;
            moveToHead(node);
            return;
        }
        // remove least used
        if (cache.size() > MAX_SIZE) {
            cache.remove(tail.key);
            tail = tail.prev;
            tail.next = null;
        }
        CacheNode node = new CacheNode(key, value);
        cache.put(key, node);
        insertAtHead(node);
    }

    private void insertAtHead(CacheNode node) {
        if (head == null) {
            head = node;
            tail = node;
        }
        head.prev = node;
        node.next = head;
        head = node;
    }

    private void moveToHead(CacheNode node) {
        if (node.equals(head)) {
            return;
        }
        node.prev.next = node.next;
        node.next = head;
        head.prev = node;
        head = node;
    }


    private static class CacheNode {
        private int key;
        private int value;
        private CacheNode prev, next;

        public CacheNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private static class LRUCache3rdApproach {
        private final int MAX_SIZE = 4;
        private Map<Integer, Integer> cache;
        private Stack<Integer> recentKeys;

        public int get(int key) {
            if (cache.containsKey(key)) {
                recentKeys.push(key);
                return cache.get(key);
            }
            throw new NoSuchElementException("The element with key " + key + " is not present");
        }

        public void insert(int key, int value) {
            if (cache.containsKey(key) || cache.size() < MAX_SIZE) {
                recentKeys.push(key);
                cache.put(key, value);
                return;
            }

            // O(N)
            // insertAndRebuildCache(key, value);
        }
    }



    private static class LRUCache2ndApproach {
        private final int MAX_SIZE = 4;
        private List<Node> cache;

        public int get(int key) {
            for (Node node : cache) {
                if (node.key == key) {
                    int value = node.value;
                    insert(key, value);
                    return value;
                }
            }
            throw new NoSuchElementException("The element with key " + key + " is not present");
        }

        public void insert(int key, int value) {
            cache.removeIf(node -> node.key == key);

            if (cache.size() == MAX_SIZE) {
                cache.remove(0);
            }
            cache.add(new Node(key, value));
        }

    }

    private static class Node {
        private final int key;
        private final int value;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private static class LRUCache1stApproach {
        // 1st supposing unlimited size
        private final Map<Integer, Integer> cache = new HashMap<>();

        public int get(int key) {
            if (cache.containsKey(key)) {
                return cache.get(key);
            }
            throw new NoSuchElementException("The element with key " + key + " is not present");
        }

        public void insert(int key, int value) {
            cache.put(key, value);
        }

    }
}
