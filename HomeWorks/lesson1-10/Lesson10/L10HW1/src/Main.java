import java.util.Scanner;

/*
С клавиатуры вводятся N чисел. Составьте программу, которая определяет кол-во отрицательных,
кол-во положительных и кол-во нулей среди введеных чисел. Значение N вводится с клавиатуры.
 */
public class  Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("How many numbers do you want to enter?");
        int n = in.nextInt();
        int qtyPos = 0;
        int qtyNeg = 0;
        int qtyZero = 0;

        int i = 1;
        while (i <= n) {
            System.out.println("Enter your " + i + " number: ");
            double enterN = in.nextDouble();

            if (enterN > 0) {
                qtyPos++;
            } else if (enterN < 0) {
                qtyNeg++;
            }else {
                qtyZero++;
            }
            i++;
        }

        System.out.println("Q-ty of positive numbers entered: " + qtyPos);
        System.out.println("Q-ty of negative numbers entered: " + qtyNeg);
        System.out.println("Q-ty of zeros entered: " + qtyZero);
    }
}
