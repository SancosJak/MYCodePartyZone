import java.util.Scanner;
/*
(на повторение темы массивы, циклы и вычисления)
Вводится пользователем натуральное число n.
Сформировать массив из всех делителей данного числа.
 */
public class Main{
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.print("Enter the natural number n: ");
        int n = in.nextInt();

        int[] divisorsArray = new int[n];
        int count = 0;

        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                divisorsArray[count] = i;
                count++;
            }
        }

        System.out.println("An array of divisors of a number " + n + ":");
        for (int i = 0; i < count; i++) {
            System.out.print(divisorsArray[i] + " ");
        }
    }
}
