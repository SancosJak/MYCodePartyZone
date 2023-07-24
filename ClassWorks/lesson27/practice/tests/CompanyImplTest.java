package practice.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import practice.dao.Company;
import practice.dao.CompanyImpl;
import practice.model.Employee;
import practice.model.Manager;
import practice.model.SalesManager;
import practice.model.WageEmployee;

import static org.junit.jupiter.api.Assertions.*;


public class CompanyImplTest {

    Company company; // мы создали объект класса Company
    Employee[] firma;

    @BeforeEach
    void setUp() {
        company = new CompanyImpl(8);
        firma = new Employee[8]; // пытаемся добавить существующего
        firma[0] = new Manager(100, "John","Smith",174,5000,5);
        firma[1] = new SalesManager(101, "Bread", "Pitt", 174, 300000, 0.1);
        firma[2] = new SalesManager(102, "Julia", "Roberts", 174, 300000, 0.1);
        firma[3] = new WageEmployee(103, "Robert", "Douny Jr.", 80,20 );
        firma[4] = new WageEmployee(104, "Peter", "Petrov", 90,25 );
        firma[5] = new WageEmployee(105, "Vovka", "Vovkovi4", 95,30 );
        firma[6] = new WageEmployee(106, "Vovk", "Vovkovi4", 95,30 );
        firma[7] = new WageEmployee(107, "Vovk", "Vovkovi4", 95,30 );
    }

    @Test
    void testAddEmployee() {
        assertFalse(company.addEmployee(null)); // нельзя добавить “пустого” сотрудника
        assertTrue(company.addEmployee(firma[0])); // можно добавить сотрудника
        assertTrue(company.addEmployee(firma[1])); // можно добавить сотрудника
        assertTrue(company.addEmployee(firma[2])); // можно добавить сотрудника
        assertTrue(company.addEmployee(firma[3])); // можно добавить сотрудника
        assertEquals(4, company.size());
        Employee employee = new SalesManager(106, "Peter", "Petrov", 180, 40000, 0.1);
        assertTrue(company.addEmployee(employee));
        assertEquals(5, company.size());
        assertFalse(company.addEmployee(firma[3]));// нельзя добавить уже имеющегося сотрудник
        employee = new SalesManager(106, "Vasia", "Ivanov", 180, 40000, 0.1);
        assertFalse(company.addEmployee(employee)); //нельзя выйти за размер компании
    }
    @Test
    void testRemoveEmployee() {
        assertTrue(company.addEmployee(firma[0]));
        assertTrue(company.addEmployee(firma[1]));
        int initialSize = company.size();
        Employee removedEmployee = company.removeEmployee(firma[0].getId());
        assertNotNull(removedEmployee); // Проверяем, что удаленный сотрудник не равен null
        assertEquals(initialSize - 1, company.size()); // Проверяем уменьшение размера компании после удаления
        assertNull(company.findEmployee(firma[0].getId())); // Проверяем, что удаленный сотрудник больше не найден в компании
    }
    @Test
    void testFindEmployee() {
        for (Employee employee : firma) {
            company.addEmployee(employee);
        }
        Employee foundEmployee = company.findEmployee(firma[2].getId());
        assertNotNull(foundEmployee); // Проверяем, что найденный сотрудник не равен null
        assertEquals(firma[2].getId(), foundEmployee.getId()); // Проверяем, что найденный сотрудник имеет правильный ID
    }

    @Test
    void testSize() {
        assertEquals(0, company.size());
        company.addEmployee(firma[0]);
        assertEquals(1, company.size());
        company.addEmployee(firma[1]);
        company.addEmployee(firma[2]);
        assertEquals(3, company.size());
    }
    @Test
    void testPrintEmployees() {
        for (Employee employee : firma) {
            company.addEmployee(employee);
        }
        // В данном тесте, мы просто проверяем, что метод не вызывает исключение и выполняется успешно
        assertDoesNotThrow(() -> company.printEmployees());
    }

}