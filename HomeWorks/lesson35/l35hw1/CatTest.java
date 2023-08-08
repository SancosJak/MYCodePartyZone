package l35hw1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;

class CatTest {

    private Cat[] cats;

    @BeforeEach
    void setUp() {
        cats = new Cat[6];

        cats[0] = new Cat("Garfield", 3);
        cats[1] = new Cat("Simba", 5);
        cats[2] = new Cat("Bagheera", 2);
        cats[3] = new Cat("Meowth", 1);
        cats[4] = new Cat("Luna", 4);
        cats[5] = new Cat("Tiger", 6);
    }

    private void printArray(Object[] arr, String title) {
        System.out.println("===== " + title + " =====");
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    @Test
    void testBinarySearch() {
        printArray(cats, "Original array");
        Arrays.sort(cats);
        printArray(cats, "Natural order (age)");

        Cat pattern = new Cat(null, 4);
        int index = Arrays.binarySearch(cats, pattern);
        System.out.println("Index = " + index);
    }

    @Test
    void testBinarySearchByName() {
        printArray(cats, "Original array");

        Comparator<Cat> catComparator = Comparator.comparing(Cat::getName);

        Arrays.sort(cats, catComparator);
        printArray(cats, "Sort by name");

        Cat pattern = new Cat("Luna", 0);
        int index = Arrays.binarySearch(cats, pattern, catComparator);
        System.out.println("Index = " + index);
    }

    @Test
    void testArrayCopy() {
        printArray(cats, "Original array");

        Cat[] catsCopy = Arrays.copyOf(cats, cats.length * 2);
        printArray(catsCopy, "catsCopy before sorting");

        Comparator<Cat> catComparator = Comparator.comparing(Cat::getName);
        Arrays.sort(catsCopy, 0, cats.length, catComparator);
        printArray(catsCopy, "catsCopy after sorting");
    }
}