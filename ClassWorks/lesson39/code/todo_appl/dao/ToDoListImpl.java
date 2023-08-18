package todo_appl.dao;

import todo_appl.model.Task;

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
}
