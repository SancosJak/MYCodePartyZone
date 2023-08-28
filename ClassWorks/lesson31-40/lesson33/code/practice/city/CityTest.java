package practice.city;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;

class CityTest {
    City[] city;

    @BeforeEach
    void setUp() {
        city = new City[10];
            city[0] = new City("Berlin", 3645000, 60, "13555");
            city[1] = new City("Munchen", 1545000, 45, "86555");
            city[2] = new City("Bamberg", 400000, 35, "96138");
            city[3] = new City("Ausburg", 360000, 65, "86356");
            city[4] = new City("Hennef", 46114, 30, "53773");
            city[5] = new City("New-York", 8800000, 80, "1001");
            city[6] = new City("Moscow", 15000000, 70, "141000");
            city[7] = new City("Moscow", 150000, 60, "141000");
            city[8] = new City("Berlin", 3645, 50, "13000");
            city[9] = new City("Moscow", 15000000, 30, "141000");


    }
    @Test
    void testSortByName() {
        System.out.println("--------Array as is----------");
        printArray(city);

        Arrays.sort(city, (o1, o2) -> o1.getName().compareTo(o2.getName()));
        Arrays.sort(city, ((o1, o2) -> o1.getPopulation() - o2.getPopulation()));
        //Arrays.sort(city, Comparator.comparing(City::getName));
        System.out.println("--------Array sort by name----------");
        printArray(city);
    }

    @Test
    void testSortByComparator() {
        System.out.println("--------Array as is----------");
        printArray(city);

        Comparator<City> cityComparator = new Comparator<City>() {
            @Override
            public int compare(City o1, City o2) {
                int compareName = o1.getName().compareToIgnoreCase(o2.getName());
                int comparePopulation = o1.getPopulation() - o2.getPopulation();
                if(compareName != 0 ){
                    return compareName;
                } else if (comparePopulation != 0) {
                    return comparePopulation;
                } else{
                    return o1.getPollution() - o2.getPollution();
                }
            }
        };
        Arrays.sort(city, cityComparator);

        System.out.println("--------Array sort by comparator----------");
        printArray(city);
    }

    public void printArray(Object[] arr) {
        for (Object element : arr) {
            System.out.println(element);
        }
    }
}