import java.util.Scanner;

public class ToDoAppl1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Add task");
            System.out.println("2. View tasks");
            System.out.println("3. Delete task (by number)");
            System.out.println("4. Exit");

            int choice = 0;
            try {
                System.out.print("Select an option from the menu: ");
                choice = Integer.parseInt(scanner.nextLine());
                MenuOption1 menuOption = null;
                for (MenuOption1 option : MenuOption1.values()) {
                    if (option.getValue() == choice) {
                        menuOption = option;
                        break;
                    }
                }

                if (menuOption != null) {
                    String result = menuOption.performAction();
                    System.out.println(result);
                } else {
                    System.out.println("This option is not valid. Please choose from the following.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Enter the correct option number from the menu.");
            }

            if (MenuOption1.EXIT.getValue() == choice) {
                scanner.close();
                break;
            }
        }
    }
}