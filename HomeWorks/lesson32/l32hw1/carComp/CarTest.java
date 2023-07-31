package carComp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class CarTest{
    Car[] cars;

    @BeforeEach
    void setUp() {
        cars = new Car[]{
                new Car( "S-Class", "Mercedes-Benz", 4.0, 150000),
                new Car( "3 Series", "BMW", 3.0,205000),
                new Car( "Model S", "Tesla", 0.0,12000),
                new Car( "Aventador", "Lamborghini", 6.5, 280000),
                new Car( "911", "Porsche", 3.8, 145000)
        };
    }
     @Test
    void sortByModel(){
         System.out.println("--------Cars unsorted----------");
         printArray(cars);
         Arrays.sort(cars);
         System.out.println("--------Cars sorted by model----------");
         printArray(cars);
     }
    @Test
    void sortByCompany(){
        System.out.println("--------Cars unsorted----------");
        printArray(cars);
        Arrays.sort(cars);
        System.out.println("--------Cars sorted by company----------");
        printArray(cars);
    }
    @Test
    void sortByEngine(){
        System.out.println("--------Cars unsorted----------");
        printArray(cars);
        Arrays.sort(cars);
        System.out.println("--------Cars sorted by engine----------");
        printArray(cars);
    }
    @Test
    void sortByMileage(){
        System.out.println("--------Cars unsorted----------");
        printArray(cars);
        Arrays.sort(cars);
        System.out.println("--------Cars sorted by mileage----------");
        printArray(cars);
    }
    public void printArray(Object[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);

        }
    }
}
