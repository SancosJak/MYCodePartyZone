import java.util.Scanner;
/*
напишите программу для продажи 4-х видов кофе: ESPRESSO, AMERICANO, CAPUCCINO, LATTE
Предложите пользователю кофе на выбор, по результатам выбора сообщите стоимость напитка
 */

public class CoffeeShop {

    enum CoffeeType {
        ESPRESSO(2.5),
        AMERICANO(3.0),
        CAPPUCCINO(3.5),
        LATTE(4.0);

        private final double price;

        CoffeeType(double price) {
            this.price = price;
        }

        public double getPrice() {
            return price;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Coffee Shop!");
        System.out.println("Here are the available coffee options:");

        for (CoffeeType coffeeType : CoffeeType.values()) {
            System.out.println(coffeeType.ordinal() + 1 + ". " + coffeeType.name());
        }

        try {
            System.out.print("Please select a coffee type (1-4): ");
            int choice = Integer.parseInt(scanner.nextLine());

            if (choice >= 1 && choice <= CoffeeType.values().length) {
                CoffeeType selectedCoffee = CoffeeType.values()[choice - 1];
                System.out.println("You've selected: " + selectedCoffee.name());
                System.out.println("The price is: $" + selectedCoffee.getPrice());
            } else {
                System.out.println("Invalid choice. Please select a valid coffee type.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a number.");
        } finally {
            scanner.close();
        }
    }
}