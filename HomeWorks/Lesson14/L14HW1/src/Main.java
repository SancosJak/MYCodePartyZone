import java.util.Arrays;
import java.util.Random;
/*
Написать метод, принимающий массив целых чисел, и возвращающий сумму всех его нечетных элементов
(не индексы!, а сами элементы).
Массив элементов задать случайными числами.
 */

/*
изменить код задач про:
- сумма четных чисел в массиве
- множать числа с четными индексами в массиве так, чтобы использовались операторы break или continue.
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
    public static int sumOfEvenElements(int[] array) {
        int sum = 0;
        for (int element : array) {
            if (element % 2 == 0) {
                sum += element;
            }
        }
        return sum;
    }

    public static int multiplyEvenIndex(int[] array) {
        int result = 1;
        for (int i = 0; i < array.length; i++) {
            if (i % 2 == 1) {
                continue;
            }
            result *= array[i];
            if (result == 0) {
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] array = generateArray(10, 1, 20);
        int sumE = sumOfEvenElements(array); // Calculate the sum of even elements
        int sumO = sumOfOddElements(array); // Calculate the sum of odd elements
        int multiplication = multiplyEvenIndex(array); // Multiply numbers with even index

        System.out.println("Array: " + Arrays.toString(array));
        System.out.println("The sum of odd elements: " + sumO);
        System.out.println("The sum of even elements: " + sumE);
        System.out.println("Multiplication of numbers with even indices: " + multiplication);
    }
}
