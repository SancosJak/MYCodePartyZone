import java.util.Scanner;

public class TryCatchAppl {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {

            System.out.println("Enter first number: ");
            int a = scanner.nextInt();

            System.out.println("Enter second number: ");
            int b = scanner.nextInt();

            int division = a / b;
            System.out.println("Division " + a + " / " + b + " = " + division);

        } catch (Exception e) {
            System.out.println(e.getMessage() + " , " + e.getCause());
        }
        System.out.println("----------------------------------------------");
        try {
            int arr[] = {5, -7, 17, 29, 30 };
            for (int i = 0; i < arr.length; i++) {
                System.out.println(arr[i]);
            }
            System.out.println(arr[7]);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("----------------------------------------------");

        try {
            System.out.println("Input number: ");
            int inNum = scanner.nextInt();
            System.out.println("your input is " + inNum);
        } catch (Exception e) {
            System.out.println(e.toString());
        }


    }
}
