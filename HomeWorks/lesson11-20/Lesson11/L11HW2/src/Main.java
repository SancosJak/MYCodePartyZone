import java.util.Scanner;
/*
Вводится n - натуральное число. Напишите метод, который получает на вход n и вычисляет
n! = 1 * 2 * 3 *... * n. Вызовите полученный метод. При каком значении n происходит переполнение памяти,
выделяемой для n типа int? Использовать цикл for.
 */
public class  Main {

    static long getFactorial(int n) {
        long result = 1;
        for (int i = 1; i <= n; i++) {
            result = result * i;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Provide a value to calculate the factorial N:");
        int num = in.nextInt();
        long factorial = getFactorial(num);

        int maxInt = Integer.MAX_VALUE; // макс. значение int
        int i = 1;
        while (i <= maxInt) {
            long f = getFactorial(i);
            if (f < 0) {
                System.out.println("A memory overflow of type int occurs when n = " + i);
                break;
            }
            i++;

        }
        System.out.println("The factorial of the number " + num + " is : " + factorial);
    }
}
