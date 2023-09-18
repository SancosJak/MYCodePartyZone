import java.util.Scanner;

public class LinearEquationSolver {
    public static double solveLinearEquation(double a, double b) throws ArithmeticException {
        if (a == 0 && b != 0) {
            throw new ArithmeticException("Division by zero");
        }
        return b / a;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a: ");
        int a = scanner.nextInt();

        System.out.print("Enter b: ");
        int b = scanner.nextInt();

        try {
            double x = solveLinearEquation(a, b);
            System.out.println("Solution " + a + " * x = " + b + " : x = " + x);
        } catch (ArithmeticException e) {
            System.out.println("The equation has no solution: " + e.getMessage());
        }
    }
}
