package CinemaSysManagment.model;

import CinemaSysManagment.dao.ISession;
import CinemaSysManagment.dao.ITicket;

public class Ticket implements ITicket {
    private ISession session;
    private int seatNumber;
    private double price;
    private String status;
    private boolean returned;

    public Ticket(ISession session, int seatNumber, double price, String status) {
        this.session = session;
        this.seatNumber = seatNumber;
        this.price = price;
        this.status = status;
    }

    public Ticket(boolean returned) {
        this.returned = returned;
    }

    public boolean isReturned() {
        return returned;
    }

    public void setReturned(boolean returned) {
        this.returned = returned;
    }

    public Ticket(ISession session) {
        this.session = session;
    }

    public ISession getSession() {
        return session;
    }

    public void setSession(ISession session) {
        this.session = session;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}