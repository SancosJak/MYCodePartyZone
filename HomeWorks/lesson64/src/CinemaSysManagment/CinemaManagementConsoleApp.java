package CinemaSysManagment;

import CinemaSysManagment.model.Film;
import CinemaSysManagment.model.Product;
import CinemaSysManagment.model.Session;
import CinemaSysManagment.role.AdminMenu;
import CinemaSysManagment.role.ClientMenu;
import CinemaSysManagment.role.EmployeeMenu;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class CinemaManagementConsoleApp {
    private static List<Film> films = new ArrayList<>();
    private static List<Session> sessions = new ArrayList<>();
    private static List<Product> products = new ArrayList<>();

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
            case 1:
                AdminMenu adminMenu = new AdminMenu();
                if (adminMenu.authenticate()) {
                    adminMenu.run();
                } else {
                    System.out.println(ANSI_RED + "Неверное имя пользователя или пароль." + ANSI_RESET);
                }
                break;
            case 2:
                EmployeeMenu employeeMenu = new EmployeeMenu();
                // Аналогично для сотрудника
                break;
            case 3:
                ClientMenu clientMenu = new ClientMenu();
                // Аналогично для клиента
                break;
        }
    }
}
