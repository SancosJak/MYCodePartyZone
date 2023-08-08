import java.util.Scanner;

/*
Составьте программу, которая вычисляет сумму чисел от 1 до 1/n. n вводится с клавиатуры.
Пример: n = 10 sum = 1 + 1/2 + 1/3 + ... + 1/10 Для вычисления sum используйте метод.
 */
public class  Main {

    public static double getSumma(double n) {
        double result = 0;
        for (int i = 1; i <= n; i++) {
            result = result + 1.0 / i;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Enter a value for the number N:");
        double num = in.nextDouble();
        double summa = getSumma(num);

        System.out.println("The sum of the numbers according to the formula is : " + summa);
    }
}
