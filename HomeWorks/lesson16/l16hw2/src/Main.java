import java.util.Arrays;
/*
Задан массив целых чисел {-5, 17, 23, -30, 22, 18, -3, 77, 19, -2}.
Найдите среднюю величину по всем элементам массива с четными индексами.
 */
public class Main {
    public static void main(String[] args) {
        int[] array = {-5, 17, 23, -30, 22, 18, -3, 77, 19, -2};
        int sum = 0;
        int count = 0;

        for (int i = 0; i < array.length; i += 2) {
            sum += array[i];
            count++;
        }

        double average = (double) sum / count;

        System.out.print("Array elements: ");
        System.out.println(Arrays.toString(array));
        System.out.println("The average value of the elements of an array with even indices: " + average);
    }
}