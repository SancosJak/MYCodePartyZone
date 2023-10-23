package CinemaSysManagment.model;

import CinemaSysManagment.dao.ICinemaHall;
import CinemaSysManagment.dao.IFilm;
import CinemaSysManagment.dao.ISession;
import CinemaSysManagment.dao.ITicket;

import java.util.ArrayList;
import java.util.List;

public class Session implements ISession {
    private IFilm film;
    private ICinemaHall cinemaHall;
    private String startTime;
    private String endTime;
    private List<ITicket> tickets;
    private int id;
    private List<ITicket> soldTickets;

    public Session(IFilm film, ICinemaHall cinemaHall, String startTime, String endTime) {
        this.film = film;
        this.cinemaHall = cinemaHall;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public Session(IFilm film, ICinemaHall cinemaHall, String endTime) {
        this.film = film;
        this.cinemaHall = cinemaHall;
        this.endTime = endTime;
    }
    public Session() {
        soldTickets = new ArrayList<>();
    }

    public void addSoldTicket(ITicket ticket) {
        soldTickets.add(ticket);
    }


    public IFilm getFilm() {
        return film;
    }

    /**
     * Установить фильм для этого сеанса.
     *
     * @param film Фильм для показа во время сеанса.
     */
    @Override
    public void setFilm(IFilm film) {
        this.film = film;
    }

    public ICinemaHall getCinemaHall() {
        return cinemaHall;
    }

    /**
     * Установить кинозал для этого сеанса.
     *
     * @param cinemaHall Кинозал для проведения сеанса.
     */
    @Override
    public void setCinemaHall(ICinemaHall cinemaHall) {
        this.cinemaHall = cinemaHall;
    }


    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public List<ITicket> getTickets() {
        return tickets;
    }

    /**
     * Добавить новый билет в список билетов сеанса.
     *
     * @param ticket Новый билет для добавления в сеанс.
     */
    @Override
    public void addTicket(ITicket ticket) {
        tickets.add(ticket);
    }

    public void removeTicket(ITicket ticket) {
        tickets.remove(ticket);
    }

    @Override
    public void addBookedTicket(ITicket ticket) {

    }

    @Override
    public boolean isBookingAvailable() {
        return false;
    }
    public int getId() {
        return id;
    }

    @Override
    public List<ITicket> getSoldTickets() {
        return soldTickets;
    }
}