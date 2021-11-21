import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BasicSearchTest {

    @Test
    public void basicSearchTest() {
        int[] vector = {1, 13, 16, 26, 111};
        assertEquals(-1, BasicSearch.binarySearch(vector, 14));
    }
}
