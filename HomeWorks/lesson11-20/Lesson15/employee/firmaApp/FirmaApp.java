package employee.firmaApp;
import employee.model.Employee;

public class FirmaApp {
    public static void main(String[] args) {

        int numberOfEmployees = 3;
        Employee[] employees = new Employee[numberOfEmployees];
        Employee employee1 = new Employee("Id7", "Sandor", "Ivanyo", "M", 3100,1);
        employee1.display();

        employees[0] = new Employee("T1000", "Sara", "Connor", "Ж", 5000.0, 2);
        employees[1] = new Employee("007", "James", "Bond", "М", 10000.0, 1);
        employees[2] = new Employee("832у3", "Jack", "Sparrow", "М", 4500.0, 4);

        for (int i = 0; i < numberOfEmployees; i++) {
            Employee employee = employees[i];
            System.out.println("Уникальный номер: " + employee.getPersonalId());
            System.out.println("Имя: " + employee.getFirstName());
            System.out.println("Фамилия: " + employee.getLastName());
            System.out.println("Пол: " + employee.getGender());
            System.out.println("Зарплата: " + employee.getSalary());
            System.out.println("Уровень налогообложения: " + employee.getTaxLevel());
            System.out.println();
        }
    }
}
