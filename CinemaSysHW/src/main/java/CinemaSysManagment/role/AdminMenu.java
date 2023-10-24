package CinemaSysManagment.role;

import CinemaSysManagment.dao.IEmployee;
import CinemaSysManagment.dao.IReportGenerator;
import CinemaSysManagment.impl.*;
import CinemaSysManagment.model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AdminMenu {
    private static final String ADMIN_USERNAME = "admin";
    private static final String ADMIN_PASSWORD = "admin";

    public static final String RED_COLOR = "\u001B[31m";
    public static final String RESET_COLOR = "\u001B[0m";

    public boolean authenticate() {
        boolean authenticated = false;
        Scanner scanner = new Scanner(System.in);

        while (!authenticated) {
            System.out.println("Введите имя пользователя: ");
            String adminUsername = scanner.next();
            System.out.println("Введите пароль: ");
            String adminPassword = scanner.next();

            if (ADMIN_USERNAME.equals(adminUsername) && ADMIN_PASSWORD.equals(adminPassword)) {
                authenticated = true;
                Logger.log("Администратор " + adminUsername + " вошел в систему.");
                System.out.println("Вход выполнен успешно.");
            } else {
                Logger.log("Попытка неудачного входа администратора " + adminUsername);
                System.out.println(RED_COLOR + "Неверное имя пользователя или пароль. Пожалуйста, повторите ввод." + RESET_COLOR);
            }
        }
        return true;
    }

    public void run() {
        boolean exitRequested = false;
        do {
            System.out.println("Добро пожаловать, Администратор!");
            System.out.println("Выберите действие:");
            System.out.println("1. Управление фильмами");
            System.out.println("2. Управление сеансами");
            System.out.println("3. Управление продуктами");
            System.out.println("4. Генерация отчетов");
            System.out.println("5. Управление залами");
            System.out.println("6. Управление персоналом");
            System.out.println("7. Управление данными");
            System.out.println("8. Выход из программы");

            Scanner scanner = new Scanner(System.in);
            int adminChoice;

            try {
                adminChoice = scanner.nextInt();
            } catch (java.util.InputMismatchException e) {
                adminChoice = 0;
                scanner.nextLine();
            }

            switch (adminChoice) {
                case 1:
                    List<Film> films = new ArrayList<>();
                    FilmManagement filmManagement = new FilmManagement(films);
                    filmManagement.run();
                    break;
                case 2:
                    List<Session> sessions = new ArrayList<>();
                    SessionManagement sessionManagement = new SessionManagement(sessions);
                    sessionManagement.run();
                    break;
                case 3:
                    List<Product> products = new ArrayList<>();
                    ProductManagement productManagement = new ProductManagement(products);
                    productManagement.run();
                    break;
                case 4:
                    IReportGenerator reports = new ReportGenerator();
                    ReportManagement reportGeneration = new ReportManagement(reports);
                    reportGeneration.run();
                    break;
                case 5:
                    List<CinemaHall> halls = new ArrayList<>();
                    HallManagement hallManagement = new HallManagement(halls);
                    hallManagement.run();
                    break;
                case 6:
                    List<IEmployee> employees = new ArrayList<>();
                    EmployeeManagement employeeManagement = new EmployeeManagement(employees);
                    employeeManagement.run();
                    break;
                case 7:
                    filmManagement = new FilmManagement(new ArrayList<>());
                    sessionManagement = new SessionManagement(new ArrayList<>());
                    productManagement = new ProductManagement(new ArrayList<>());
                    DataManagement dataManagement = new DataManagement(filmManagement, sessionManagement, productManagement);
                    dataManagement.run();
                    break;
                case 8:
                    exitRequested = true;
                    Logger.log("Администратор вышел из системы.");
                    break;
                default:
                    System.out.println(RED_COLOR + "Некорректный выбор. Пожалуйста, введите число от 1 до 5." + RESET_COLOR);
            }
        } while (!exitRequested);
    }
}
