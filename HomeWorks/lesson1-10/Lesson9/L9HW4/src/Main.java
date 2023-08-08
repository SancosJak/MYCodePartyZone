import java.util.Scanner;

public class  Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Enter a six-digit number:");
        int number = in.nextInt();
        int sum1 = 0;
        int sum2 = 0;

// для примера число 143251

        //извлекаю последние 3 цифры  в обратном порядке 1 5 2 = сумма 8
        for (int i = 0; i < 3; i++) {
            sum2 += number % 10;
            number /= 10;
        }
        //извлекаю первые 3 цифры тоже в обратном порядке 3 4 1 = сумма 8
        for (int i = 3; i < 6; i++) {
            sum1 += number % 10;
            number /= 10;
        }

        if (sum1 == sum2) {
            System.out.println("It's a Lucky Ticket");
        } else {
            System.out.println("It's an unlucky ticket");

        }


    }
}
