package CinemaSysManagment.impl;

import CinemaSysManagment.model.CinemaHall;
import CinemaSysManagment.model.CinemaHall.HallType;

import java.util.List;
import java.util.Scanner;

public class HallManagement {
    private List<CinemaHall> halls;
    public static final String RED_COLOR = "\u001B[31m";
    public static final String RESET_COLOR = "\u001B[0m";

    public HallManagement(List<CinemaHall> halls) {
        this.halls = halls;
    }
    public List<CinemaHall> getHalls() {
        return halls;
    }

    public void run() {
        int adminHallChoice = 0;

        while (adminHallChoice != 4) {
            System.out.println("Управление Залами:");
            System.out.println("1. Добавить зал");
            System.out.println("2. Удалить зал");
            System.out.println("3. Просмотреть все залы");
            System.out.println("4. Вернуться в главное меню");

            Scanner scanner = new Scanner(System.in);

            try {
                adminHallChoice = scanner.nextInt();
                scanner.nextLine();
            } catch (java.util.InputMismatchException e) {
                System.out.println(RED_COLOR + "Ошибка: введите число от 1 до 4." + RESET_COLOR);
                scanner.nextLine();
                continue;
            }


            switch (adminHallChoice) {
                case 1:
                    try {
                        addHall();
                    } catch (Exception e) {
                        System.out.println(RED_COLOR + "Ошибка при добавлении зала: " + e.getMessage() + RESET_COLOR);
                    }
                    break;
                case 2:
                    try {
                        deleteHall();
                    } catch (Exception e) {
                        System.out.println(RED_COLOR + "Ошибка при удалении зала: " + e.getMessage() + RESET_COLOR);
                    }
                    break;
                case 3:
                    viewAllHalls();
                    break;
                case 4:
                    return;
                default:
                    System.out.println(RED_COLOR + "Некорректный выбор. Пожалуйста, введите число от 1 до 4." + RESET_COLOR);
            }
        }
    }

    public void addHall() {
        Scanner scanner = new Scanner(System.in);
        boolean validInput = false;

        do {
            try {
                System.out.println("Введите номер зала:");
                int hallNumber = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Введите вместимость зала:");
                int capacity = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Выберите тип зала (1. 2D, 2. 3D, 3. IMAX):");
                int hallTypeChoice = scanner.nextInt();
                scanner.nextLine();

                HallType hallType = HallType._2D;

                switch (hallTypeChoice) {
                    case 1:
                        hallType = HallType._2D;
                        break;
                    case 2:
                        hallType = HallType._3D;
                        break;
                    case 3:
                        hallType = HallType.IMAX;
                        break;
                }

                if (hallNumber > 0 && capacity > 0) {
                    validInput = true;
                    CinemaHall newHall = new CinemaHall(hallNumber, capacity, hallType);
                    halls.add(newHall);
                    System.out.println("Зал успешно добавлен.");
                } else {
                    System.out.println(RED_COLOR + "Некорректные данные зала. Пожалуйста, повторите ввод." + RESET_COLOR);
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println(RED_COLOR + "Ошибка: некорректный ввод. Пожалуйста, повторите ввод." + RESET_COLOR);
                scanner.nextLine();
            }
        } while (!validInput);
    }

    public void deleteHall() {
        Scanner scanner = new Scanner(System.in);
        boolean validInput = false;

        do {
            System.out.println("Введите номер зала для удаления:");
            int hallNumber = scanner.nextInt();

            if (hallNumber > 0) {
                validInput = true;

                boolean removed = false;
                for (CinemaHall hall : halls) {
                    if (hall.getHallNumber() == hallNumber) {
                        halls.remove(hall);
                        System.out.println("Зал №" + hallNumber + " успешно удален.");
                        removed = true;
                        break;
                    }
                }

                if (!removed) {
                    System.out.println("Зал с номером " + hallNumber + " не найден.");
                }
            } else {
                System.out.println("Некорректный номер зала. Пожалуйста, повторите ввод.");
            }
        } while (!validInput);
    }

    public void viewAllHalls() {
        if (halls.isEmpty()) {
            System.out.println("Список залов пуст.");
        } else {
            System.out.println("Список всех залов:");
            for (CinemaHall hall : halls) {
                System.out.println("Зал №" + hall.getHallNumber());
                System.out.println("Вместимость: " + hall.getCapacity() + " человек");
                System.out.println("Тип: " + hall.getHallType());
                System.out.println();
            }
        }
    }
}

