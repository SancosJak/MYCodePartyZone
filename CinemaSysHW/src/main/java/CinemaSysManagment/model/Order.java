package CinemaSysManagment.model;

import CinemaSysManagment.dao.IOrder;
import CinemaSysManagment.dao.IProduct;
import CinemaSysManagment.dao.ITicket;

import java.util.ArrayList;
import java.util.List;

public class Order implements IOrder {
    private static int nextOrderId = 1;
    private int id;
    private List<ITicket> tickets;
    private List<IProduct> products;
    private String status;

    public Order() {
        this.id = nextOrderId++;
        this.tickets = new ArrayList<>();
        this.products = new ArrayList<>();
        this.status = "Новый";
    }

    public int getId() {
        return id;
    }

    public List<IProduct> getProducts() {
        return products;
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
    @Override
    public void setProducts(List<IProduct> products) {
        this.products = products;
    }

}
