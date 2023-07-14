import java.util.Scanner;

/*
В сберкассу на трёхпроцентный вклад положили S рублей. Какой станет сумма вклада через N лет?
 */
public class  Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Enter your preferred deposit amount (in ₽.): ");
        double deposit = in.nextDouble();

        System.out.println("For how many years would you like to invest your amount ?");
        int year = in.nextInt();

        while (year > 0) {
            double percentDeposit = (deposit * 3) / 100;
            deposit += percentDeposit;
            year--;
        }

        System.out.println("Your deposit amount will be: " + Math.round(deposit) + " ₽.");

    }
}
