import java.util.Arrays;
/*
Создайте массив из 20 случайных целых чисел в интервале от 10 до 20. Выведите массив на печать.
Поменяйте местами первый и последний элементы массива и снова выведите массив на печать.
 */
public class Main {
    public static void main(String[] args) {
        int[] array = new int[20];

        for (int i = 0; i < array.length; i++) {
            int a = 10;
            int b = 20;
            array[i] = (int)(Math.random() * (b - a + 1) + a);
        }
        System.out.println("An array of 20 random integers in the range from 10 to 20");
        System.out.println(Arrays.toString(array));

        int temp = array[0];
        array[0] = array[19];
        array[19] = temp;

        System.out.println("Swap the first and last elements of the array");
        System.out.println(Arrays.toString(array));
    }
}