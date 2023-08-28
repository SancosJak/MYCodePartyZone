import java.util.Scanner;
/*
Используя ENUM для организации меню реализовать приложение "Список дел"
TODO LIST - список дел
Меню:
добавить запись
посмотреть записи
удалить запись (по номеру)
выйти
 */

public class ToDoListAppl {

    enum MenuOption {
        ADD(1),
        VIEW(2),
        DELETE(3),
        EXIT(4);

        private final int value;

        MenuOption(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    static String[] todoList = new String[100];
    static int taskCount = 0;
    static Scanner scanner = new Scanner(System.in);

    public static void addTask() {
        if (taskCount < todoList.length) {
            System.out.print("Enter a new task: ");
            String task = scanner.nextLine();
            todoList[taskCount] = task;
            taskCount++;
            System.out.println("Task added.");
        } else {
            System.out.println("The task list is complete.");
        }
    }

    public static void viewTasks() {
        if (taskCount == 0) {
            System.out.println("The task list is empty.");
        } else {
            System.out.println("Task list:");
            for (int i = 0; i < taskCount; i++) {
                System.out.println((i + 1) + ". " + todoList[i]);
            }
        }
    }

    public static void deleteTask() {
        viewTasks();
        try {
            System.out.print("Enter the number of the task you want to delete: ");
            int taskNumber = Integer.parseInt(scanner.nextLine());

            if (taskNumber >= 1 && taskNumber <= taskCount) {
                String deletedTask = todoList[taskNumber - 1];

                for (int i = taskNumber - 1; i < taskCount - 1; i++) {
                    todoList[i] = todoList[i + 1];
                }
                todoList[taskCount - 1] = null;
                taskCount--;

                System.out.println("Task '" + deletedTask + "' deleted.");
            } else {
                System.out.println("Invalid task number.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Enter the correct task number.");
        }
    }

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
                //MenuOption menuOption = MenuOption.values()[choice - 1];
                MenuOption menuOption = null;
                for (MenuOption option : MenuOption.values()) {
                    if (option.getValue() == choice) {
                        menuOption = option;
                        break;
                    }
                }

                switch (menuOption) {
                    case ADD:
                        addTask();
                        break;
                    case VIEW:
                        viewTasks();
                        break;
                    case DELETE:
                        deleteTask();
                        break;
                    case EXIT:
                        System.out.println("Sign out of the app.");
                        scanner.close();
                        return;
                    default:
                        System.out.println("This option is not valid. Please choose from the following.");
                        break;
                }
            } catch (NumberFormatException | IndexOutOfBoundsException e) {
                System.out.println("Enter the correct option number from the menu.");
            }
        }
    }
}