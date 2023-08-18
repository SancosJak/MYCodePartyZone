import java.util.Scanner;

public enum MenuOption {
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
    static final String[] todoList = new String[100];
    static int taskCount = 0;
    static final Scanner scanner = new Scanner(System.in);

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

}
