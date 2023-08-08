import java.util.Arrays;
import java.util.Random;

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
        System.out.println(" Random  dumplings : " + Arrays.toString(pelmeniWeights));

        int luckyPelmenIndex = (int)(Math.random() * numPelmeni); // Random index of happy dumplings
        pelmeniWeights[luckyPelmenIndex] += 15; // Put a coin of 15 grams in a lucky dumpling
        System.out.println("Inc. lucky dumpling: " + formatArrayWithHighlight(pelmeniWeights, luckyPelmenIndex));

        int index = 0; // lucky dumpling index

        for (int i = 0; i < pelmeniWeights.length; i++) {
            if (pelmeniWeights[i] == pelmeniWeights[luckyPelmenIndex]) {
                index = i+1;
                break;
            }
        }

        System.out.println();
        System.out.println("The lucky dumpling is: " + index);
    }
    // метод нашел и применил. Для удобства сравнения массивов
    public static String formatArrayWithHighlight(int[] array, int highlightIndex) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < array.length; i++) {
            if (i == highlightIndex) {
                sb.append("\u001B[33m"); // Set text color to yellow
            }
            sb.append(array[i]);
            if (i == highlightIndex) {
                sb.append("\u001B[0m"); // Reset text color
            }
            if (i < array.length - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }


}
