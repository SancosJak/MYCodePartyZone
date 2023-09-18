package l44_hw;

import l44_hw.dao.SortAndSearch;
import l44_hw.model.SortAndSearchImpl;

import java.util.Arrays;

public class SortAndSearchAppl {
    public static void main(String[] args) {
        SortAndSearch sortAndSearch = new SortAndSearchImpl();

        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        int[] arrCopy = Arrays.copyOf(arr, arr.length); // Create a copy for comparison with Arrays.binarySearch

        System.out.println("Original array:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();

        sortAndSearch.bubbleSort(arr);
        System.out.println("Sorted array using bubble sort:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();

        int target = 25;
        int targetNotFound = 30; // Element not present in the array

        int indexBubble = sortAndSearch.myBinarySearch(arr, target);
        if (indexBubble != -1) {
            System.out.println("Element " + target + " found at position " + indexBubble + " using custom binary search");
        } else {
            System.out.println("Element " + target + " not found using custom binary search");
        }

        int indexBubbleNotFound = sortAndSearch.myBinarySearch(arr, targetNotFound);
        if (indexBubbleNotFound != -1) {
            System.out.println("Element " + targetNotFound + " found at position " + indexBubbleNotFound + " using custom binary search");
        } else {
            System.out.println("Element " + targetNotFound + " not found using custom binary search");
        }

        Arrays.sort(arrCopy); // Sort the array before using Arrays.binarySearch
        int indexArraysFound = Arrays.binarySearch(arrCopy, target);
        if (indexArraysFound >= 0) {
            System.out.println("Element " + target + " found at position " + indexArraysFound + " using Arrays.binarySearch");
        } else {
            System.out.println("Element " + target + " not found using Arrays.binarySearch");
        }

    }
}
