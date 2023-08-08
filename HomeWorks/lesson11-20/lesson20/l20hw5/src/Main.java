/*
Задан массив целых чисел {64, -13, 28, 37, 12, -17, 25, 18, -3, 40}
Выполните его сортировку методом bubble sort.

Пузырьковая сортировка — это самый простой алгоритм сортировки на основе сравнения,
который помогает нам сортировать массив, многократно обходя его,
сравнивая соседние элементы и меняя их местами на основе желаемых критериев сортировки.
Пузырьковая сортировка — это алгоритм на месте, то есть он не требует дополнительного места;
Вместо этого он изменяет исходный массив.
 */
public class Main {
    public static void printArray(int[] array) {
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
    public static void bubbleSort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    // Swap
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }
    public static void main(String[] args) {
        int[] array = {64, -13, 28, 37, 12, -17, 25, 18, -3, 40};

        System.out.println("Array:");
        printArray(array);

        bubbleSort(array);

        System.out.println("Sorted array by bubble method:");
        printArray(array);
    }

}
