package l35hw.dao;

import l35hw.model.Employee;

public interface Company {
    boolean hireEmployee(Employee employee);
    Employee fireEmployee(String name);
    Employee findEmployee(String name);
    int getEmployeeCount();
    void printEmployeeList();

    Employee[] getEmployeesSortedByAge();

    Employee[] getEmployeesSortedByExperience();

    Employee[] getEmployeesSortedBySalary();

    Employee[] getEmployeesSortedByEducation();

    Employee[] findEmployeesWithExperience(int years);

    Employee[] findEmployeesWithSalary(double amount);

    Employee[] findEmployeesWithoutHigherEducation();
}
