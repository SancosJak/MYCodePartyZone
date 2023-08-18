package todo_appl;

import todo_appl.dao.ToDoListImpl;
import todo_appl.model.Menu;
import todo_appl.model.Task;

import java.util.Scanner;

public class ToDoAppl {
    public static Menu getMenuByItem(int item) {
        for (Menu menu : Menu.values()) {
            if (menu.getMenuItem() == item) {
                return menu;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        // greeting
        System.out.println("Welcome to ToDo Application!");

        int capacity = 100;
        ToDoListImpl toDoList = new ToDoListImpl(capacity);

        Scanner scanner = new Scanner(System.in);

        boolean continueExecution = true;

        while (continueExecution) {
            // print menu
            Menu.printMenu();

            // ask choice
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            Menu selectedMenu = getMenuByItem(choice);

            if (selectedMenu != null) {
                switch (selectedMenu) {
                    case ADD:
                        // Add task
                        scanner.nextLine();
                        System.out.print("Enter task description: ");
                        String userVoid = scanner.nextLine();
                        Task newTask = new Task(userVoid);
                        if (toDoList.addTask(newTask)) {
                            System.out.println("Task added successfully!");
                        } else {
                            System.out.println("Failed to add task. ToDoList is full.");
                        }
                        break;

                    case REMOVE:
                        // Remove task
                        toDoList.printTasks();
                        System.out.print("Enter task id to remove: ");
                        int taskIdToRemove = scanner.nextInt();
                        Task removedTask = toDoList.removeTask(taskIdToRemove);
                        if (removedTask != null) {
                            System.out.println("Task removed: " + removedTask);
                        } else {
                            System.out.println("Task not found.");
                        }
                        break;

                    case FIND:
                        if (toDoList.quantity() > 0) {
                            // Find task
                            System.out.print("Enter task id to find: ");
                            int taskIdToFind = scanner.nextInt();
                            Task foundTask = toDoList.findTask(taskIdToFind);
                            if (foundTask != null) {
                                System.out.println("Task found: " + foundTask);
                            } else {
                                System.out.println("Task not found.");
                            }
                        } else {
                            System.out.println("No tasks to search. Please add tasks first.");
                        }
                        break;

                    case LIST:
                        if (toDoList.quantity() > 0) {
                            // Print tasks
                            System.out.println("Tasks:");
                            toDoList.printTasks();
                        } else {
                            System.out.println("No tasks available.");
                        }
                        break;

                    case EXIT:
                        // Exit
                        continueExecution = false;
                        break;
                }
            } else {
                System.out.println("Invalid choice. Please enter a valid option.");
            }

            // ask Continue?
            System.out.print("Do you want to continue (y/n)? ");
            String continueChoice = scanner.next();
            if (continueChoice.equalsIgnoreCase("n")) {
                continueExecution = false;
            }
        }

        System.out.println("Thank you for using ToDo Application!");
        scanner.close();
    }

}
