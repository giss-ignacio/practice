import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BasicExercisesTest {

    @Test
    public void getMissingNumberTest() {
        int[] v = {1, 2, 3, 5, 6};
        int found = BasicExercises.getMissingNumber(v);
        assertEquals(4, found);
    }

    @Test
    public void findMaxSubArrayTest() {
        int[] vector = {4, 2, -3, 6, 1};
        assertEquals(10, BasicExercises.findMaximumSubArray(vector));
    }

    @Test
    public void floodFillTest() {
        int[][] drawing = {{1, 2},{1, 1}};
        BasicExercises.floodFill(drawing, 0, 0, 3);;
    }

    @Test
    public void floodFillSameColorTest() {
        int[][] drawing = {{1, 2},{1, 1}};
        BasicExercises.floodFill(drawing, 0, 0, 1);;
    }

    @Test
    public void floodFillAltTest() {
        int[][] drawing = {{1, 2},{1, 1}};
        BasicExercises.floodFill(drawing, 0, 1, 3);;
    }

    @Test
    public void floodFillComplexTest() {
        int[][] drawing = {{1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 0, 0},
                {1, 0, 0, 1, 1, 0, 1, 1},
                {1, 3, 3, 3, 3, 0, 1, 0},
                {1, 1, 1, 3, 3, 0, 1, 0},
                {1, 1, 1, 3, 3, 3, 3, 0},
                {1, 1, 1, 1, 1, 3, 1, 1},
                {1, 1, 1, 1, 1, 3, 3, 1},
        };
        BasicExercises.floodFill(drawing, 4, 4, 2);;
    }

    @Test
    public void isBalancedParenthesisTest() {
        assertTrue(BasicExercises.isBalancedParenthesis(""));
        assertFalse(BasicExercises.isBalancedParenthesis("("));
        assertFalse(BasicExercises.isBalancedParenthesis(")"));
        assertTrue(BasicExercises.isBalancedParenthesis("()"));
        assertTrue(BasicExercises.isBalancedParenthesis("(()())"));
        assertFalse(BasicExercises.isBalancedParenthesis("(()))"));
        assertTrue(BasicExercises.isBalancedParenthesis("aa(ss(dd)(asd))"));
    }

    @Test
    public void isBalancedParenthesisExtraTest() {
        assertTrue(BasicExercises.isBalancedParenthesis(""));
        assertFalse(BasicExercises.isBalancedParenthesis("("));
        assertFalse(BasicExercises.isBalancedParenthesis("["));
        assertFalse(BasicExercises.isBalancedParenthesis("{"));
        assertFalse(BasicExercises.isBalancedParenthesis(")"));
        assertTrue(BasicExercises.isBalancedParenthesis("()"));
        assertTrue(BasicExercises.isBalancedParenthesis("[]"));
        assertTrue(BasicExercises.isBalancedParenthesis("{}"));
        assertTrue(BasicExercises.isBalancedParenthesis("([{}])"));
        assertTrue(BasicExercises.isBalancedParenthesis("(([])({}))"));
        assertFalse(BasicExercises.isBalancedParenthesis("(()[)])"));
        assertTrue(BasicExercises.isBalancedParenthesis("aa(ss{dd}[asd])"));
    }

    @Test
    public void fibonacciRecTest() {
        assertEquals(5, BasicExercises.fibonacciRec(4));
        assertEquals(8, BasicExercises.fibonacciRec(5));
        assertEquals(13, BasicExercises.fibonacciRec(6));
    }

    @Test
    public void fibonacciIterTest() {
        assertEquals(5, BasicExercises.fibonacciIter(4));
        assertEquals(8, BasicExercises.fibonacciIter(5));
        assertEquals(13, BasicExercises.fibonacciIter(6));
    }

    @Test
    public void twoSumToK_BFTest() {
        int[] v = {1, 2, 3, 5, 6};
        assertTrue(BasicExercises.twoSumToK_BF(v, 7));
        assertFalse(BasicExercises.twoSumToK_BF(v, 10));
        assertTrue(BasicExercises.twoSumToK_BF(v, 3));
    }

    @Test
    public void twoSumToK_Sorting2ElementsTest() {
        int[] v = {1, 2};
        assertTrue(BasicExercises.twoSumToK_Sort(v, 3));
        assertFalse(BasicExercises.twoSumToK_Sort(v, 4));
    }

    @Test
    public void twoSumToK_Sorting3ElementsTest() {
        int[] v = {3, 1, 2};
        assertTrue(BasicExercises.twoSumToK_Sort(v, 3));
        assertTrue(BasicExercises.twoSumToK_Sort(v, 5));
        assertFalse(BasicExercises.twoSumToK_Sort(v, 6));
    }

    @Test
    public void twoSumToK_SortingTest() {
        int[] v = {1, 2, 3, 5, 6};
        //assertTrue(BasicExercises.twoSumToK_Sort(v, 7));
        assertFalse(BasicExercises.twoSumToK_Sort(v, 10));
        assertTrue(BasicExercises.twoSumToK_Sort(v, 3));
    }

    @Test
    public void sudokuSolverTest() {
        int[][] board = new int[][] {
                { 3, 0, 6, 5, 0, 8, 4, 0, 0 },
                { 5, 2, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 8, 7, 0, 0, 0, 0, 3, 1 },
                { 0, 0, 3, 0, 1, 0, 0, 8, 0 },
                { 9, 0, 0, 8, 6, 3, 0, 0, 5 },
                { 0, 5, 0, 0, 9, 0, 6, 0, 0 },
                { 1, 3, 0, 0, 0, 0, 2, 5, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 7, 4 },
                { 0, 0, 5, 2, 0, 6, 3, 0, 0 }
        };

        BasicExercises.sudokuSolver(board);
    }

    @Test
    public void nQueenProblemTest() {
        int[][] board = new int[][] {
                { 0, 0, 0, 1 },
                { 0, 0, 0, 0 },
                { 0, 0, 0, 0 },
                { 0, 0, 0, 0 },
        };

        BasicExercises.nQueenProblem(board, 0, 4);
    }
}
