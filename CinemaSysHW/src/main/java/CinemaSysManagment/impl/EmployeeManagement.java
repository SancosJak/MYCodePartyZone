package CinemaSysManagment.impl;

import CinemaSysManagment.dao.IEmployee;
import CinemaSysManagment.model.Employee;

import java.util.List;
import java.util.Scanner;

public class EmployeeManagement {
    private List<IEmployee> employees;

    public EmployeeManagement(List<IEmployee> employees) {
        this.employees = employees;
    }

    public void run() {
        while (true) {
            System.out.println("Управление персоналом:");
            System.out.println("1. Добавить сотрудника");
            System.out.println("2. Удалить сотрудника");
            System.out.println("3. Просмотреть список сотрудников");
            System.out.println("4. Вернуться в меню администратора");

            Scanner scanner = new Scanner(System.in);

            int adminEmployeeChoice;
            while (true) {
                System.out.print("Введите ваш выбор: ");
                if (scanner.hasNextInt()) {
                    adminEmployeeChoice = scanner.nextInt();
                    if (adminEmployeeChoice >= 1 && adminEmployeeChoice <= 4) {
                        break;
                    } else {
                        System.out.println("Некорректный выбор. Пожалуйста, введите число от 1 до 4.");
                    }
                } else {
                    System.out.println("Некорректный ввод. Пожалуйста, введите число от 1 до 4.");
                    scanner.next();
                }
            }

            switch (adminEmployeeChoice) {
                case 1:
                    addEmployee();
                    break;
                case 2:
                    deleteEmployee();
                    break;
                case 3:
                    viewEmployees();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Некорректный выбор. Пожалуйста, введите число от 1 до 4.");
            }
        }
    }

    private void addEmployee() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите имя сотрудника: ");
        String firstName = scanner.nextLine();
        System.out.print("Введите фамилию сотрудника: ");
        String lastName = scanner.nextLine();
        System.out.print("Введите контактную информацию сотрудника: ");
        String contactInfo = scanner.nextLine();
        System.out.print("Введите должность сотрудника: ");
        String position = scanner.nextLine();
        System.out.print("Введите имя пользователя сотрудника: ");
        String username = scanner.nextLine();
        System.out.print("Введите пароль сотрудника: ");
        String password = scanner.nextLine();

        IEmployee newEmployee = new Employee(username, password, position, firstName, lastName, contactInfo);
        employees.add(newEmployee);
        System.out.println("Сотрудник успешно добавлен.");
    }

    private void deleteEmployee() {
        Scanner scanner = new Scanner(System.in);
        boolean validInput = false;

        do {
            System.out.print("Введите номер сотрудника для удаления: ");
            int employeeNumber;
            if (scanner.hasNextInt()) {
                employeeNumber = scanner.nextInt();
                if (employeeNumber >= 1 && employeeNumber <= employees.size()) {
                    validInput = true;
                    IEmployee deletedEmployee = employees.remove(employeeNumber - 1);
                    System.out.println("Сотрудник " + deletedEmployee.getFirstName() + " " + deletedEmployee.getLastName() + " успешно удален.");
                } else {
                    System.out.println("Некорректный номер сотрудника. Пожалуйста, повторите ввод.");
                }
            } else {
                System.out.println("Некорректный ввод. Пожалуйста, введите число.");
                scanner.next();
            }
        } while (!validInput);
    }

    private void viewEmployees() {
        if (employees.isEmpty()) {
            System.out.println("Список сотрудников пуст.");
        } else {
            System.out.println("Список всех сотрудников:");
            for (int i = 0; i < employees.size(); i++) {
                IEmployee employee = employees.get(i);
                System.out.println((i + 1) + ". " + employee.getFirstName() + " " + employee.getLastName() + " (" + employee.getPosition() + ")");
            }
        }
    }
}
// TODO check and realize all mismatch(s) and add color to errMess also try-catch