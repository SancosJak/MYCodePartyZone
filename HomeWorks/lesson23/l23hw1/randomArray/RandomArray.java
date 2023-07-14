package randomArray;

import java.util.Random;

/*
Создайте массив из 100 случайных целых чисел в интервале от -10 до 10.
Подсчитайте, сколько в этом массиве оказалось:

положительных чисел;
отрицательных чисел;
четных чисел;
нулей.
Оформите решение данной задачи методами и напишите для них тесты.
 */
public class RandomArray {
    private int size;

    public RandomArray(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
    public static int[] generateRandomArray(int size, int minValue, int maxValue) {
        int[] array = new int[size];
        Random random = new Random();

        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(maxValue - minValue + 1) + minValue;
        }

        return array;
    }

    public static void printArray(int[] array) {
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
    public int countPositiveNumbers(int[] array) {
        int count = 0;
        for (int num : array) {
            if (num > 0) {
                count++;
            }
        }
        return count;
    }

    public int countNegativeNumbers(int[] array) {
        int count = 0;
        for (int num : array) {
            if (num < 0) {
                count++;
            }
        }
        return count;
    }

    public int countEvenNumbers(int[] array) {
        int count = 0;
        for (int num : array) {
            if (num % 2 == 0) {
                count++;
            }
        }
        return count;
    }

    public int countZeroNumbers(int[] array) {
        int count = 0;
        for (int num : array) {
            if (num == 0) {
                count++;
            }
        }
        return count;
    }

    public int[] filterPositiveNumbers(int[] array) {
        int count = countPositiveNumbers(array);
        int[] positiveArray = new int[count];
        int index = 0;
        for (int num : array) {
            if (num > 0) {
                positiveArray[index] = num;
                index++;
            }
        }
        return positiveArray;
    }

    public int[] filterNegativeNumbers(int[] array) {
        int count = countNegativeNumbers(array);
        int[] negativeArray = new int[count];
        int index = 0;
        for (int num : array) {
            if (num < 0) {
                negativeArray[index] = num;
                index++;
            }
        }
        return negativeArray;
    }

    public int[] filterEvenNumbers(int[] array) {
        int count = countEvenNumbers(array);
        int[] evenArray = new int[count];
        int index = 0;
        for (int num : array) {
            if (num % 2 == 0) {
                evenArray[index] = num;
                index++;
            }
        }
        return evenArray;
    }

    public int[] filterZeroNumbers(int[] array) {
        int count = countZeroNumbers(array);
        int[] zeroArray = new int[count];
        int index = 0;
        for (int num : array) {
            if (num == 0) {
                zeroArray[index] = num;
                index++;
            }
        }
        return zeroArray;
    }

   /* public static void main(String[] args) {
        int[] array = generateRandomArray(100, -10, 10);

        System.out.println("Random array from -10 to 10:");
        printArray(array);
        int positiveCount = countPositiveNumbers(array);
        int negativeCount = countNegativeNumbers(array);
        int evenCount = countEvenNumbers(array);
        int zeroCount = countZeroNumbers(array);

        int[] positiveArray = filterPositiveNumbers(array);
        int[] negativeArray = filterNegativeNumbers(array);
        int[] evenArray = filterEvenNumbers(array);
        int[] zeroArray = filterZeroNumbers(array);

        System.out.println("Q-ty of positive numbers from random array: " + positiveCount);
        System.out.println("Positive numbers:");
        printArray(positiveArray);

        System.out.println("Q-ty of negative numbers from random array: " + negativeCount);
        System.out.println("Negative numbers:");
        printArray(negativeArray);

        System.out.println("Q-ty of even numbers from random array: " + evenCount);
        System.out.println("Even numbers:");
        printArray(evenArray);

        System.out.println("Q-ty of zero numbers from random array: " + zeroCount);
        System.out.println("Zero:");
        printArray(zeroArray);
    }

    }
*/
}
