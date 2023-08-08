import java.util.Scanner;

/*
Бизнесмен взял ссуду m тысяч рублей в банке под 10% годовых.
Через сколько лет его долг превысит s тысяч рублей, если за это время он не будет отдавать долг.
 */
public class  Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Enter the initial amount of debt (thousands of ₽.): ");
        double m = in.nextDouble();

        System.out.println("Enter the specified amount that the debt should not exceed (thousands of ₽.): ");
        double s = in.nextDouble();

        int year = 0;
        while (m <= s) {
            double sm = (m * 10) / 100;
            m += sm;
            year++;
        }

        System.out.println("Your debt " + s+ " ₽ will exceed through " + year + " years");

    }
}
