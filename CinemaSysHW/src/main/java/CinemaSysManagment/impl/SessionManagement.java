package CinemaSysManagment.impl;

import CinemaSysManagment.dao.ICinemaHall;
import CinemaSysManagment.dao.IFilm;
import CinemaSysManagment.dao.ISession;
import CinemaSysManagment.model.CinemaHall;
import CinemaSysManagment.model.Film;
import CinemaSysManagment.model.Session;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SessionManagement {
    private List<Film> films = new ArrayList<>();
    private List<Session> sessions = new ArrayList<>();
    private List<CinemaHall> cinemaHalls = new ArrayList<>();
    public List<IFilm> availableFilms = getAvailableFilms();
    public List<ICinemaHall> availableCinemaHalls = getAvailableCinemaHalls();

    public static final String RED_COLOR = "\u001B[31m";
    public static final String RESET_COLOR = "\u001B[0m";

    public SessionManagement(List<Session> sessions) {
        this.sessions = sessions;
    }

    public SessionManagement(List<Session> sessions, List<Film> films, List<CinemaHall> cinemaHalls) {
        this.sessions = sessions;
        this.films = films;
        this.cinemaHalls = cinemaHalls;
    }
    public List<Session> getSessions() {
        return sessions;
    }

    public void setSessions(List<Session> sessions) {
        this.sessions = sessions;
    }
    public List<IFilm> getAvailableFilms() {
        List<IFilm> availableFilms = new ArrayList<>();

        if (films != null) {
            for (IFilm film : films) {
                if (film instanceof Film) {
                    availableFilms.add(film);
                }
            }
        }
        return availableFilms;
    }

    public List<ICinemaHall> getAvailableCinemaHalls() {
        List<ICinemaHall> availableCinemaHalls = new ArrayList<>();
        if (cinemaHalls != null) {
            availableCinemaHalls.addAll(cinemaHalls);
        }
        return availableCinemaHalls;
    }

    public void run() {
        while (true) {
            System.out.println("Управление Сеансами:");
            System.out.println("1. Добавить сеанс");
            System.out.println("2. Удалить сеанс");
            System.out.println("3. Редактировать сеанс");
            System.out.println("4. Просмотреть все сеансы");
            System.out.println("5. Вернуться в меню администратора");

            Scanner scanner = new Scanner(System.in);

            int adminSessionChoice;
            while (true) {
                System.out.print("Введите ваш выбор: ");
                if (scanner.hasNextInt()) {
                    adminSessionChoice = scanner.nextInt();
                    if (adminSessionChoice >= 1 && adminSessionChoice <= 5) {
                        break;
                    } else {
                        System.out.println(RED_COLOR + "Некорректный выбор. Пожалуйста, введите число от 1 до 5." + RESET_COLOR);
                    }
                } else {
                    System.out.println(RED_COLOR + "Некорректный ввод. Пожалуйста, введите число от 1 до 5." + RESET_COLOR);
                    scanner.next();
                }
            }

            switch (adminSessionChoice) {
                case 1:
                    try {
                        addSession(availableFilms, availableCinemaHalls);
                    } catch (Exception e) {
                        System.out.println(RED_COLOR + "Ошибка при добавлении сеанса: " + e.getMessage() + RESET_COLOR);
                    }
                    break;
                case 2:
                    try {
                        deleteSession();
                    } catch (Exception e) {
                        System.out.println(RED_COLOR + "Ошибка при удалении сеанса: " + e.getMessage() + RESET_COLOR);
                    }
                    break;
                case 3:
                    try {
                        editSession();
                    } catch (Exception e) {
                        System.out.println(RED_COLOR + "Ошибка при редактировании сеанса: " + e.getMessage() + RESET_COLOR);
                    }
                    break;
                case 4:
                    viewAllSessions();
                    break;
                case 5:
                    return;
                default:
                    System.out.println(RED_COLOR + "Некорректный выбор. Пожалуйста, введите число от 1 до 4." + RESET_COLOR);
            }
        }
    }

    public void addSession(List<IFilm> availableFilms, List<ICinemaHall> availableCinemaHalls) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Доступные фильмы:");
        int filmsPerLine = 5;
        for (int i = 0; i < films.size(); i++) {
            int j = i + 1;
            System.out.print("#" + j + " " + films.get(i).getName() + " | ");
            if ((i + 1) % filmsPerLine == 0) {
                System.out.println();
            }
        }
        System.out.println();

        System.out.print("Введите номер выбранного фильма: ");
        int filmChoice = scanner.nextInt();

        if (filmChoice < 1 || filmChoice > films.size()) {
            System.out.println("Некорректный выбор фильма.");
            return;
        }

        System.out.println("Доступные кинозалы:");
        for (int i = 0; i < cinemaHalls.size(); i++) {
            int j = i + 1;
            System.out.print("#" + j + " Кинозал " + cinemaHalls.get(i).getHallNumber() + " | ");
            if ((i + 1) % filmsPerLine == 0) {
                System.out.println();
            }
        }
        System.out.println();

        System.out.print("Введите номер выбранного кинозала: ");
        int cinemaHallChoice = scanner.nextInt();
        scanner.nextLine();

        if (cinemaHallChoice < 1 || cinemaHallChoice > cinemaHalls.size()) {
            System.out.println("Некорректный выбор кинозала.");
            return;
        }

        IFilm film = films.get(filmChoice - 1);
        ICinemaHall cinemaHall = cinemaHalls.get(cinemaHallChoice - 1);

        System.out.print("Введите время начала сеанса (например, '15:00'): ");
        String startTime = scanner.nextLine();
        System.out.print("Введите время окончания сеанса (например, '17:00'): ");
        String endTime = scanner.nextLine();

        Session newSession = new Session(film, cinemaHall, startTime, endTime);
        sessions.add(newSession);
        System.out.println("Сеанс успешно добавлен.");
    }

    public void deleteSession() {
        Scanner scanner = new Scanner(System.in);
        boolean validInput = false;

        do {
            System.out.print("Введите номер сеанса для удаления: ");
            int sessionNumber;
            if (scanner.hasNextInt()) {
                sessionNumber = scanner.nextInt();
                if (sessionNumber >= 1 && sessionNumber <= sessions.size()) {
                    validInput = true;
                    ISession deletedSession = sessions.remove(sessionNumber - 1);
                    System.out.println("Сеанс с фильмом '" + deletedSession.getFilm().getName() + "' успешно удален.");
                } else {
                    System.out.println(RED_COLOR + "Некорректный номер сеанса. Пожалуйста, повторите ввод." + RESET_COLOR);
                }
            } else {
                System.out.println(RED_COLOR + "Некорректный ввод. Пожалуйста, введите число." + RESET_COLOR);
                scanner.next();
            }
        } while (!validInput);
    }

    public void editSession() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите номер сеанса для редактирования: ");
        int sessionNumber;
        if (scanner.hasNextInt()) {
            sessionNumber = scanner.nextInt();
            if (sessionNumber >= 1 && sessionNumber <= sessions.size()) {
                ISession session = sessions.get(sessionNumber - 1);

                System.out.println("Выберите, что вы хотите отредактировать:");
                System.out.println("1. Фильм");
                System.out.println("2. Кинозал");
                System.out.println("3. Время начала");
                System.out.println("4. Время окончания");

                int editChoice;
                while (true) {
                    System.out.print("Введите ваш выбор: ");
                    if (scanner.hasNextInt()) {
                        editChoice = scanner.nextInt();
                        if (editChoice >= 1 && editChoice <= 4) {
                            break;
                        } else {
                            System.out.println(RED_COLOR + "Некорректный выбор. Пожалуйста, введите число от 1 до 4." + RESET_COLOR);
                        }
                    } else {
                        System.out.println(RED_COLOR + "Некорректный ввод. Пожалуйста, введите число от 1 до 4." + RESET_COLOR);
                        scanner.next();
                    }
                }

                scanner.nextLine();

                switch (editChoice) {
                    case 1:
                        List<IFilm> availableFilms = getAvailableFilms();
                        System.out.println("Доступные фильмы:");
                        for (int i = 0; i < availableFilms.size(); i++) {
                            IFilm film = availableFilms.get(i);
                            System.out.println((i + 1) + ". " + film.getName());
                        }
                        System.out.print("Введите номер выбранного фильма: ");
                        int filmChoice = scanner.nextInt();
                        if (filmChoice >= 1 && filmChoice <= availableFilms.size()) {
                            IFilm newFilm = availableFilms.get(filmChoice - 1);
                            session.setFilm(newFilm);
                            System.out.println("Фильм успешно изменен.");
                        } else {
                            System.out.println(RED_COLOR + "Некорректный выбор фильма." + RESET_COLOR);
                        }
                        break;
                    case 2:
                        List<ICinemaHall> availableCinemaHalls = getAvailableCinemaHalls();
                        System.out.println("Доступные кинозалы:");
                        for (int i = 0; i < availableCinemaHalls.size(); i++) {
                            ICinemaHall cinemaHall = availableCinemaHalls.get(i);
                            System.out.println((i + 1) + ". " + cinemaHall.getHallNumber());
                        }
                        System.out.print("Введите номер выбранного кинозала: ");
                        int hallChoice = scanner.nextInt();
                        if (hallChoice >= 1 && hallChoice <= availableCinemaHalls.size()) {
                            ICinemaHall newHall = availableCinemaHalls.get(hallChoice - 1);
                            session.setCinemaHall(newHall);
                            System.out.println("Кинозал успешно изменен.");
                        } else {
                            System.out.println(RED_COLOR + "Некорректный выбор кинозала." + RESET_COLOR);
                        }
                        break;
                    case 3:
                        System.out.print("Введите новое время начала сеанса (например, '15:00'): ");
                        String newStartTime = scanner.nextLine();
                        session.setStartTime(newStartTime);
                        System.out.println("Время начала успешно изменено.");
                        break;
                    case 4:
                        System.out.print("Введите новое время окончания сеанса (например, '17:00'): ");
                        String newEndTime = scanner.nextLine();
                        session.setEndTime(newEndTime);
                        System.out.println("Время окончания успешно изменено.");
                        break;
                }
            } else {
                System.out.println(RED_COLOR + "Некорректный номер сеанса. Пожалуйста, повторите ввод." + RESET_COLOR);
            }
        } else {
            System.out.println(RED_COLOR + "Некорректный ввод. Пожалуйста, введите номер сеанса." + RESET_COLOR);
            scanner.next();
        }
    }

    private void viewAllSessions() {
        if (sessions.isEmpty()) {
            System.out.println(RED_COLOR + "Список сеансов пуст." + RESET_COLOR);
        } else {
            System.out.println("Список всех сеансов:");
            for (int i = 0; i < sessions.size(); i++) {
                ISession session = sessions.get(i);
                System.out.println((i + 1) + ". " + session.getFilm().getName() + ", " + session.getCinemaHall().getHallNumber() +" ( " + session.getStartTime() + " - " + session.getEndTime() + ")");
            }
        }
    }
}
//TODO need to realize timeEndSession = startFilmSessionTime + getFilmDuration
//TODO change addSession logic
