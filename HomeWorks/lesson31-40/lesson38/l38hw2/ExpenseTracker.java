import java.util.Scanner;

public class ExpenseTracker {
    enum ExpenseOption {
        ADD_EXPENSE(1),
        VIEW_EXPENSES(2),
        DELETE_EXPENSE(3),
        EXIT(4);

        private final int value;

        ExpenseOption(int value) {
            this.value = value;
        }

        public int getValue(){
            return value;
        }
    }

    static final int MAX_EXPENSES = 50;
    static String[] expenses = new String[MAX_EXPENSES];
    static double[] amounts = new double[MAX_EXPENSES];
    static int expenseCount = 0;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while(true) {
            System.out.println("\nEXPENSE TRACKER");
            System.out.println("Menu:");
            for (ExpenseOption option : ExpenseOption.values()) {
                System.out.println(option.getValue() + ". " + option.name().replace("_", " ").toLowerCase());
            }

            System.out.println("Select an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addExpense();
                    break;
                case 2:
                    viewExpenses();
                    break;
                case 3:
                    deleteExpense();
                    break;
                case 4:
                    System.out.println("Program terminated.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please select an option from the menu.");
            }
        }
    }

    static void addExpense() {
        if (expenseCount < MAX_EXPENSES) {
            System.out.println("Enter the expense description: ");
            String description = scanner.nextLine();

            System.out.println("Enter the expense amount: ");
            double amount = scanner.nextDouble();
            scanner.nextLine();

            expenses[expenseCount] = description;
            amounts[expenseCount] = amount;
            expenseCount++;

            System.out.println("Expense added!");
        } else {
            System.out.println("Maximum expense limit reached.");
        }
    }

    static void viewExpenses() {
        if (expenseCount == 0) {
            System.out.println("Expense list is empty.");
        } else {
            System.out.println("List of expenses:");
            for (int i = 0; i < expenseCount; i++) {
                System.out.println((i + 1) + ". " + expenses[i] + " - $" + amounts[i]);
            }
        }
    }

    static void deleteExpense() {
        viewExpenses();
        System.out.println("Enter the expense number to delete: ");
        int expenseNumber = scanner.nextInt();

        if (expenseNumber >= 1 && expenseNumber <= expenseCount) {
            String deletedExpense = expenses[expenseNumber - 1];
            for (int i = expenseNumber - 1; i < expenseCount - 1 ; i++) {
                expenses[i] = expenses[i + 1];
                amounts[i] = amounts[i + 1];
            }
            expenseCount--;
            System.out.println("Expense '" + deletedExpense + "' deleted.");
        } else {
            System.out.println("Invalid expense number.");
        }
    }
}
