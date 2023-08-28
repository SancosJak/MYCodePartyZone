package soldier;
/*
Задание 1. Сделать тесты для метода bubbleSort(T[] arr, Comparator comparator)
- для целых чисел
- для строк

Задание 2.
- сравнить Soldiers по весу
- по росту и затем по весу
 */

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import practice.arrayMethods.ArrayTools;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.*;

class SoldierTest {
    private Soldier[] soldiers;
    private Integer[] intArray;
    private String[] stringArray;

    Integer[] arrNum;
    String[] arrStr;
    Soldier[] soldiers1;

    @BeforeEach
    void setUp() {
        intArray = new Integer[]{5, 12, 9, 20, 7, 15, 3, 18, 10, 25};
        stringArray = new String[]{"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        soldiers = new Soldier[]{
                new Soldier("John", 180, 75, 50),
                new Soldier("Mike", 185, 90, 60),
                new Soldier("Bob", 175, 80, 30),
                new Soldier("David", 178, 68, 45),
                new Soldier("James", 182, 72, 55),
        };


        arrNum = new Integer[] {9, 7, 4, 7, 2, 5, 9, 1, 0};
        arrStr = new String[] {"one", "two", "three", "four", "five"};
        soldiers1 = new Soldier[]{
                new Soldier("John", 182, 82.3, 81),
                new Soldier("Peter", 175, 77.1, 75),
                new Soldier("Robin", 182, 69.3, 92),
                new Soldier("Mary", 159, 55.1, 91),
                new Soldier("Anna", 162, 55.0, 88)
        };
    }

    @Test
    void testPrintArray() {
        System.out.println("Testing printArray - Soldiers:");
        ArrayTools.printArray(soldiers);

        System.out.println("Testing printArray - Integers:");
        ArrayTools.printArray(intArray);

        System.out.println("Testing printArray - Strings:");
        ArrayTools.printArray(stringArray);

        System.out.println("Testing printArray - arrNum:");
        ArrayTools.printArray(arrNum);

        System.out.println("Testing printArray - arrStr:");
        ArrayTools.printArray(arrStr);

        System.out.println("Testing printArray - soldiers1:");
        ArrayTools.printArray(soldiers1);
    }

    @Test
    void testSearchIndex() {
        int index = ArrayTools.searchIndex(soldiers, new Soldier("John", 180, 75, 50));
        assertEquals(0, index);

        index = ArrayTools.searchIndex(soldiers, new Soldier("Nick", 160, 60, 20));
        assertEquals(-1, index);

        int intIndex = ArrayTools.searchIndex(intArray, 7);
        assertEquals(4, intIndex);

        intIndex = ArrayTools.searchIndex(intArray, 100);
        assertEquals(-1, intIndex);

        int stringIndex = ArrayTools.searchIndex(stringArray, "Saturday");
        assertEquals(5, stringIndex);

        stringIndex = ArrayTools.searchIndex(stringArray, "Tuesday");
        assertEquals(1, stringIndex);

        int res = ArrayTools.searchIndex(arrNum, 7);
        assertEquals(1, res);
        assertEquals(-1, ArrayTools.searchIndex(arrNum, 100));

        int indexSTR = ArrayTools.searchIndex(arrStr, "four");
        assertEquals(3, indexSTR);
        assertEquals(-1, ArrayTools.searchIndex(arrStr, "ten"));

        int indexSol = ArrayTools.searchIndex(soldiers1, new Soldier("Anna",162,55.0,88));
        assertEquals(4, indexSol);

    }

    @Test
    void testSearchBoolean() {
        boolean found = ArrayTools.searchBoolean(soldiers, new Soldier("Bob", 175, 80, 30));
        assertTrue(found);

        found = ArrayTools.searchBoolean(soldiers, new Soldier("Nick", 160, 60, 20));
        assertFalse(found);

        boolean intFound = ArrayTools.searchBoolean(intArray, 15);
        assertTrue(intFound);

        intFound = ArrayTools.searchBoolean(intArray, 100);
        assertFalse(intFound);

        boolean stringFound = ArrayTools.searchBoolean(stringArray, "Monday");
        assertTrue(stringFound);

        stringFound = ArrayTools.searchBoolean(stringArray, "text");
        assertFalse(stringFound);
    }

    @Test
    void testFindByPredicate() {
        Predicate<Soldier> soldierPredicate = soldier -> soldier.getProfile() >= 50;
        Soldier foundSoldier = ArrayTools.findByPredicate(soldiers, soldierPredicate);
        assertNotNull(foundSoldier);
        assertEquals("John", foundSoldier.getName());

        soldierPredicate = soldier -> soldier.getProfile() >= 80;
        foundSoldier = ArrayTools.findByPredicate(soldiers, soldierPredicate);
        assertNull(foundSoldier);

        Predicate<Integer> intPredicate = num -> num > 10;
        Integer foundInt = ArrayTools.findByPredicate(intArray, intPredicate);
        assertEquals(Integer.valueOf(12), foundInt);

        intPredicate = num -> num > 30;
        foundInt = ArrayTools.findByPredicate(intArray, intPredicate);
        assertEquals(null, foundInt);

        Predicate<String> stringPredicate = str -> str.startsWith("S");
        String foundString = ArrayTools.findByPredicate(stringArray, stringPredicate);
        assertEquals("Saturday", foundString);

        stringPredicate = str -> str.length() > 7;
        foundString = ArrayTools.findByPredicate(stringArray, stringPredicate);
        assertEquals("Wednesday", foundString);

        Integer res = ArrayTools.findByPredicate(arrNum, n -> n < 5);
        assertEquals(4, res);

        String res1 = ArrayTools.findByPredicate(arrStr, s -> s == "two");
        assertEquals("two", res1);
        res1 = ArrayTools.findByPredicate(arrStr, s -> s.length() == 5);
        assertEquals("three", res1);

        Soldier soldat = ArrayTools.findByPredicate(soldiers1, soldiers1 -> soldiers1.getHeight() < 180);
        assertEquals(soldiers1[1], soldat);
    }
    @Test
    void testBubbleSortWithComparable_Integer() {
        ArrayTools.bubbleSortWithComparable(arrNum);
        Integer[] expected = new Integer[] {0, 1, 2, 4, 5, 7, 7, 9, 9};
        assertArrayEquals(expected, arrNum);
    }

    @Test
    void testBubbleSortWithComparable_String() {
        ArrayTools.bubbleSortWithComparable(arrStr);
        String[] expected = new String[] {"five", "four", "one", "three", "two"};
        assertArrayEquals(expected, arrStr);
    }

    @Test
    void testBubbleSortWithComparable_Soldier() {
        ArrayTools.bubbleSortWithComparable(soldiers1);
        Soldier[] expected = new Soldier[]{
                new Soldier("Mary", 159, 55.1, 91),
                new Soldier("Anna", 162, 55.0, 88),
                new Soldier("Peter", 175, 77.1, 75),
                new Soldier("Robin", 182, 69.3, 92),
                new Soldier("John", 182, 82.3, 81)
        };
        assertArrayEquals(expected, soldiers1);
    }
    @Test
    void testBubbleSortWithComparator_Integer() {
        Integer[] expected = {0, 1, 2, 4, 5, 7, 7, 9, 9};
        Comparator<Integer> comparator = Integer::compareTo;
        //Comparator<Integer> comparator = (a,b) -> a.intValue();
        ArrayTools.bubbleSortWithComparator(arrNum, comparator);
        assertArrayEquals(expected, arrNum);

        // check empty array
        Integer[] emptyArray = new Integer[0];
        ArrayTools.bubbleSortWithComparator(emptyArray, comparator);
        assertArrayEquals(new Integer[0], emptyArray);

        // reverse sorted array
        Integer[] reverseArray = {9, 9, 7, 7, 5, 4, 2, 1, 0};
        ArrayTools.bubbleSortWithComparator(reverseArray, comparator);
        assertArrayEquals(expected, reverseArray);
    }

    @Test
    void testBubbleSortWithComparator_String() {
        String[] expected = {"five", "four", "one", "three", "two"};
        Comparator<String> comparator = String::compareTo;
        ArrayTools.bubbleSortWithComparator(arrStr, comparator);
        assertArrayEquals(expected, arrStr);

        String[] emptyArray = new String[0];
        ArrayTools.bubbleSortWithComparator(emptyArray, comparator);
        assertArrayEquals(new String[0], emptyArray);

        String[] reverseArray = {"five", "four", "three", "two", "one"};
        ArrayTools.bubbleSortWithComparator(reverseArray, comparator);
        assertArrayEquals(expected, reverseArray);
    }

    @Test
    void testBubbleSortWithComparator_Soldier() {
        Soldier[] expected = {
                new Soldier("Anna", 162, 55.0, 88),
                new Soldier("John", 182, 82.3, 81),
                new Soldier("Mary", 159, 55.1, 91),
                new Soldier("Peter", 175, 77.1, 75),
                new Soldier("Robin", 182, 69.3, 92)
        };

        assertFalse(Arrays.equals(expected, soldiers1)); // Checking if an array is not sorted first
        //Comparator<Soldier> comparator = (s1,s2) -> s1.getName().compareTo(s2.getName());
        Comparator<Soldier> comparator = Comparator.comparing(Soldier::getName);
        ArrayTools.bubbleSortWithComparator(soldiers1, comparator); // sorting
        assertArrayEquals(expected, soldiers1); // checking after sorting

        // Checking for reverse sort order
        Comparator<Soldier> reverseComparator = comparator.reversed();
        ArrayTools.bubbleSortWithComparator(soldiers1, reverseComparator);
        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], soldiers1[soldiers1.length - 1 - i]);
        }
    }
    @Test
    void testBubbleSortWithComparator_SoldierByWeight() {
        Soldier[] expectedByWeight = {
                new Soldier("Anna", 162, 55.0, 88),
                new Soldier("Mary", 159, 55.1, 91),
                new Soldier("Robin", 182, 69.3, 92),
                new Soldier("Peter", 175, 77.1, 75),
                new Soldier("John", 182, 82.3, 81)
        };

        assertFalse(Arrays.equals(expectedByWeight, soldiers1));
        Comparator<Soldier> comparator1 = Comparator.comparingDouble(Soldier::getWeight);
        ArrayTools.bubbleSortWithComparator(soldiers1, comparator1);
        assertArrayEquals(expectedByWeight, soldiers1);
    }
    @Test
    void testBubbleSortWithComparator_SoldierByHeight() {
        Soldier[] expectedByHeight  = {
                new Soldier("Mary", 159, 55.1, 91),
                new Soldier("Anna", 162, 55.0, 88),
                new Soldier("Peter", 175, 77.1, 75),
                new Soldier("John", 182, 82.3, 81),
                new Soldier("Robin", 182, 69.3, 92)

        };

        assertFalse(Arrays.equals(expectedByHeight, soldiers1));
        Comparator<Soldier> comparator2 = Comparator.comparingDouble(Soldier::getHeight);
        ArrayTools.bubbleSortWithComparator(soldiers1, comparator2);
        assertArrayEquals(expectedByHeight, soldiers1);
    }
    @Test
    void testBubbleSortWithComparator_Soldier_ByWeightAfterHeight() {
        Soldier[] expectedByWeightAfterHeight = {
                new Soldier("Mary", 159, 55.1, 91),
                new Soldier("Anna", 162, 55.0, 88),
                new Soldier("Peter", 175, 77.1, 75),
                new Soldier("Robin", 182, 69.3, 92),
                new Soldier("John", 182, 82.3, 81)
        };

        assertFalse(Arrays.equals(expectedByWeightAfterHeight, soldiers1));

        Comparator<Soldier> heightComparator = Comparator.comparingDouble(Soldier::getHeight);
        Comparator<Soldier> weightComparator = Comparator.comparingDouble(Soldier::getWeight);
        Comparator<Soldier> WeightAfterHeightComparator = heightComparator.thenComparing(weightComparator);

        ArrayTools.bubbleSortWithComparator(soldiers1, WeightAfterHeightComparator);

        assertArrayEquals(expectedByWeightAfterHeight, soldiers1);
    }

}
