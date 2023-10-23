package CinemaSysManagment.dao;

import CinemaSysManagment.model.YourCustomException;

import java.util.List;

/**
 * Интерфейс ICustomer предоставляет контракт для класса, представляющего клиента в системе управления кинотеатром.
 */
public interface ICustomer extends IUser {

    String getFirstName();

    /**
     * Забронировать билет на указанный сеанс.
     *
     * @param session Сеанс, на который следует забронировать билет.
     * @return Забронированный билет.
     *
     * @throws YourCustomException Этот метод должен обрабатывать собственные исключения,
     * например, когда билеты на сеанс закончились или сеанс уже начался.
     * Студенты должны создать свой собственный класс исключения и обработать его соответствующим образом.
     */
    ITicket bookTicket(ISession session) throws YourCustomException;

    /**
     * Купить продукт.
     *
     * @param product Продукт, который следует купить.
     * @param quantity Количество продукта, который следует купить.
     * @return Заказ, содержащий информацию о покупке.
     *
     * @throws YourCustomException Этот метод должен обрабатывать собственные исключения,
     * например, когда запрошенное количество продукта недоступно на складе.
     * Студенты должны создать свой собственный класс исключения и обработать его соответствующим образом.
     */
    IOrder purchaseProduct(IProduct product, int quantity) throws YourCustomException;

    /**
     * Получить историю всех заказов клиента.
     *
     * @return Список всех заказов клиента.
     */
    List<IOrder> getOrderHistory();

    /**
     * Получить историю всех бронирований клиента.
     *
     * @return Список всех бронированных клиентом билетов.
     */
    List<ITicket> getBookingHistory();
}