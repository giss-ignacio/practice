import java.util.Stack;

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

    public static void floodFill(int[][] m, int x, int y, int c) {
        if (m.length == 0 || x<0 || y<0 || x>= m.length || y>= m[0].length) {
            return; // or throw an illegal argument exception
        }
        int cOri = m[x][y];
        if (c==cOri) {
            return;
        }

        floodFillRec(m, x, y, c, cOri);
    }

    private static void floodFillRec(int[][] m, int x, int y, int c, int cOri) {
        // reached an edge
        if (x<0 || y<0 || x>= m.length || y>= m[0].length) {
            return;
        }
        // reached tile of different color than the original (an edge of color)
        if (m[x][y] != cOri) {
           return;
        }

        m[x][y] = c;
        floodFillRec(m, x-1, y, c, cOri);
        floodFillRec(m, x, y-1, c, cOri);
        floodFillRec(m, x+1, y, c, cOri);
        floodFillRec(m, x, y+1, c, cOri);
    }

    public static boolean isBalancedParenthesis(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> parenthesis = new Stack<>();

        for (char c : chars) {
            switch (c) {
                case '(':
                case '[':
                case '{':
                    parenthesis.push(c);
                    break;
                case ')':
                    if (parenthesis.empty() || parenthesis.pop() != '(') {
                        return false;
                    }
                    break;
                case ']':
                    if (parenthesis.empty() || parenthesis.pop() != '[') {
                        return false;
                    }
                    break;
                case '}':
                    if (parenthesis.empty() || parenthesis.pop() != '{') {
                        return false;
                    }
                    break;
            }
        }


        return parenthesis.empty();
    }

    // Sudoku solver
    // flood fill
    // Given an unsorted array of numbers, find 2 elements to sums to K (hash map)
    // Given a string containing parenthesis characters, balance that this is a balance expression of parenthesis.
    // effective fibonacci with dynamic programming

    // Coding In-memory caching component for an existing system. Your task is to implement a least recently used (LRU) cache
    // def: It's a data structure of fixed initial capacity N, and if at any moment it is asked to add the (N+1) item it will remove the
    // least recently used item to accommodate the new one.
    // get(key)
    // insert(key, value)
}
