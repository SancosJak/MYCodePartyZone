package l28hw2;

import java.util.Arrays;
import java.util.Random;

public class Main {
    public static int[][] findDuplicates(int[] array) {
        // Сначала сортируем массив, чтобы легче было найти дубликаты
        Arrays.sort(array);

        int[][] duplicatesInfo = new int[array.length][2];
        int duplicatesCount = 0;
        int currentNumber = array[0];
        int currentCount = 1;

        for (int i = 1; i < array.length; i++) {
            if (array[i] == currentNumber) {
                currentCount++;
            } else {
                if (currentCount > 1) {
                    duplicatesInfo[duplicatesCount][0] = currentNumber;
                    duplicatesInfo[duplicatesCount][1] = currentCount;
                    duplicatesCount++;
                }
                currentNumber = array[i];
                currentCount = 1;
            }
        }

        if (currentCount > 1) {
            duplicatesInfo[duplicatesCount][0] = currentNumber;
            duplicatesInfo[duplicatesCount][1] = currentCount;
            duplicatesCount++;
        }

        // Создаем новый массив с нужным размером, чтобы избавиться от лишних элементов
        int[][] result = new int[duplicatesCount][2];
        System.arraycopy(duplicatesInfo, 0, result, 0, duplicatesCount);

        return result;
    }

    public static void main(String[] args) {
        int[] array = new int[100];
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(10) + 1;
        }

        System.out.println("Random array:");
        System.out.println(Arrays.toString(array));

        int[][] duplicatesInfo = findDuplicates(array);

        System.out.println("Numbers with duplicates and their counts:");
        for (int[] info : duplicatesInfo) {
            System.out.println("Number " + info[0] + " found " + info[1] + " times.");
        }
    }
}
