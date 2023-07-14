import java.util.Random;
/*
(повторение и закрепление темы массивы, заполнение массива с помощью датчика случайных чисел)
Задача про поиск "счастливого пельменя", часть 1. Хозяйка налепила для гостей 30 пельменей,
каждый весом от 25 до 35 грамм. Напишите программу, которая занесет в массив данные о весе
каждого слепленного пельменя.
 */
public class Main {
    public static int[] generatePelmeniWeights(int numPelmeni, int minWeight, int maxWeight) {
        int[] weights = new int[numPelmeni];
        Random pelmenj = new Random();
        for (int i = 0; i < numPelmeni; i++) {
            weights[i] = pelmenj.nextInt(maxWeight - minWeight + 1) + minWeight;
        }
        return weights;
    }

    public static void main(String[] args) {
        int numPelmeni = 30;
        int minWeight = 25;
        int maxWeight = 35;

        int[] pelmeniWeights = generatePelmeniWeights(numPelmeni, minWeight, maxWeight);

        for (int i = 0; i < pelmeniWeights.length; i++) {
            System.out.println("Пельмень " + (i + 1) + ": " + pelmeniWeights[i] + " грамм ");
        }

    }
}