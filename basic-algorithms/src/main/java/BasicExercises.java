public class BasicExercises {

    public static int getMissingNumber(int[] v) {
        if (v.length==0) {
            return -1;
        }
        int x1 = v[0];
        for (int i=1; i<v.length; i++) {
            x1 ^= v[i];
        }
        int x2 = 1;
        for (int i=2; i<=v.length+1; i++) {
            x2 ^= i;
        }

        return x1 ^ x2;
    }

    public static int findMaximumSubArray(int[] v) {
        int globalMax = Integer.MIN_VALUE;
        int localMax = 0;

        for (int e : v) {
            localMax = Math.max(e, e+localMax);
            if (localMax > globalMax) {
                globalMax = localMax;
            }
        }

        return globalMax;
    }

    // Sudoku solver
    // flood filler
    // Given an unsorted array of numbers, find 2 elements to sums to K (hash map)
    // Given a string containing parenthesis characters, balance that this is a balance expression of parenthesis.
    // effective fibonacci with dynamic programming

    // Coding In-memory caching component for an existing system. Your task is to implement a least recently used (LRU) cache
    // def: It's a data structure of fixed initial capacity N, and if at any moment it is asked to add the (N+1) item it will remove the
    // least recently used item to accommodate the new one.
    // get(key)
    // insert(key, value)
}
