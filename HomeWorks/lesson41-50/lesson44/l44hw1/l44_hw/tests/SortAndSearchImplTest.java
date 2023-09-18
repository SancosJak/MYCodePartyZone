package l44_hw.tests;

import l44_hw.model.SortAndSearchImpl;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;


class SortAndSearchImplTest {

    @Test
    public void testBubbleSort() {
        SortAndSearchImpl sortAndSearch = new SortAndSearchImpl();

        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        int[] expected = {11, 12, 22, 25, 34, 64, 90};

        sortAndSearch.bubbleSort(arr);
        assertArrayEquals(expected, arr);
    }

    @Test
    public void testMyBinarySearchFound() {
        SortAndSearchImpl sortAndSearch = new SortAndSearchImpl();

        int[] arr = {11, 12, 22, 25, 34, 64, 90};
        int target = 25;

        int index = sortAndSearch.myBinarySearch(arr, target);
        assertEquals(3, index);
    }

    @Test
    public void testMyBinarySearchNotFound() {
        SortAndSearchImpl sortAndSearch = new SortAndSearchImpl();

        int[] arr = {11, 12, 22, 25, 34, 64, 90};
        int target = 30; // Element not present

        int index = sortAndSearch.myBinarySearch(arr, target);
        assertEquals(-1, index);
    }
    @Test
    public void testArraysBinarySearchFound() {
        int[] arr = {11, 12, 22, 25, 34, 64, 90};
        int target = 25;

        int index = Arrays.binarySearch(arr, target);
        assertEquals(3, index);
    }

    @Test
    public void testArraysBinarySearchNotFound() {
        int[] arr = {11, 12, 22, 25, 34, 64, 90};
        int target = 10; // Element not present

        int index = Arrays.binarySearch(arr, target);
        assertEquals(-1, index);
    }
}