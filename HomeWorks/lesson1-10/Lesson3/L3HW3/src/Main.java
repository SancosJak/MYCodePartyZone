import java.util.Scanner;

public class Main{
    public static void main(String [] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите целое число из 5 цифр: ");
        String[] cifry = String.valueOf(in.nextInt()).split("");
        for (String cifra : cifry) {
            System.out.println(cifra);
        }
        System.out.println("HomeWork by Sandor Ivanyo");

    }
}