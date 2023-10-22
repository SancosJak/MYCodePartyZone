package CinemaSysManagment.dao;

import CinemaSysManagment.model.YourCustomException;

/**
 * Интерфейс IReportGenerator предоставляет контракт для класса, представляющего генератор отчетов в системе управления кинотеатром.
 */
public interface IReportGenerator {

    /**
     * Создать отчет о продажах билетов за указанный период времени.
     *
     * @param startDate Начальная дата периода для отчета.
     * @param endDate Конечная дата периода для отчета.
     * @return Отчет о продажах билетов за указанный период.
     *
     * @throws YourCustomException (название может быть другим) Этот метод должен обрабатывать собственные исключения,
     * например, когда дата начала периода позже даты конца периода.
     * Студенты должны создать свой собственный класс исключения и обработать его соответствующим образом.
     */
    String generateTicketSalesReport(String startDate, String endDate) throws YourCustomException;

    /**
     * Создать отчет о продажах продуктов за указанный период времени.
     *
     * @param startDate Начальная дата периода для отчета.
     * @param endDate Конечная дата периода для отчета.
     * @return Отчет о продажах продуктов за указанный период.
     *
     * @throws YourCustomException (название может быть другим) Этот метод должен обрабатывать собственные исключения,
     * например, когда дата начала периода позже даты конца периода.
     * Студенты должны создать свой собственный класс исключения и обработать его соответствующим образом.
     */
    String generateProductSalesReport(String startDate, String endDate) throws YourCustomException;
}