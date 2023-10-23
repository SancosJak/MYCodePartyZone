package CinemaSysManagment.role;

import CinemaSysManagment.dao.*;
import CinemaSysManagment.impl.DataManagement;
import CinemaSysManagment.model.Order;
import CinemaSysManagment.model.Ticket;
import CinemaSysManagment.model.YourCustomException;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ClientMenu {
    private ICustomer currentCustomer;
    DataManagement dataManagement;
    private static final String CLIENT_USERNAME = "client";
    private static final String CLIENT_PASSWORD = "client";
    public static final String RED_COLOR = "\u001B[31m";
    public static final String RESET_COLOR = "\u001B[0m";
    private ISession[] sessions;
    private ISession selectedSession;

    public ClientMenu(ICustomer currentCustomer) {
        this.currentCustomer = currentCustomer;
    }

    public boolean authenticate() {
        boolean authenticated = false;
        Scanner scanner = new Scanner(System.in);

        while (!authenticated) {
            System.out.println("Введите имя пользователя: ");
            String username = scanner.next();
            System.out.println("Введите пароль: ");
            String password = scanner.next();

            if (username.equals(CLIENT_USERNAME) && password.equals(CLIENT_PASSWORD)) {
                authenticated = true;
                Logger.log("Клиент " + username + " вошел в систему.");
                System.out.println("Вход выполнен успешно.");
            } else {
                Logger.log("Попытка неудачного входа клиента " + username);
                System.out.println(RED_COLOR + "Неверное имя пользователя или пароль. Пожалуйста, повторите ввод." + RESET_COLOR);
            }
        }
        return true;
    }

    public void run() {
        //dataManagement.loadDataFromJson("data.json");
        boolean exitRequested = false;
        do {
            System.out.println("Добро пожаловать, " + currentCustomer.getUsername() + "!");
            System.out.println("Выберите действие:");
            System.out.println("1. Просмотр доступных сеансов");
            System.out.println("2. Покупка билетов");
            System.out.println("3. Возврат билетов");
            System.out.println("4. Просмотр статуса мест в зале");
            System.out.println("5. Просмотр заказов");
            System.out.println("6. Выход");

            Scanner scanner = new Scanner(System.in);
            int clientChoice;

            try {
                clientChoice = scanner.nextInt();
            } catch (java.util.InputMismatchException e) {
                clientChoice = 0;
                scanner.nextLine();
            }

            switch (clientChoice) {
                case 1:
                    viewAvailableSessions();
                    break;
                case 2:
                    buyTickets();
                    break;
                case 3:
                    returnTickets();
                    break;
                case 4:
                    viewSeatStatus();
                    break;
                case 5:
                    viewOrders(currentCustomer.getOrderHistory());
                    break;
                case 6:
                    exitRequested = true;
                    break;
                default:
                    System.out.println("Некорректный выбор. Пожалуйста, введите число от 1 до 6.");
            }
        } while (!exitRequested);
    }

    private void viewAvailableSessions() {
        if (dataManagement == null) {
            System.out.println("Система управления сеансами не инициализирована.");
            return;
        }

        List<ISession> availableSessions = getAvailableSessions();

        if (availableSessions.isEmpty()) {
            System.out.println("Нет доступных сеансов.");
        } else {
            System.out.println("Доступные сеансы:");
            for (ISession session : availableSessions) {
                System.out.println("Сеанс #" + session.getId());
                System.out.println("Фильм: " + session.getFilm().getName());
                System.out.println("Время: " + session.getFilm().getDuration());
                System.out.println("Мест в зале: " + session.getCinemaHall().getCapacity());
                System.out.println();
            }
        }
    }
    public List<ISession> getAvailableSessions() {
        List<ISession> availableSessions = new ArrayList<>();
        for (ISession session : sessions) {
            if (session.getCinemaHall().getCapacity() > 0) {
                availableSessions.add(session);
            }
        }
        return availableSessions;
    }

    private void buyTickets() {
        List<ISession> availableSessions = getAvailableSessions();

        if (availableSessions.isEmpty()) {
            System.out.println("Нет доступных сеансов.");
            return;
        }

        System.out.println("Доступные сеансы:");

        for (ISession session : availableSessions) {
            System.out.println("Сеанс #" + session.getId());
            System.out.println("Фильм: " + session.getFilm().getName());
            System.out.println("Время: " + session.getFilm().getDuration());
            System.out.println("Мест в зале: " + session.getCinemaHall().getCapacity());
            System.out.println();
        }

        Scanner scanner = new Scanner(System.in);

        System.out.print("Выберите номер сеанса для покупки билетов: ");
        int selectedSessionId = scanner.nextInt();
        ISession selectedSession = findSessionById(selectedSessionId, availableSessions);

        if (selectedSession == null) {
            System.out.println("Некорректный номер сеанса.");
            return;
        }

        System.out.print("Укажите количество билетов: ");
        int numberOfTickets = scanner.nextInt();

        if (numberOfTickets <= 0) {
            System.out.println("Некорректное количество билетов.");
            return;
        }

        double ticketPrice = calculateTicketPrice(selectedSession);
        double totalPrice = ticketPrice * numberOfTickets;

        System.out.println("Стоимость билета: " + ticketPrice + " руб.");
        System.out.println("Общая стоимость: " + totalPrice + " руб.");

        List<ITicket> tickets = new ArrayList<>();

        for (int i = 0; i < numberOfTickets; i++) {
            ITicket ticket = new Ticket(selectedSession, i + 1, ticketPrice, "Куплен");
            tickets.add(ticket);
        }

        IOrder order = new Order();
        order.addTicket((ITicket) tickets);
        order.getTotalPrice();

        try {
            currentCustomer.bookTicket((ISession) order);
        } catch (YourCustomException e) {
            throw new RuntimeException(e);
        }

        selectedSession.getCinemaHall().decreaseCapacity(numberOfTickets);

        System.out.print("Вы хотите оплатить билеты? (да/нет): ");
        String paymentChoice = scanner.next();

        if ("да".equalsIgnoreCase(paymentChoice)) {
            order.setStatus("Оплачен");
            System.out.println("Билеты успешно оплачены.");
        } else {
            System.out.println("Оплата отменена.");
        }
    }
    private ISession findSessionById(int sessionId, List<ISession> availableSessions) {
        for (ISession session : availableSessions) {
            if (session.getId() == sessionId) {
                return session;
            }
        }
        return null;
    }
    private double calculateTicketPrice(ISession session) {
        double basePrice = 10.0;
        double priceMultiplier = 1.0;

        if (isWeekend(LocalDateTime.parse(session.getStartTime()))) {
            priceMultiplier = 1.2;
        }

        if (isEvening(LocalDateTime.parse(session.getStartTime()))) {
            priceMultiplier *= 1.1;
        }

        return basePrice * priceMultiplier;
    }

    private boolean isWeekend(LocalDateTime dateTime) {
        DayOfWeek dayOfWeek = dateTime.getDayOfWeek();
        return dayOfWeek == DayOfWeek.SATURDAY || dayOfWeek == DayOfWeek.SUNDAY;
    }

    private boolean isEvening(LocalDateTime dateTime) {
        int hour = dateTime.getHour();
        return hour >= 18;
    }

    private void returnTickets() {
        List<IOrder> orderHistory = currentCustomer.getOrderHistory();

        if (orderHistory.isEmpty()) {
            System.out.println("У вас нет доступных заказов для возврата билетов.");
            return;
        }

        System.out.println("Список ваших заказов:");
        for (int i = 0; i < orderHistory.size(); i++) {
            System.out.println("Заказ #" + (i + 1));
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите номер заказа для возврата билетов: ");
        int selectedOrderNumber = scanner.nextInt();

        if (selectedOrderNumber < 1 || selectedOrderNumber > orderHistory.size()) {
            System.out.println("Некорректный номер заказа.");
            return;
        }

        IOrder selectedOrder = orderHistory.get(selectedOrderNumber - 1);

        List<ITicket> ticketsInOrder = selectedOrder.getTickets();
        System.out.println("Билеты в заказе:");

        for (int i = 0; i < ticketsInOrder.size(); i++) {
            System.out.println("Билет #" + (i + 1));
        }

        System.out.print("Введите номер билета для возврата: ");
        int selectedTicketNumber = scanner.nextInt();

        if (selectedTicketNumber < 1 || selectedTicketNumber > ticketsInOrder.size()) {
            System.out.println("Некорректный номер билета.");
            return;
        }

        ITicket selectedTicket = ticketsInOrder.get(selectedTicketNumber - 1);

        selectedTicket.setReturned(true);

        ICinemaHall cinemaHall = selectedTicket.getSession().getCinemaHall();
        cinemaHall.increaseCapacity(1);

        // TODO return money for ticket

        System.out.println("Билет успешно возвращен.");
    }

    private void viewSeatStatus() {

        ICinemaHall cinemaHall = selectedSession.getCinemaHall();
        List<ITicket> soldTickets = selectedSession.getSoldTickets();

        if (cinemaHall == null) {
            System.out.println("Сеанс не выбран.");
            return;
        }

        System.out.println("Статус мест в зале:");

        int numRows = cinemaHall.getNumRows();
        int seatsPerRow = cinemaHall.getSeatsPerRow();

        for (int row = 1; row <= numRows; row++) {
            for (int seat = 1; seat <= seatsPerRow; seat++) {
                int seatNumber = (row - 1) * seatsPerRow + seat;
                boolean isSold = isSeatSold(seatNumber, soldTickets);
                String seatStatus = isSold ? "Продано" : "Свободно";
                System.out.println("Ряд " + row + ", Место " + seatNumber + ": " + seatStatus);
            }
        }
    }

    private boolean isSeatSold(int seatNumber, List<ITicket> soldTickets) {
        for (ITicket ticket : soldTickets) {
            if (ticket.getSeatNumber() == seatNumber) {
                return true;
            }
        }
        return false;
    }

    private void viewOrders(List<IOrder> orders) {
        if (orders.isEmpty()) {
            System.out.println("Нет доступных заказов.");
            return;
        }

        for (int i = 0; i < orders.size(); i++) {
            IOrder order = orders.get(i);
            System.out.println("Заказ #" + (i + 1));
            System.out.println("Статус: " + order.getStatus());
            System.out.println("Итоговая стоимость: " + order.getTotalPrice());

            List<IProduct> products = order.getProducts();
            if (!products.isEmpty()) {
                System.out.println("Продукты в заказе:");
                for (IProduct product : products) {
                    System.out.println(product.getName() + " x" + product.getStockQuantity());
                }
            }

            System.out.println();
        }
    }
}

// TODO check and realize all mismatch(s) and add color to errMess also try-catch, load data from file after login