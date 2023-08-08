import java.util.Arrays;
import java.util.Random;
/*
Написать метод, принимающий массив целых чисел, и разворачивающий его.
Последний элемент становится нулевым, предпоследний, первым, и т. д.
Подсказка: этот метод должен изменить полученный массив.
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

    public static void reverseArray(int[] arr) {
        int[] reversedArray = new int[arr.length];
        int index = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            reversedArray[index] = arr[i];
            index++;
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = reversedArray[i];
        }
    }

    public static void main(String[] args) {
        int[] array = generateArray(10, 0, 20);
        System.out.println("Random array: " + Arrays.toString(array));
        reverseArray(array);
        System.out.println("Reverse array: " + Arrays.toString(array));
    }
}
