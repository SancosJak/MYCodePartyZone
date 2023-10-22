package CinemaSysManagment.model;

import CinemaSysManagment.dao.*;

public class Administrator implements IAdministrator {

    private String username;
    private String password;

    public Administrator(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Создать новый фильм в системе.
     *
     * @param name     Название фильма.
     * @param duration Продолжительность фильма.
     * @return Информация о созданном фильме.
     */
    @Override
    public IFilm createFilm(String name, int duration) {
        return new Film(name, duration);
    }

    @Override
    public IFilm createFilm(String name, int duration, String genre, String rating, String description, String language) {
        // реализация создания фильма
        return new Film(name, duration, genre, rating, description, language);
    }

    /**
     * Создать новый сеанс в системе.
     *
     * @param film     Фильм для сеанса.
     * @param hall     Кинозал для сеанса.
     * @param dateTime Дата и время сеанса.
     * @return Информация о созданном сеансе.
     */
    @Override
    public ISession createSession(IFilm film, ICinemaHall hall, String dateTime) {
        return new Session(film, hall, dateTime);
    }

    @Override
    public ISession createSession(IFilm film, ICinemaHall cinemaHall, String startTime, String endTime) {
        // реализация создания сеанса
        return new Session(film, cinemaHall, startTime, endTime);
    }

    @Override
    public IProduct createProduct(String name, double price, String description, int stockQuantity) {
        // реализация создания продукта
        return new Product(name, price, description, stockQuantity);
    }

    @Override
    public void deleteFilm(IFilm film) {
        // реализация удаления фильма
    }

    @Override
    public void deleteSession(ISession session) {
        // реализация удаления сеанса
    }

    @Override
    public void deleteProduct(IProduct product) {
        // реализация удаления продукта
    }

    @Override
    public String generateTicketSalesReport(String startDate, String endDate) {
        //  реализация генерации отчета о продажах билетов
        return "Отчет о продажах билетов за указанный период времени";
    }

    @Override
    public String generateProductSalesReport(String startDate, String endDate) {
        //  реализация генерации отчета о продажах продуктов
        return "Отчет о продажах продуктов за указанный период времени";
    }
}