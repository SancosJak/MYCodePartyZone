import java.util.Arrays;
import java.util.Random;
/*
Поиск дубликатов в массиве. Задумайте массив из 100 элементов и заполните его случайными значениями
целых чисел в интервале от 1 до 10. Подсчитайте сколько и каких элементов встретилось более одного
раза в этом массиве.
 */
public class Main {
    public static void main(String[] args) {

        int[] array = new int[100];
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(10) + 1;
        }

        System.out.println("Random array:");
        System.out.println(Arrays.toString(array));

        int[] count = new int[11];
        for (int num : array) {
            count[num]++;
        }

        int duplicatesCount = 0;
        for (int i = 1; i <= 10; i++) {
            if (count[i] > 1) {
                System.out.println("Number " + i + " found " + count[i] + " times.");
                duplicatesCount++;
            }
        }

        System.out.println("Total duplicates: " + duplicatesCount);
    }
}
