package CinemaSysManagment.model;

import CinemaSysManagment.dao.*;

import java.util.ArrayList;
import java.util.List;

public class Customer implements ICustomer {

    private String username;
    private String password;
    private List<IOrder> orderHistory;
    private List<ITicket> bookingHistory;

    public Customer(String username, String password) {
        this.username = username;
        this.password = password;
        this.orderHistory = new ArrayList<>();
        this.bookingHistory = new ArrayList<>();
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

    @Override
    public ITicket bookTicket(ISession session) throws YourCustomException {
        //  реализация бронирования билета
        if (session.isBookingAvailable()) {
            ITicket ticket = new Ticket(session);
            session.addBookedTicket(ticket);
            bookingHistory.add(ticket);
            return ticket;
        } else {
            throw new YourCustomException("Бронирование билета невозможно: сеанс закончился или билеты закончились.");
        }
    }

    @Override
    public IOrder purchaseProduct(IProduct product, int quantity) throws YourCustomException {
        //  реализация покупки продукта
        if (product.getStockQuantity() >= quantity) {
            IOrder order = new Order();
            order.addProduct(product, quantity);
            product.reduceStock(quantity);
            orderHistory.add(order);
            return order;
        } else {
            throw new YourCustomException("Покупка продукта невозможна: недостаточное количество продукта на складе.");
        }
    }

    @Override
    public List<IOrder> getOrderHistory() {
        return orderHistory;
    }

    @Override
    public List<ITicket> getBookingHistory() {
        return bookingHistory;
    }
}