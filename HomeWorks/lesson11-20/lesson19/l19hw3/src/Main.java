import java.util.Arrays;
import java.util.Scanner;
/*
(на повторение темы массивы, циклы и вычисления)
Найти все простые числа меньше введенного числа n и занести их в массив.
В консоли распечатать само число, количество найденных простых чисел и сами эти числа.
Пример: дано число 30 простые числа, меньшие 30 это: 2, 3, 5, 7, 11, 13, 17, 19, 23, 29 таких чисел: 10
 */
public class Main {

    // Проверка числа на простоту
    public static boolean isPrime(int number) {
        for (int i = 2; i < number - 1; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.print("Enter the number n: ");
        int n = in.nextInt();

        int[] primes = new int[n];
        int count = 0;

        // Проверяем каждое число меньше n на простоту
        for (int i = 2; i < n; i++) {
            if (isPrime(i)) {
                primes[count] = i;
                count++;
            }
        }

        System.out.println("Number n: " + n);
        System.out.println("Number of primes less than " + n + ": " + count);
        System.out.println("Prime numbers, smaller " + n + ": " + Arrays.toString(Arrays.copyOf(primes, count)));
    }

}
