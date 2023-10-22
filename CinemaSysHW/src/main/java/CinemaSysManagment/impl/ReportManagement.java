package CinemaSysManagment.impl;

import CinemaSysManagment.dao.IReportGenerator;
import CinemaSysManagment.model.YourCustomException;

import java.util.Scanner;

public class ReportManagement {
    private IReportGenerator reportGenerator;

    public ReportManagement(IReportGenerator reportGenerator) {
        this.reportGenerator = reportGenerator;
    }

    public void run() {
        while (true) {
            System.out.println("Управление отчетами:");
            System.out.println("1. Генерировать отчет о продажах билетов");
            System.out.println("2. Генерировать отчет о продажах продуктов");
            System.out.println("3. Вернуться в меню администратора");

            Scanner scanner = new Scanner(System.in);

            int adminReportChoice;
            while (true) {
                System.out.print("Введите ваш выбор: ");
                if (scanner.hasNextInt()) {
                    adminReportChoice = scanner.nextInt();
                    if (adminReportChoice >= 1 && adminReportChoice <= 3) {
                        break;
                    } else {
                        System.out.println("Некорректный выбор. Пожалуйста, введите число от 1 до 3.");
                    }
                } else {
                    System.out.println("Некорректный ввод. Пожалуйста, введите число от 1 до 3.");
                    scanner.next();
                }
            }

            switch (adminReportChoice) {
                case 1:
                    generateTicketSalesReport();
                    break;
                case 2:
                    generateProductSalesReport();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Некорректный выбор. Пожалуйста, введите число от 1 до 3.");
            }
        }
    }

    private void generateTicketSalesReport() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Введите начальную дату (yyyy-MM-dd): ");
            String startDate = scanner.nextLine();

            System.out.print("Введите конечную дату (yyyy-MM-dd): ");
            String endDate = scanner.nextLine();

            String report = reportGenerator.generateTicketSalesReport(startDate, endDate);
            System.out.println("Сгенерированный отчет:\n" + report);
        } catch (YourCustomException e) {
            System.out.println("Ошибка при генерации отчета: " + e.getMessage());
        }
    }

    private void generateProductSalesReport() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Введите начальную дату (yyyy-MM-dd): ");
            String startDate = scanner.nextLine();

            System.out.print("Введите конечную дату (yyyy-MM-dd): ");
            String endDate = scanner.nextLine();

            String report = reportGenerator.generateProductSalesReport(startDate, endDate);
            System.out.println("Сгенерированный отчет:\n" + report);
        } catch (YourCustomException e) {
            System.out.println("Ошибка при генерации отчета: " + e.getMessage());
        }
    }
}
//TODO check and realize all mismatch(s) and add color to errMess