package practice.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import practice.dao.Company;
import practice.dao.CompanyImpl;
import practice.model.Employee;
import practice.model.Manager;
import practice.model.SalesManager;
import practice.model.Worker;

import static org.junit.jupiter.api.Assertions.*;

class CompanyImplTest {
    Company company; // создали обьект класса Company
    Employee[] firm;

    @BeforeEach
    void setUp() {
        company = new CompanyImpl();
        firm = new Employee[4];
        firm[0] = new Manager(100, "Jhon", "Smith", 174, 5000, 5);
        firm[1] = new SalesManager(101, "Bread", "Pit", 174, 300000, 0.1);
        firm[2] = new SalesManager(102, "Julia", "Roberts", 174, 300000, 0.1);
        firm[3] = new Worker(103, "Robert", "Douny Jr.", 80, 20);

        for (int i = 0; i < firm.length; i++) {
            company.addEmployee(firm[i]);
        }
    }

    @Test
    void addEmployee() {
    }

    @Test
    void removeEmployee() {
    }

    @Test
    void findEmployee() {
    }

    @Test
    void size() {
    }

    @Test
    void printEmployee() {
    }
}