import java.util.Scanner;

public class  Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Enter the text");
        String text = in.nextLine();

        System.out.println("Enter the number of repetitions");
        int n = in.nextInt();

        while (n >= 1) {
            System.out.println(text);
            n--;
        }

    }
}
