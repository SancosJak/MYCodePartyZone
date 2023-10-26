package CinemaSysManagment.impl;

import CinemaSysManagment.model.Film;
import CinemaSysManagment.role.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FilmManagement {
    private List<Film> films = new ArrayList<>();
    public static final String RED_COLOR = "\u001B[31m";
    public static final String RESET_COLOR = "\u001B[0m";

    public FilmManagement(List<Film> films) {
        this.films = films;
    }
    public List<Film> getFilms() {
        return films;
    }
    public void setFilms(List<Film> films) {
        this.films = films;
    }

    public void run() {
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
                    try {
                        addFilm();
                    } catch (Exception e) {
                        System.out.println(RED_COLOR + "Ошибка при добавлении фильма: " + e.getMessage() + RESET_COLOR);
                    }
                    break;
                case 2:
                    try {
                        deleteFilm();
                    } catch (Exception e) {
                        System.out.println(RED_COLOR + "Ошибка при удалении фильма: " + e.getMessage() + RESET_COLOR);
                    }
                    break;
                case 3:
                    viewAllFilms();
                    break;
                case 4:
                    return;
                default:
                    System.out.println(RED_COLOR + "Некорректный выбор. Пожалуйста, введите число от 1 до 4." + RESET_COLOR);
            }
        }
    }

    public void addFilm() {
        Scanner scanner = new Scanner(System.in);
        boolean validInput = false;

        do {
            try {
                System.out.println("Введите название фильма:");
                String name = scanner.nextLine();
                System.out.println("Введите продолжительность фильма (в минутах):");
                int duration = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Введите жанр фильма:");
                String genre = scanner.nextLine();
                System.out.println("Введите рейтинг фильма:");
                String rating = scanner.nextLine();
                System.out.println("Введите описание фильма:");
                String description = scanner.nextLine();
                System.out.println("Введите язык фильма:");
                String language = scanner.nextLine();

                if (!name.isEmpty() && duration > 0) {
                    validInput = true;
                    Film newFilm = new Film(name, duration, genre, rating, description, language);
                    films.add(newFilm);
                    System.out.println("Фильм успешно добавлен.");
                    Logger.log("Добавлен новый фильм: " + name);
                } else {
                    System.out.println(RED_COLOR + "Некорректные данные фильма. Пожалуйста, повторите ввод." + RESET_COLOR);
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println(RED_COLOR + "Ошибка: некорректный ввод. Пожалуйста, повторите ввод." + RESET_COLOR);
                scanner.nextLine();
            }
        } while (!validInput);
    }

    public void deleteFilm() {
        Scanner scanner = new Scanner(System.in);
        boolean validInput = false;

        if (films.isEmpty()) {
            System.out.println(RED_COLOR + "Список фильмов пуст. Нечего удалять." + RESET_COLOR);
            return;
        }

        do {
            System.out.println("Введите номер фильма для удаления:");
            int filmNumber = scanner.nextInt();

            if (filmNumber >= 1 && filmNumber <= films.size()) {
                validInput = true;
                Film deletedFilm = films.remove(filmNumber - 1);
                System.out.println("Фильм '" + deletedFilm.getName() + "' успешно удален.");
                Logger.log("Удален фильм: " + deletedFilm.getName());
            } else {
                System.out.println(RED_COLOR + "Некорректный номер фильма. Пожалуйста, повторите ввод." + RESET_COLOR);
            }
        } while (!validInput);
    }

    public void viewAllFilms() {
        if (films.isEmpty()) {
            System.out.println(RED_COLOR + "Список фильмов пуст." + RESET_COLOR);
        } else {
            System.out.println("Список всех фильмов:");
            for (int i = 0; i < films.size(); i++) {
                Film film = films.get(i);
                System.out.println("Фильм #" + (i + 1));
                System.out.println("Название: " + film.getName());
                System.out.println("Продолжительность: " + film.getDuration() + " минут");
                System.out.println("Жанр: " + film.getGenre());
                System.out.println("Рейтинг: " + film.getRating());
                System.out.println("Описание: " + film.getDescription());
                System.out.println("Язык: " + film.getLanguage());
                System.out.println();
            }
        }
    }

}
