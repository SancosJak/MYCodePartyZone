import java.util.Scanner;
/*
Написать метод, определяющий максимум из трех натуральных чисел.
Метод должен быть защищен от ввода отрицательных чисел.
 */
public class Main {
    public static int getMax(int n1, int n2, int n3) {
        if (n1 > 0 && n2 > 0 && n3 > 0) {
            return Math.max(n1, Math.max(n2,n3));
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Enter the first natural number: ");
        int n1= in.nextInt();

        System.out.println("Enter the second natural number: ");
        int n2= in.nextInt();

        System.out.println("Enter the third natural number: ");
        int n3= in.nextInt();

        int result = getMax(n1,n2,n3);
        if (result != -1) {
            System.out.println("A maximum of three natural numbers: " + result);
        } else {
            System.out.println("Wrong input! One of the numbers you entered isn`t natural");
        }
    }
}