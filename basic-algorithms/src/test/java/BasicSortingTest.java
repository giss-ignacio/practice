import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class BasicSortingTest {

    @Test
    public void bubbleSortTest() {
        int[] vector = {4, 2, 3, 6, 1};
        int[] expected = {1, 2, 3, 4, 6};
        assertArrayEquals(expected, BasicSorting.bubbleSort(vector));
    }

    @Test
    public void bubbleSortEmptyTest() {
        int[] vector = {};
        int[] expected = {};
        assertArrayEquals(expected, BasicSorting.bubbleSort(vector));
    }

    @Test
    public void mergeSortEmptyTest() {
        int[] vector = {};
        int[] expected = {};
        BasicSorting.mergeSort(vector, 0, vector.length-1);
        assertArrayEquals(expected, vector);
    }

    @Test
    public void mergeSort1ElementTest() {
        int[] vector = {4};
        int[] expected = {4};
        BasicSorting.mergeSort(vector, 0, vector.length-1);
        assertArrayEquals(expected, vector);
    }

    @Test
    public void mergeSort2ElementsTest() {
        int[] vector = {4, 2};
        int[] expected = {2, 4};
        BasicSorting.mergeSort(vector, 0, vector.length-1);
        assertArrayEquals(expected, vector);
    }

    @Test
    public void mergeSortTest() {
        int[] vector = {4, 2, 3, 6, 1};
        int[] expected = {1, 2, 3, 4, 6};
        BasicSorting.mergeSort(vector, 0, vector.length-1);
        assertArrayEquals(expected, vector);
    }

    @Test
    public void countingSortTest() {
        int[] vector = {4, 2, 3, 6, 1};
        int[] expected = {1, 2, 3, 4, 6};
        BasicSorting.countingSort(vector);
        assertArrayEquals(expected, vector);
    }

    @Test
    public void countingSortString() {
        String input = "zfabtc";
        assertEquals("abcftz", BasicSorting.countingSortString(input));
    }

    @Test
    public void radixSortTest() {
        int[] vector = {4, 2, 3, 6, 1};
        int[] expected = {1, 2, 3, 4, 6};
        BasicSorting.radixSort(vector);
        assertArrayEquals(expected, vector);
    }
}
