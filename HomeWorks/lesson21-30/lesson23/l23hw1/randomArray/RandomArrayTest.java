package randomArray;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
// Оформите решение данной задачи методами и напишите для них тесты.
import static org.junit.jupiter.api.Assertions.*;

class RandomArrayTest {
    RandomArray randomArray;

    @BeforeEach
    void setUp() {
        randomArray = new RandomArray(5);

    }

    @Test
    void countPositiveNumbersTest() {
        int[] arr = {1, -2, 3, -4, 5};
        assertEquals(3, randomArray.countPositiveNumbers(arr));
    }


    @Test
    void countNegativeNumbersTest() {
        int[] arr = {1, -2, 3, -4, 5};
        assertEquals(2, randomArray.countNegativeNumbers(arr));
    }

    @Test
    void countEvenNumbersTest() {
        int[] arr = {1, -2, 3, -4, 5};
        assertEquals(2, randomArray.countEvenNumbers(arr));

    }

    @Test
    void countZeroNumbersTest() {
        int[] arr = {1, -2, 0, -4, 0};
        assertEquals(2,randomArray.countZeroNumbers(arr));
    }
    @Test
    public void filterPositiveNumbersTest() {
        int[] array = {1, -2, 3, -4, 5};
        int[] positiveArray = randomArray.filterPositiveNumbers(array);
        int[] expected = {1, 3, 5};
        assertArrayEquals(expected, positiveArray);
    }
    @Test
    public void filterNegativeNumbersTest() {
        int[] array = {1, -2, 3, -4, 5};
        int[] negativeArray = randomArray.filterNegativeNumbers(array);
        int[] expected = {-2, -4};
        assertArrayEquals(expected, negativeArray);
    }

    @Test
    public void filterEvenNumbersTest() {
        int[] array = {1, -2, 3, -4, 5};
        int[] evenArray = randomArray.filterEvenNumbers(array);
        int[] expected = {-2, -4};
        assertArrayEquals(expected, evenArray);
    }

    @Test
    public void filterZeroNumbersTest() {
        int[] array = {1, -2, 0, -4, 0};
        int[] zeroArray = randomArray.filterZeroNumbers(array);
        int[] expected = {0, 0};
        assertArrayEquals(expected, zeroArray);
    }

}