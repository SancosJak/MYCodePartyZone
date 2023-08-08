import java.util.Arrays;
import java.util.Random;
/*
Написать метод, принимающий массив целых чисел, и возвращающий сумму всех его нечетных элементов
(не индексы!, а сами элементы).
Массив на 100 элементов задать случайными числами в интервале от 1 до 100.
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
    public static int sumOfOddElements(int[] array) {
        int sum = 0;
        for (int element : array) {
            if (element % 2 != 0) {
                sum += element;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] array = generateArray(100, 1, 100); //Generate Random Array
        int summa = sumOfOddElements(array); // Calculating the sum of odd elements
        System.out.println("Array: " + Arrays.toString(array));
        System.out.println("The sum of odd elements: " + summa);
    }
}