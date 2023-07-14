import java.util.Random;
/*
Создайте массив из 100 случайных целых чисел в интервале от -10 до 10.
Подсчитайте, сколько в этом массиве оказалось:

положительных чисел;
отрицательных чисел;
четных чисел;
нулей.
 */
public class Main {
    public static void main(String[] args) {
        int[] array = new int[100];
        Random random = new Random();

        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(21) - 10;
        }

        System.out.println("Random array from -10 to 10:");
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();

        int positiveCount = 0;
        int negativeCount = 0;
        int evenCount = 0;
        int zeroCount = 0;

        for (int num : array) {
            if (num > 0) {
                positiveCount++;

            } else if (num < 0) {
                negativeCount++;
            }

            if (num % 2 == 0) {
                evenCount++;
            }

            if (num == 0) {
                zeroCount++;
            }
        }

        int[] positiveArray = new int[positiveCount];
        int[] negativeArray = new int[negativeCount];
        int[] evenArray = new int[evenCount];
        int[] zeroArray = new int[zeroCount];

        int positiveIndex = 0;
        int negativeIndex = 0;
        int evenIndex = 0;
        int zeroIndex = 0;

        for (int num : array) {
            if (num > 0) {
                positiveArray[positiveIndex] = num;
                positiveIndex++;
            } else if (num < 0) {
                negativeArray[negativeIndex] = num;
                negativeIndex++;
            }

            if (num % 2 == 0) {
                evenArray[evenIndex] = num;
                evenIndex++;
            }

            if (num == 0) {
                zeroArray[zeroIndex] = num;
                zeroIndex++;
            }
        }

        System.out.println("Q-ty of positive numbers from random array: " + positiveCount);
        System.out.println("Positive numbers:");
        for (int num : positiveArray) {
            System.out.print(num + " ");
        }
        System.out.println();

        System.out.println("Q-ty of negative numbers from random array: " + negativeCount);
        System.out.println("Negative numbers:");
        for (int num : negativeArray) {
            System.out.print(num + " ");
        }
        System.out.println();

        System.out.println("Q-ty of even numbers from random array: " + evenCount);
        System.out.println("Even numbers:");
        for (int num : evenArray) {
            System.out.print(num + " ");
        }
        System.out.println();

        System.out.println("Q-ty of zero numbers from random array: " + zeroCount);
        System.out.println("Zero:");
        for (int num : zeroArray) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
