package CinemaSysManagment.model;

import CinemaSysManagment.dao.IOrder;
import CinemaSysManagment.dao.IProduct;
import CinemaSysManagment.dao.ITicket;

import java.util.ArrayList;
import java.util.List;

public class Order implements IOrder {
    private List<ITicket> tickets;
    private String status;

    public Order() {
        this.tickets = new ArrayList<>();
        this.status = "Новый"; // По умолчанию заказ имеет статус "Новый"
    }

    public List<ITicket> getTickets() {
        return tickets;
    }

    public void addTicket(ITicket ticket) {
        tickets.add(ticket);
    }

    public void removeTicket(ITicket ticket) {
        tickets.remove(ticket);
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getTotalPrice() {
        double totalPrice = 0.0;
        for (ITicket ticket : tickets) {
            totalPrice += ticket.getPrice();
        }
        return totalPrice;
    }

    public void pay() {
        status = "Оплачен";
        for (ITicket ticket : tickets) {
            ticket.setStatus("Оплачен");
        }
    }

    @Override
    public void addProduct(IProduct product, int quantity) {

    }
}