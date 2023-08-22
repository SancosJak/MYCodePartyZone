package todo_appl.dao;

import todo_appl.model.Task;

import java.io.*;
import java.util.Scanner;

public class ToDoListImpl implements ToDoList {

    private Task[] tasks;
    private int quantity;

    private int capacity;

    public ToDoListImpl(int capacity) {
        this.tasks = new Task[capacity];
        this.quantity = 0;
    }

    @Override
    public boolean addTask(Task task) {
        if (task != null && quantity < tasks.length) {
            tasks[quantity] = task;
            quantity++;
            return true;
        }
        return false;
    }

    @Override
    public Task removeTask(int id) {
        for (int i = 0; i < quantity; i++) {
            if (tasks[i].getId() == id) {
                Task removedTask = tasks[i];
                for (int j = i; j < quantity - 1; j++) {
                    tasks[j] = tasks[j + 1];
                }
                tasks[quantity - 1] = null;
                quantity--;
                return removedTask;
            }
        }
        return null;
    }

    @Override
    public Task findTask(int id) {
        if (quantity > 0) {
            for (int i = 0; i < quantity; i++) {
                if (tasks[i].getId() == id) {
                    return tasks[i];
                }
            }
        }
        return null;
    }

    @Override
    public void printTasks() {
        for (int i = 0; i < quantity; i++) {
            System.out.println(tasks[i]);
        }
    }

    @Override
    public int quantity() {
        return quantity;
    }

    public Task[] getAllTasks() {
        Task[] allTasks = new Task[quantity];
        System.arraycopy(tasks, 0, allTasks, 0, quantity);
        return allTasks;
    }

    public static void saveToDoListToFile(ToDoListImpl toDoList) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a file name to save the tasks: ");
        String fileName = scanner.nextLine();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            Task[] tasks = toDoList.getAllTasks();
            for (Task task : tasks) {
                if (task != null) {
                    writer.write(task.toString());
                    writer.newLine();
                }
            }
            System.out.println("Tasks are saved to a file " + fileName);
        } catch (IOException e) {
            System.out.println("Error saving tasks: " + e.getMessage());
        }
    }
    public static void loadToDoListFromFile(ToDoListImpl toDoList) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a file name to load tasks from: ");
        String fileName = scanner.nextLine();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Task task = Task.parseTaskFromString(line);
                if (task != null) {
                    toDoList.addTask(task);
                }
            }
            System.out.println("Tasks are loaded from a file " + fileName);
        } catch (IOException e) {
            System.out.println("Error loading tasks: " + e.getMessage());
        }
    }

    public static Task parseTaskFromString(String taskString) {
        return new Task(taskString);
    }

}
