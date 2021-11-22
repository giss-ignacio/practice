import org.junit.Test;

import static org.junit.Assert.assertEquals;

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
}
