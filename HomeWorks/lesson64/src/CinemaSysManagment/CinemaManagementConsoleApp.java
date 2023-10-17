package CinemaSysManagment;

import CinemaSysManagment.model.Film;
import CinemaSysManagment.model.Product;
import CinemaSysManagment.model.Session;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CinemaManagementConsoleApp {
    private static List<Film> films = new ArrayList<>();
    private static List<Session> sessions = new ArrayList<>();
    private static List<Product> products = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Вход в систему управления кинотеатром:");
        System.out.println("Выберите тип пользователя:");
        System.out.println("1. Администратор");
        System.out.println("2. Сотрудник");
        System.out.println("3. Клиент");

        int userTypeChoice = scanner.nextInt();

        switch (userTypeChoice) {
            case 1:
                System.out.println("Введите имя пользователя: ");
                String adminUsername = scanner.next();
                System.out.println("Введите пароль: ");
                String adminPassword = scanner.next();

                if (adminUsername.equals("admin") && adminPassword.equals("admin")) {
                    adminMenu();
                } else {
                    System.out.println("Неверное имя пользователя или пароль.");
                }
                break;
            case 2:
                System.out.println("Введите имя пользователя: ");
                String employeeUsername = scanner.next();
                System.out.println("Введите пароль: ");
                String employeePassword = scanner.next();

                if (employeeUsername.equals("employee") && employeePassword.equals("employee")) {
                    employeeMenu();
                } else {
                    System.out.println("Неверное имя пользователя или пароль.");
                }
                break;
            case 3:
                System.out.println("Введите имя пользователя: ");
                String clientUsername = scanner.next();
                System.out.println("Введите пароль: ");
                String clientPassword = scanner.next();

                if (clientUsername.equals("client") && clientPassword.equals("client")) {
                    clientMenu();
                } else {
                    System.out.println("Неверное имя пользователя или пароль.");
                }
                break;
            default:
                System.out.println("Некорректный выбор. Пожалуйста, введите 1, 2 или 3.");
                break;
        }
    }

    private static void adminMenu() {
        while (true) {
            System.out.println("Добро пожаловать, Администратор!");
            System.out.println("Выберите действие:");
            System.out.println("1. Управление фильмами");
            System.out.println("2. Управление сеансами");
            System.out.println("3. Управление продуктами");
            System.out.println("4. Генерация отчетов");
            System.out.println("5. Вернуться в главное меню");

            Scanner scanner = new Scanner(System.in);
            int adminChoice = scanner.nextInt();

            switch (adminChoice) {
                case 1:
                    // Логика добавления фильма
                    addFilm();
                    break;
                case 2:
                    // Логика удаления фильма
                    deleteFilm();
                    break;
                case 3:
                    // Логика просмотра всех фильмов
                    viewAllFilms();
                    break;
                case 4:
                    // Вернуться в главное меню
                    return;
                default:
                    System.out.println("Некорректный выбор. Пожалуйста, введите число от 1 до 4.");
            }
        }
    }
    private static void adminFilmMenu() {
        while (true) {
            System.out.println("Управление Фильмами:");
            System.out.println("1. Добавить фильм");
            System.out.println("2. Удалить фильм");
            System.out.println("3. Просмотреть все фильмы");
            System.out.println("4. Вернуться в главное меню");

            Scanner scanner = new Scanner(System.in);
            int adminFilmChoice = scanner.nextInt();

            switch (adminFilmChoice) {
                case 1:
                    // Логика добавления фильма
                    // addFilm();
                    break;
                case 2:
                    // Логика удаления фильма
                    // deleteFilm();
                    break;
                case 3:
                    // Логика просмотра всех фильмов
                    //viewAllFilms();
                    break;
                case 4:
                    // Вернуться в меню администратора
                    return;
                default:
                    System.out.println("Некорректный выбор. Пожалуйста, введите число от 1 до 4.");
            }
        }
    }
    private static void adminSessionMenu() {
        while (true) {
            System.out.println("Управление Сеансами:");
            System.out.println("1. Добавить сеанс");
            System.out.println("2. Удалить сеанс");
            System.out.println("3. Просмотреть все сеансы");
            System.out.println("4. Вернуться в меню администратора");

            Scanner scanner = new Scanner(System.in);
            int adminSessionChoice = scanner.nextInt();

            switch (adminSessionChoice) {
                case 1:
                    // Логика добавления сеанса
                    //addSession();
                    break;
                case 2:
                    // Логика удаления сеанса
                    //deleteSession();
                    break;
                case 3:
                    // Логика просмотра всех сеансов
                    //viewAllSessions();
                    break;
                case 4:
                    // Вернуться в меню администратора
                    return;
                default:
                    System.out.println("Некорректный выбор. Пожалуйста, введите число от 1 до 4.");
            }
        }
    }
    private static void adminProductMenu() {
        while (true) {
            System.out.println("Управление Продуктами:");
            System.out.println("1. Добавить продукт");
            System.out.println("2. Удалить продукт");
            System.out.println("3. Просмотреть все продукты");
            System.out.println("4. Вернуться в меню администратора");

            Scanner scanner = new Scanner(System.in);
            int adminProductChoice = scanner.nextInt();

            switch (adminProductChoice) {
                case 1:
                    // Логика добавления продукта
                   // addProduct();
                    break;
                case 2:
                    // Логика удаления продукта
                    //deleteProduct();
                    break;
                case 3:
                    // Логика просмотра всех продуктов
                   // viewAllProducts();
                    break;
                case 4:
                    // Вернуться в меню администратора
                    return;
                default:
                    System.out.println("Некорректный выбор. Пожалуйста, введите число от 1 до 4.");
            }
        }
    }
    private static void employeeMenu() {
        while (true) {
            System.out.println("Добро пожаловать, Сотрудник!");
            System.out.println("Выберите действие:");
            System.out.println("1. Просмотр информации о фильмах");
            System.out.println("2. Продажа билетов");
            System.out.println("3. Вернуться в главное меню");

            Scanner scanner = new Scanner(System.in);
            int employeeChoice = scanner.nextInt();

            switch (employeeChoice) {
                case 1:
                    // Логика просмотра информации о фильмах
                    viewAllFilms();
                    break;
                case 2:
                    // Логика продажи билетов
                    //sellTickets();
                    break;
                case 3:
                    // Вернуться в главное меню
                    return;
                default:
                    System.out.println("Некорректный выбор. Пожалуйста, введите число от 1 до 3.");
            }
        }
    }

    private static void clientMenu() {
        while (true) {
            System.out.println("Добро пожаловать, Клиент!");
            System.out.println("Выберите действие:");
            System.out.println("1. Просмотр информации о фильмах");
            System.out.println("2. Покупка билетов");
            System.out.println("3. Вернуться в главное меню");

            Scanner scanner = new Scanner(System.in);
            int clientChoice = scanner.nextInt();

            switch (clientChoice) {
                case 1:
                    // Логика просмотра информации о фильмах
                    viewAllFilms();
                    break;
                case 2:
                    // Логика покупки билетов
                    // buyTickets();
                    break;
                case 3:
                    // Вернуться в главное меню
                    return;
                default:
                    System.out.println("Некорректный выбор. Пожалуйста, введите число от 1 до 3.");
            }
        }
    }

    private static void addFilm() {
        // Логика добавления фильма (добавление объекта класса Film в список films)
    }

    private static void deleteFilm() {
        // Логика удаления фильма (удаление объекта класса Film из списка films)
    }

    private static void viewAllFilms() {
        // Логика просмотра всех фильмов (перебор и вывод информации о фильмах из
    }
}