import java.util.Arrays;
import java.util.Random;
/*
Написать метод, принимающий массив целых чисел, и возвращающий произведение всех его элементов,
с четными индексами. 0 - тоже четное число.
 */
public class Main {
    public static int[] generateArray(int size, int min, int max) {
        int[] array = new int[size];
        Random randomArray = new Random();
        for (int i = 0; i < size; i++) {
            array[i] = randomArray.nextInt(max - min + 1) + min;
        }
        return array;
    }
    public static int mult (int[] arr) { //Multiply elements with even index
        int result = 1;
        for (int i = 0; i < arr.length; i += 2) {
            result *= arr[i];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] array = generateArray(10, 0, 20); //Generate Random Array
        // int[] array = {1, 2, 0, 4, 5, 6, 7, 8}; // for quick check index[0] = 2; mult = 0;
        // int[] array = {1, 0, 3, 4, 5, 6, 7, 8}; // for quick check index[0] = 1; mult = 105;
        int res = mult(array);
        System.out.println("Array: " + Arrays.toString(array));
        System.out.println("Multiply elements with even index: " + res);
    }
}