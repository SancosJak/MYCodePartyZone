import java.util.Scanner;

public enum MenuOption1 {
    ADD(1) {
        @Override
        public String performAction() {
            return addTask();
        }
    },
    VIEW(2) {
        @Override
        public String performAction() {
            return viewTasks();
        }
    },
    DELETE(3) {
        @Override
        public String performAction() {
            return deleteTask();
        }
    },
    EXIT(4) {
        @Override
        public String performAction() {
            scanner.close();
            return "Sign out of the app.";
        }
    };

    private final int value;

    MenuOption1(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public abstract String performAction();

    static final String[] todoList = new String[100];
    static int taskCount = 0;
    static final Scanner scanner = new Scanner(System.in);

    public static String addTask() {
        if (taskCount < todoList.length) {
            System.out.print("Enter a new task: ");
            String task = scanner.nextLine();
            todoList[taskCount] = task;
            taskCount++;
            return "Task added.";
        } else {
            return "The task list is complete.";
        }
    }

    public static String viewTasks() {
        if (taskCount == 0) {
            return "The task list is empty.";
        } else {
            StringBuilder tasks = new StringBuilder("Task list:\n");
            for (int i = 0; i < taskCount; i++) {
                tasks.append((i + 1)).append(". ").append(todoList[i]).append("\n");
            }
            return tasks.toString();
        }
    }

    public static String deleteTask() {
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

                return "Task '" + deletedTask + "' deleted.";
            } else {
                return "Invalid task number.";
            }
        } catch (NumberFormatException e) {
            return "Enter the correct task number.";
        }
    }
}
