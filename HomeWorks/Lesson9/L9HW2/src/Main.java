import java.util.Scanner;

public class  Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Enter integer and positive number:");
        int n = in.nextInt();
        int summa = 0;

        while (n!=0){
            summa += n % 10;
            n /= 10;
        }
        System.out.println("The sum of the digits of your number = " + summa);
    }
}
