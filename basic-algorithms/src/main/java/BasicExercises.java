import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class BasicExercises {

    private static Scanner scanner = new Scanner(System.in);

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

    private static int countUnsolved(int[][] board) {
        int count = 0;
        for (int i=0; i< 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == 0) {
                    count++;
                }
            }
        }
        return count;
    }

    public static boolean sudokuSolver(int[][] board) {
        for (int i=0; i< 9; i++) {
            for (int j=0; j<9; j++) {
                if (board[i][j] == 0) {
                    for (int n=1; n<10 ; n++) {
                        if (possibleSudokuPosition(board, i, j, n)) {
                            board[i][j] = n;
                            if (sudokuSolver(board)) {
                                return true;
                            }
                            board[i][j] = 0;
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean possibleSudokuPosition(int[][] board, int x, int y, int n) {
        return possibleSudokuColumnPosition(board, y, n) && possibleSudokuRowPosition(board, x, n) && possibleSudokuSquarePosition(board, x, y, n);
    }

    private static boolean possibleSudokuColumnPosition(int[][] board, int columm, int n) {
        for (int i=0; i<9; i++) {
            if (board[i][columm] == n) {
                return false;
            }
        }
        return true;
    }

    private static boolean possibleSudokuRowPosition(int[][] board, int row, int n) {
        for (int i=0; i<9; i++) {
            if (board[row][i] == n) {
                return false;
            }
        }
        return true;
    }

    /*
     *  1 1 1 2 2 2 3 3 3
     *  1 1 1 2 2 2 3 3 3
     *  1 1 1 2 2 2 3 3 3
     *  4 4 4 5 5 5 6 6 6  - 4,4  - 3 to 5 col rows  x1=4-4%3 to <x1+3
     *  4 4 4 5 5 5 6 6 6
     *  4 4 4 5 5 5 6 6 6  - 2, 5 - x1=2-(2%3); y1= 5-(5%3)
     *  7 7 7 8 8 8 9 9 9
     *  7 7 7 8 8 8 9 9 9 - 8, 7 - x1 = 8-(8%3) = 6; y1 = 7-(7%3)
     *  7 7 7 8 8 8 9 9 9
     *
     */
    private static boolean possibleSudokuSquarePosition(int[][] board, int x, int y, int n) {
        int x1 = x-(x%3);
        int y1 = y-(y%3);
        for (int i=x1; i<x1+3; i++) {
          for (int j=y1; j<y1+3; j++) {
              if (board[i][j] == n) {
                  return false;
              }
          }
        }
        return true;
    }


    public static int fibonacciRec(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return fibonacciRec(n-1) + fibonacciRec(n-2);
    }

    public static int fibonacciIter(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }

        int result = 0;
        int previous_1=1, previous_2=1;

        for (int i=2; i<=n ; i++) {
            result = previous_1 + previous_2;
            previous_1 = previous_2;
            previous_2 = result;
        }

        return result;
    }

    public static boolean twoSumToK_BF(int[] v, int k) {
        for (int i=0; i<v.length; i++) {
            for (int j=0; j < v.length; j++) {
                if (i==j) {
                    continue;
                }
                if (v[i]+v[j] == k) {
                    return true;
                }
            }
        }
        return false;
    }

    /*
     * k = 3
     * {} f
     * {1} f
     * {3, 1, 2} t
     * {3, 4, 5} f
     */
    public static boolean twoSumToK_Sort(int[] v, int k) {
        if (v.length == 0 || v.length == 1) {
            return false; // throw new IllegalArgumentException("v needs to have at least 2 numbers");
        }
        if (v.length == 2) {
            return v[0] + v[1] == k;
        }

        Arrays.sort(v);

        for (int e : v) {
            //todo avoid same pos
            if (BasicSearch.binarySearch(v, k-e) != -1) {
                return true;
            }
        }
        return false;
    }



    // Sudoku solver
    // flood fill
    // Given an unsorted array of numbers, find 2 elements to sums to K (hash map)
    // Given a string containing parenthesis characters, balance that this is a balance expression of parenthesis.
    // effective fibonacci with dynamic programming
    // hanoi towers?

    // Coding In-memory caching component for an existing system. Your task is to implement a least recently used (LRU) cache
    // def: It's a data structure of fixed initial capacity N, and if at any moment it is asked to add the (N+1) item it will remove the
    // least recently used item to accommodate the new one.
    // get(key)
    // insert(key, value)
}
