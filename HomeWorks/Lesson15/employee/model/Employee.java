package employee.model;
/*
Создать класс Работник (Employee) c полями:
уникальный номер
имя
фамилия
пол
зарплата
уровень налогообложения
Создать приложение FirmaAppl в котором принять на работу несколько сотрудников.
 */
public class Employee {
    public String personalId;
    public String firstName;
    public String lastName;
    public String gender;
    public double salary;
    public int taxLevel;

    // конструктор
    public Employee(String personalId, String firstName, String lastName, String gender, double salary, int taxLevel) {
        this.personalId = personalId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.salary = salary;
        this.taxLevel = taxLevel;
    }

    public String getPersonalId() {
        return personalId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getGender() {
        return gender;
    }

    public double getSalary() {
        return salary;
    }

    public int getTaxLevel() {
        return taxLevel;
    }

    public void display() {
        System.out.println("Уникальный номер: " + personalId);
        System.out.println("Имя: " + firstName);
        System.out.println("Фамилия: " + lastName);
        System.out.println("Пол: " + gender);
        System.out.println("Зарплата: " + salary);
        System.out.println("Уровень налогообложения: " + taxLevel);
        System.out.println();
    }
}
