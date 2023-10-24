package CinemaSysManagment.role;

import CinemaSysManagment.dao.*;
import CinemaSysManagment.impl.DataManagement;
import CinemaSysManagment.model.Order;
import CinemaSysManagment.model.Product;
import CinemaSysManagment.model.Session;
import CinemaSysManagment.model.Ticket;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeMenu {
    private static final String EMPLOYEE_USERNAME = "employee";
    private static final String EMPLOYEE_PASSWORD = "employee";

    public static final String RED_COLOR = "\u001B[31m";
    public static final String RESET_COLOR = "\u001B[0m";

    private IEmployee currentEmployee;
    private  List<Order> orders = new ArrayList<>();
    List<Session> sessions = new ArrayList<>();
    private List<IProduct> products;

    private IOrder order;

    private DataManagement dataManagement;

    public EmployeeMenu(List<IProduct> products, IOrder order) {
        this.products = products;
        this.order = order;
    }

    public EmployeeMenu(List<IProduct> products) {
        this.products = products;
    }

    public EmployeeMenu(IEmployee employee) {
        this.currentEmployee = employee;
    }

    public boolean authenticate() {
        boolean authenticated = false;
        Scanner scanner = new Scanner(System.in);

        while (!authenticated) {
            System.out.println("Введите имя пользователя: ");
            String username = scanner.next();
            System.out.println("Введите пароль: ");
            String password = scanner.next();

            if (username.equals(EMPLOYEE_USERNAME) && password.equals(EMPLOYEE_PASSWORD)) {
                authenticated = true;
                Logger.log("Сотрудник " + username + " вошел в систему.");
                System.out.println("Вход выполнен успешно.");
            } else {
                Logger.log("Попытка неудачного входа сотрудника " + username);
                System.out.println(RED_COLOR + "Неверное имя пользователя или пароль. Пожалуйста, повторите ввод." + RESET_COLOR);
            }
        }
        return true;
    }

    public void run() {
       // dataManagement.loadDataFromJson("data.json");
        boolean exitRequested = false;
        do {
            System.out.println("Добро пожаловать, " + currentEmployee.getFirstName() + "!");
            System.out.println("Выберите действие:");
            System.out.println("1. Создание заказа");
            System.out.println("2. Просмотр всех заказов");
            System.out.println("3. Редактирование заказов");
            System.out.println("4. Отмена заказов");
            System.out.println("5. Выход");

            Scanner scanner = new Scanner(System.in);
            int employeeChoice;

            try {
                employeeChoice = scanner.nextInt();
            } catch (java.util.InputMismatchException e) {
                employeeChoice = 0;
                scanner.nextLine();
            }

            switch (employeeChoice) {
                case 1:
                    createOrder();
                    break;
                case 2:
                    viewOrders(orders);
                    break;
                case 3:
                    editOrders(orders);
                    break;
                case 4:
                    cancelOrder(orders);
                    break;
                case 5:
                    exitRequested = true;
                    Logger.log("Сотрудник вышел из системы.");
                    break;
                default:
                    System.out.println(RED_COLOR + "Некорректный выбор. Пожалуйста, введите число от 1 до 5." + RESET_COLOR);
            }
        } while (!exitRequested);
    }
    private void createOrder() {
        Order order = new Order();
        List<ITicket> tickets = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Создание билета:");
            ITicket ticket = createTicket();
            tickets.add(ticket);

            System.out.println("Хотите добавить еще билеты? (да/нет)");
            String choice = scanner.next();
            if (!"да".equalsIgnoreCase(choice)) {
                break;
            }
        }

        addProductsToOrder(order);

        for (ITicket ticket : tickets) {
            order.addTicket(ticket);
        }

        order.setStatus("Новый");
        orders.add(order);

        System.out.println("Заказ успешно создан.");
        System.out.println("Информация о заказе:");
        System.out.println("Статус: " + order.getStatus());
        System.out.println("Итоговая стоимость: " + order.getTotalPrice());
    }

    private ITicket createTicket() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите номер сеанса: ");
        int sessionId = scanner.nextInt();
        ISession session = findSessionById(sessionId);

        if (session == null) {
            System.out.println("Сеанс с указанным номером не найден.");
            return null;
        }

        System.out.print("Введите цену билета: ");
        double price = scanner.nextDouble();

        System.out.print("Введите номер места: ");
        int seatNumber = scanner.nextInt();

        System.out.print("Введите статус билета: ");
        String status = scanner.next();

        return new Ticket(session, seatNumber, price, status);
    }
    private ISession findSessionById(int sessionId) {
        for (ISession session : sessions) {
            if (session.getId() == sessionId) {
                return session;
            }
        }
        return null;
    }

    private void addProductsToOrder(IOrder order) {
        Scanner scanner = new Scanner(System.in);
        List<IProduct> products = new ArrayList<>();

        boolean isAddingProducts = true;

        while (isAddingProducts) {
            System.out.println("Добавление продукта к заказу:");
            System.out.println("1. Кола");
            System.out.println("2. Вода");
            System.out.println("3. Чипсы");
            System. out.println("4. Попкорн");
            System.out.println("5. Завершить добавление продуктов");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    IProduct cola = new Product("Кола", 2.0);
                    products.add(cola);
                    break;
                case 2:
                    IProduct water = new Product("Вода", 1.0);
                    products.add(water);
                    break;
                case 3:
                    IProduct chips = new Product("Чипсы", 2.5);
                    products.add(chips);
                    break;
                case 4:
                    IProduct popcorn = new Product("Попкорн", 3.0);
                    products.add(popcorn);
                    break;
                case 5:
                    isAddingProducts = false;
                    break;
                default:
                    System.out.println("Некорректный выбор. Пожалуйста, выберите от 1 до 5.");
            }
        }

        if (!products.isEmpty()) {
            System.out.println("Вы добавили следующие продукты в корзину:");
            for (IProduct product : products) {
                System.out.println(product.getName());
            }
            System.out.println("Хотите подтвердить заказ? (да/нет)");
            String confirmation = scanner.next();

            if ("да".equalsIgnoreCase(confirmation)) {
                for (IProduct product : products) {
                    System.out.print("Укажите количество " + product.getName() + ": ");
                    int quantity = scanner.nextInt();
                    order.addProduct(product, quantity);
                }
                System.out.println("Заказ подтвержден.");
            }
        }
    }
    //TODO FamilyPack, ClassicPack, all item size choice -> diff prices



    private void viewOrders(List<Order> orders) {
        if (orders.isEmpty()) {
            System.out.println("Нет доступных заказов.");
            return;
        }

        for (int i = 0; i < orders.size(); i++) {
            Order order = orders.get(i);
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


    private void editOrders(List<Order> orders) {
        Scanner scanner = new Scanner(System.in);

        if (orders.isEmpty()) {
            System.out.println("Нет доступных заказов для редактирования.");
            return;
        }

        System.out.println("Список всех заказов:");
        for (int i = 0; i < orders.size(); i++) {
            Order order = orders.get(i);
            System.out.println((i + 1) + ". Заказ №" + order.getId());
        }

        System.out.print("Введите номер заказа для редактирования: ");
        int orderNumber = scanner.nextInt();

        if (orderNumber < 1 || orderNumber > orders.size()) {
            System.out.println("Некорректный номер заказа.");
            return;
        }

        Order selectedOrder = orders.get(orderNumber - 1);

        System.out.println("Выбранный заказ (Заказ №" + selectedOrder.getId() + "):");
        for (IProduct product : selectedOrder.getProducts()) {
            System.out.println(product.getName() + " - " + product.getStockQuantity() + "шт.");
        }

        List<IProduct> products = new ArrayList<>();
        boolean productsAdded = false;

        while (true) {
            System.out.println("1. Добавить продукт к заказу");
            System.out.println("2. Убавить продукт из заказа");
            System.out.println("3. Завершить редактирование заказа");

            int editChoice = scanner.nextInt();

            switch (editChoice) {
                case 1:
                    System.out.print("Введите название продукта для добавления: ");
                    String productName = scanner.next();
                    System.out.print("Введите количество: ");
                    int quantity = scanner.nextInt();

                    IProduct productToAdd = findProductByName(productName);
                    if (productToAdd != null) {
                        products.add(productToAdd);
                        productToAdd.setStockQuantity(quantity);
                        productsAdded = true;
                    } else {
                        System.out.println("Продукт с таким названием не найден.");
                    }
                    break;
                case 2:
                    System.out.print("Введите название продукта для удаления: ");
                    String productToRemoveName = scanner.next();

                    IProduct productToRemove = findProductByName(productToRemoveName);
                    if (productToRemove != null) {
                        products.remove(productToRemove);
                    } else {
                        System.out.println("Продукт с таким названием не найден.");
                    }
                    break;
                case 3:
                    if (productsAdded) {
                        System.out.println("Вы добавили следующие продукты к заказу:");
                        for (IProduct product : products) {
                            System.out.println(product.getName() + " (Количество: " + product.getStockQuantity() + ")");
                        }
                        System.out.println("Хотите подтвердить изменения заказа? (да/нет)");
                        String confirmation = scanner.next();
                        if ("да".equalsIgnoreCase(confirmation)) {
                            selectedOrder.setProducts(products);
                            System.out.println("Изменения заказа подтверждены.");
                        }
                    }
                    return;
                default:
                    System.out.println("Некорректный выбор. Пожалуйста, выберите от 1 до 3.");
            }
        }
    }

    private IProduct findProductByName(String productName) {
        for (IProduct product : products) {
            if (product.getName().equalsIgnoreCase(productName)) {
                return product;
            }
        }
        return null;
    }
    private void cancelOrder(List<Order> orders) {
        Scanner scanner = new Scanner(System.in);

        if (orders.isEmpty()) {
            System.out.println("Нет доступных заказов для отмены.");
            return;
        }

        System.out.println("Список всех заказов:");
        for (int i = 0; i < orders.size(); i++) {
            Order order = orders.get(i);
            System.out.println((i + 1) + ". Заказ №" + order.getId());
        }

        System.out.print("Введите номер заказа для отмены: ");
        int orderNumberToCancel = scanner.nextInt();

        if (orderNumberToCancel < 1 || orderNumberToCancel > orders.size()) {
            System.out.println("Некорректный номер заказа.");
            return;
        }

        Order orderToCancel = orders.get(orderNumberToCancel - 1);

        if (orderToCancel.getStatus().equalsIgnoreCase("Отменен")) {
            System.out.println("Заказ уже отменен.");
        } else if (orderToCancel.getStatus().equalsIgnoreCase("Оплачен")) {
            System.out.println("Заказ нельзя отменить, так как он уже оплачен.");
        } else {
            orderToCancel.setStatus("Отменен");
            System.out.println("Заказ успешно отменен.");
        }
    }
}
// TODO check and realize all mismatch(s) and add color to errMess also try-catch, load data from file after login
