import java.util.Scanner;

public class ToDoAppl {
        static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Add task");
            System.out.println("2. View tasks");
            System.out.println("3. Delete task (by number)");
            System.out.println("4. Exit");

            try {
                System.out.print("Select an option from the menu: ");
                int choice = Integer.parseInt(scanner.nextLine());

                MenuOption menuOption = null;
                for (MenuOption option : MenuOption.values()) {
                    if (option.getValue() == choice) {
                        menuOption = option;
                        break;
                    }
                }

                if (menuOption != null) {
                    switch (menuOption) {
                        case ADD:
                            MenuOption.addTask();
                            break;
                        case VIEW:
                            MenuOption.viewTasks();
                            break;
                        case DELETE:
                            MenuOption.deleteTask();
                            break;
                        case EXIT:
                            System.out.println("Sign out of the app.");
                            scanner.close();
                            return;
                        default:
                            System.out.println("This option is not valid. Please choose from the following.");
                            break;
                    }
                } else {
                    System.out.println("Invalid option. Please choose from the menu.");
                }
            } catch (NumberFormatException | IndexOutOfBoundsException e) {
                System.out.println("Enter the correct option number from the menu.");
            }
        }
    }

}