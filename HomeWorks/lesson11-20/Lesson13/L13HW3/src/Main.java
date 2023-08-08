import java.util.Scanner;
/*
Пользователь вводит строку. Распечатайте эту строку в обратном порядке.
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter the text: ");
        String text = in.nextLine();

        StringBuilder t = new StringBuilder(text);
        String reverseText= t.reverse().toString();

        System.out.println("Text in reverse order: " + reverseText);
    }
}
