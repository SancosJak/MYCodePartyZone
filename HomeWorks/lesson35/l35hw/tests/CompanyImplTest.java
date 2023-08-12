package l35hw.tests;

import l35hw.dao.Company;
import l35hw.dao.CompanyImpl;
import l35hw.model.Employee;
import l35hw.model.Engineer;
import l35hw.model.Worker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class CompanyImplTest {
    //CompanyImpl company;
    Company company;
    Employee[] employees;

    @BeforeEach
    void setUp() {
        company = new CompanyImpl();
        employees = new Employee[]{
                new Engineer("John", 1985, 10, "Higher", 25.0, 160),
                new Engineer("Jane", 1990, 5, "Higher", 30.0, 150),
                new Worker("Bob", 1992, 3, "Secondary", 10.0, 180),
                new Worker("Alice", 1988, 8, "Higher", 15.0, 170)
        };
        for (int i = 0; i < employees.length; i++) {
            company.hireEmployee(employees[i]);
        }
    }

    @Test
    void testHireEmployee() {
        assertFalse(company.hireEmployee(employees[0])); // Попытка добавления сотрудника, который уже есть
        assertFalse(company.hireEmployee(null)); // Попытка добавления null
        assertEquals(4, company.getEmployeeCount()); // Проверка количества сотрудников
    }

    @Test
    void testFireEmployee() {
        System.out.println(company.getEmployeeCount());
        Employee hiredEmployee = company.fireEmployee("Bob");
        assertEquals("Bob", hiredEmployee.getName());
        System.out.println(company.getEmployeeCount());
    }

    @Test
    void testFindEmployee() {
        assertEquals(employees[1], company.findEmployee("Jane"));
    }

    @Test
    void testGetEmployeeCount() {
        assertEquals(4, company.getEmployeeCount());
    }

    @Test
    void testPrintEmployeeList() {
        company.printEmployeeList();
    }

    @Test
    void testGetEmployeesSortedByAge() {
        Employee[] sortedEmployees = company.getEmployeesSortedByAge();
        assertEquals("John", sortedEmployees[0].getName());
        assertEquals("Alice", sortedEmployees[1].getName());
        assertEquals("Jane", sortedEmployees[2].getName());
        assertEquals("Bob", sortedEmployees[3].getName());
    }

    @Test
    void
    testGetEmployeesSortedByExperience() {
        Employee[] sortedEmployees = company.getEmployeesSortedByExperience();

//        for (int i = 0; i < sortedEmployees.length; i++) {
//            System.out.println(sortedEmployees[i]);
//        }

       // company.printEmployeeList();

        company.printEmployeeArray(sortedEmployees);

        assertEquals("Bob", sortedEmployees[0].getName());
        assertEquals("Jane", sortedEmployees[1].getName());
        assertEquals("Alice", sortedEmployees[2].getName());
        assertEquals("John", sortedEmployees[3].getName());
    }

    @Test
    void testGetEmployeesSortedBySalary() {
        Employee[] sortedEmployees = company.getEmployeesSortedBySalary();
        assertEquals("Bob", sortedEmployees[3].getName());
        assertEquals("Alice", sortedEmployees[2].getName());
        assertEquals("John", sortedEmployees[1].getName());
        assertEquals("Jane", sortedEmployees[0].getName());

        for (Employee employee : sortedEmployees) {
            if (employee instanceof Worker) {
                Worker worker = (Worker) employee;
                System.out.println(worker.getName() + ": " + worker.calculateSalary() + " (Worker)");
            } else if (employee instanceof Engineer) {
                Engineer engineer = (Engineer) employee;
                System.out.println(engineer.getName() + ": " + engineer.calculateSalary() + " (Engineer)");
            } else {
                System.out.println(employee.getName());
            }
        }
    }

    @Test
    void testGetEmployeesSortedByEducation() {
        Employee[] sortedEmployees = company.getEmployeesSortedByEducation();

        assertEquals("Higher", sortedEmployees[0].getEducation());
        assertEquals("Higher", sortedEmployees[1].getEducation());
        assertEquals("Higher", sortedEmployees[2].getEducation());
        assertEquals("Secondary", sortedEmployees[3].getEducation());

        for (Employee employee : sortedEmployees) {
            if (employee instanceof Worker) {
                Worker worker = (Worker) employee;
                System.out.println(worker.getName() + ": " + worker.getEducation() + " (Worker)");
            } else if (employee instanceof Engineer) {
                Engineer engineer = (Engineer) employee;
                System.out.println(engineer.getName() + ": " + engineer.getEducation() + " (Engineer)");
            } else {
                System.out.println(employee.getName());
            }
        }
    }

    @Test
    void testFindEmployeesWithExperience() {
        int years = 5;
        Employee[] experiencedEmployees = company.findEmployeesWithExperience(years);

        for (Employee employee : experiencedEmployees) {
            assertTrue(employee.getExperience() > years);
            System.out.println("Employee: " + employee.getName() + ", Experience: " + employee.getExperience() + " years");
        }
    }

    @Test
    void testFindEmployeesWithSalary() {
        double amount = 2000.0;
        Employee[] lowSalaryEmployees = company.findEmployeesWithSalary(amount);

        for (Employee employee : lowSalaryEmployees) {
            double salary;
            if (employee instanceof Engineer) {
                salary = ((Engineer) employee).calculateSalary();
            } else {
                salary = ((Worker) employee).calculateSalary();
            }
            assertTrue(salary < amount);
            System.out.println("Employee: " + employee.getName() + ", Salary: " + salary + " euros");
        }
    }

    @Test
    void testFindEmployeesWithoutHigherEducation() {
        Employee[] nonHigherEducationEmployees = company.findEmployeesWithoutHigherEducation();

        for (Employee employee : nonHigherEducationEmployees) {
            assertFalse(employee.getEducation().equalsIgnoreCase("Higher"));
            System.out.println("Employee: " + employee.getName() + ", Education: " + employee.getEducation());
        }
    }

}