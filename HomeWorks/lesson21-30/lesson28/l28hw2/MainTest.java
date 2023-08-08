package l28hw2;
// Сделать тесты для методов из задачи о поиске дубликатов в массиве.
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MainTest {
    private int[] testArray;
    private int[][] expectedDuplicates;

    @BeforeEach
    void setUp() {
        testArray = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        expectedDuplicates = new int[][]{{1, 2}, {2, 2}, {3, 2}, {4, 2}, {5, 2}, {6, 2}, {7, 2}, {8, 2}, {9, 2}, {10, 2}};
    }

    @Test
    void findDuplicatesTest() {
       int[][] duplicatesInfo = Main.findDuplicates(testArray);
       assertArrayEquals(expectedDuplicates, duplicatesInfo);
    }
}
