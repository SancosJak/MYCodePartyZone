package CinemaSysManagment.model;

import CinemaSysManagment.dao.IReportGenerator;

public class ReportGenerator implements IReportGenerator {

    public String generateTicketSalesReport(String startDate, String endDate) throws YourCustomException {
        if (!isValidDate(startDate) || !isValidDate(endDate)) {
            throw new YourCustomException("Неверные даты");
        }

        return "Отчет о продажах билетов за указанный период";
    }

    public String generateProductSalesReport(String startDate, String endDate) throws YourCustomException {
        if (!isValidDate(startDate) || !isValidDate(endDate)) {
            throw new YourCustomException("Неверные даты");
        }

        return "Отчет о продажах продуктов за указанный период";
    }

    private boolean isValidDate(String date) {
        return true;
    }
}
