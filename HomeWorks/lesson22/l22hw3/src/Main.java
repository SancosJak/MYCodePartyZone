import java.util.Scanner;
/*
(switch case, бесконечный цикл, методы) Составьте программу для перевода мер длины:
саженей в метры (1 сажень равна 2,1366 м)
дюймов в сантиметры (1 дюйм равен 2,5 см)
футов в метры (1 фут равен 0,3048 м)
аршинов в метры (1 аршин равен 0,7112 м)
дюймов в миллиметры (1 дюйм равен 25,3995 мм)
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        while (true) {
            System.out.println("Select the type of transfer:");
            System.out.println("1. Fathoms -> Meters"); //Сажени -> Метры
            System.out.println("2. Inches -> Centimeters"); //Дюймы -> Сантиметры
            System.out.println("3. Feet -> Meters"); //Футы -> Метры
            System.out.println("4. Arshins -> Meters"); //Аршины -> Метры
            System.out.println("5. Inches -> Millimeters"); //Дюймы -> Миллиметры
            System.out.println("0. Exit");

            choice = scanner.nextInt();

            if (choice == 0) {
                break;
            }

            double value;
            switch (choice) {
                case 1:
                    System.out.println("Enter the value in fathoms:");
                    value = scanner.nextDouble();
                    double meters = value * 2.1366;
                    System.out.println(value + " fathom(s) = " + meters + " meter(s)");
                    break;
                case 2:
                    System.out.println("Enter the value in inches:");
                    value = scanner.nextDouble();
                    double centimeters = value * 2.5;
                    System.out.println(value + " inch(s) = " + centimeters + " centimeter(s)");
                    break;
                case 3:
                    System.out.println("Enter the value in feet:");
                    value = scanner.nextDouble();
                    double feetToMeters = value * 0.3048;
                    System.out.println(value + " ft(s) = " + feetToMeters + " meter(s)");
                    break;
                case 4:
                    System.out.println("Enter the value in yards:");
                    value = scanner.nextDouble();
                    double arshinsToMeters = value * 0.7112;
                    System.out.println(value + " arshin(s) = " + arshinsToMeters + " meter(s)");
                    break;
                case 5:
                    System.out.println("Enter the value in inches:");
                    value = scanner.nextDouble();
                    double millimeters = value * 25.3995;
                    System.out.println(value + " inch(s) = " + millimeters + " millimeter(s)");
                    break;
                default:
                    System.out.println("Wrong choice. Try again.");
                    break;
            }
            System.out.println();
        }
        System.out.println("The program is over.");
    }
}
