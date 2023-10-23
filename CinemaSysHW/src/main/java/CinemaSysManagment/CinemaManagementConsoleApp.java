package CinemaSysManagment;

import CinemaSysManagment.dao.ICustomer;
import CinemaSysManagment.dao.IEmployee;
import CinemaSysManagment.model.Customer;
import CinemaSysManagment.model.Employee;
import CinemaSysManagment.role.AdminMenu;
import CinemaSysManagment.role.ClientMenu;
import CinemaSysManagment.role.EmployeeMenu;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CinemaManagementConsoleApp {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int userTypeChoice;

        do {
            System.out.println("Вход в систему управления кинотеатром:");
            System.out.println("Выберите тип пользователя:");
            System.out.println("1. Администратор");
            System.out.println("2. Сотрудник");
            System.out.println("3. Клиент");

            try {
                userTypeChoice = scanner.nextInt();

                if (userTypeChoice < 1 || userTypeChoice > 3) {
                    System.out.println(ANSI_RED + "Некорректный выбор. Пожалуйста, введите 1, 2 или 3." + ANSI_RESET);
                }
            } catch (InputMismatchException e) {
                System.out.println(ANSI_RED + "Некорректный выбор. Пожалуйста, введите 1, 2 или 3." + ANSI_RESET);
                scanner.nextLine();
                userTypeChoice = 0;
            }
        } while (userTypeChoice < 1 || userTypeChoice > 3);

        switch (userTypeChoice) {
            case 1 -> {
                AdminMenu adminMenu = new AdminMenu();
                if (adminMenu.authenticate()) {
                    adminMenu.run();
                } else {
                    System.out.println(ANSI_RED + "Неверное имя пользователя или пароль." + ANSI_RESET);
                }
            }
            case 2 -> {
                IEmployee employee = new Employee("employeeName", "employeePassword", "employeePosition", "employeeFirstName", "employeeLastName", "employeeContactInfo");
                EmployeeMenu employeeMenu = new EmployeeMenu(employee);
                if (employeeMenu.authenticate()) {
                    employeeMenu.run();
                } else {
                    System.out.println(ANSI_RED + "Неверное имя пользователя или пароль." + ANSI_RESET);
                }
            }
            case 3 -> {
                ICustomer customer = new Customer("clientName", "clientPassword");
                ClientMenu clientMenu = new ClientMenu(customer);
                if (clientMenu.authenticate()) {
                    clientMenu.run();
                } else {
                    System.out.println(ANSI_RED + "Неверное имя пользователя или пароль." + ANSI_RESET);
                }
            }
        }
    }
}
