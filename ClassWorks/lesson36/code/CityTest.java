package code;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CityTest {
    City[] cities;

    @BeforeEach
    void setUp() {
        cities = new City[6];

        cities[0] = new City("Denver", 600_000);
        cities[1] = new City("Boston", 670_000);
        cities[2] = new City("Chicago", 2_700_000);
        cities[3] = new City("Atlanta", 470_000);
        cities[4] = new City("New York", 8_500_000);
        cities[5] = new City("Dallas", 1_300_000);
    }

    private void printArray(Object[] arr, String title) {
        System.out.println("===== " + title + " =====");
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    @Test
    void testCopyOfRange(){
        printArray(cities, "Original Array");
        City[] citiesCopyRange = Arrays.copyOfRange(cities, 1, cities.length -1);
        printArray(citiesCopyRange, "After copy of range array");
        assertEquals(4, citiesCopyRange.length);
        assertEquals("Boston", citiesCopyRange[0].getName());
        assertEquals("Chicago", citiesCopyRange[1].getName());
        assertEquals("Atlanta", citiesCopyRange[2].getName());
        assertEquals("New York", citiesCopyRange[3].getName());
    }


    @Test
    void testSystemArrayCopy(){
        printArray(cities, "Original Array");
        City[] citiesCopy = new City[cities.length * 2];
        System.arraycopy(cities, 1, citiesCopy, 5, cities.length - 2);
        printArray(citiesCopy, "After array copy");
    }

    @Test
    void testInsertAndKeepSorted() {
        printArray(cities,"Original order");
        Arrays.sort(cities);
        printArray(cities,"Natural order");
        City city = new City("SanFrancisco",690_000);
        // откопировать массив в новый массив с длиной + 1
        City[] citiesCopy = Arrays.copyOf(cities,cities.length+1);
        // найти индекс для вставляемого города с помощью BinarySearch
        int index = Arrays.binarySearch(citiesCopy,0,citiesCopy.length-1, city);
        System.out.println(index);
        // определить реальный индекс, на какое место вставлять новый город
        index = index >= 0 ? index : - index - 1;
        // сдвинуть весь массив вправо на 1 позицию (освобождаем место новому городу)
        System.arraycopy(citiesCopy, index, citiesCopy, index + 1, citiesCopy.length - index - 1);
        // поставить новый город на нужное место
        citiesCopy[index] = city;
        // сделать массив опять с именем cities
        cities = citiesCopy;
        // напечатать полученный массив
        printArray(cities, "Order after insert new city");
    }
}