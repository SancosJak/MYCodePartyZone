import java.util.Arrays;
/*
Задан массив целых чисел: 56, 73, 15, -10, 37, -14, 25, 65, 33, 38.
Найдите максимальный элемент массива и его индекс.
 */
public class Main {
    public static void main(String[] args) {
        int[] intArray = {56, 73, 15, -10, 37, -14, 25, 65, 33, 38};

        int maxNum = intArray[0];
        int maxIndex = 0;

        for (int i = 0; i < intArray.length; i++) {
            if (maxNum <= intArray[i]) {
                maxNum = intArray[i];
                maxIndex = i;
            }
        }
        System.out.println("Array of integers: ");
        System.out.println(Arrays.toString(intArray));
        System.out.println("Maximum number in array = " + maxNum);
        System.out.println("The index of the maximum element in the array = " + maxIndex);
    }
}