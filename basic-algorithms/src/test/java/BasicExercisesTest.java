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
}
