import java.util.Scanner;
public class Main {
    public static double plus (double num1, double num2) {
        return (num1 + num2);
    }

    public static double minus (double num1, double num2) {
        return (num1 - num2);
    }

    public static double multiply (double num1, double num2) {
        return (num1 * num2);
    }

    public static double division (double num1, double num2) {
        return (num1 / num2);
    }

    public static void main(String[] args) {

        Scanner reader = new Scanner(System.in);

        double result;

        System.out.print("Enter first number: ");
        double num1 = reader.nextDouble();

        System.out.print("Enter second number: ");
        double num2 = reader.nextDouble();

        System.out.print("Enter an operator (+, -, *, /): ");
        char op = reader.next().charAt(0);
        switch(op) {
            case '+': result = plus(num1,num2);
                break;
            case '-': result = minus(num1,num2);
                break;
            case '*': result = multiply(num1,num2);
                break;
            case '/': result = division(num1,num2);
                break;
            default:  System.out.println("Error! Enter correct operator");
                return;
        }
        System.out.print("The result is : ");
        System.out.printf(num1 + " " + op + " " + num2 + " = " + result);
    }
}