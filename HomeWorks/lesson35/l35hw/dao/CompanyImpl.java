package l35hw.dao;

import l35hw.model.Employee;
import l35hw.model.Engineer;
import l35hw.model.Worker;

import java.util.Arrays;
import java.util.Collections;

public class CompanyImpl implements Company {
    private static final int MAX_EMPLOYEES = 100; // Maximum number of employees
    private final Employee[] employees;
    private int employeeCount;

    public CompanyImpl() {
        employees = new Employee[MAX_EMPLOYEES];
        employeeCount = 0;
    }

    @Override
    public boolean hireEmployee(Employee employee) {
        if (employee == null || employeeCount == employees.length || findEmployee(employee.getName()) != null) {
            return false;
        }
        employees[employeeCount] = employee;
        employeeCount++;
        return true;
    }
    public Employee fireEmployee(String name)  {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getName().equals(name)) {
                Employee victim = employees[i];
                employees[i] = employees[employeeCount - 1];
                employees[employeeCount - 1] = null;
                employeeCount--;
                return victim;
            }
        }
        return null;
    }

    @Override
    public Employee findEmployee(String name) {
        for (int i = 0; i < employeeCount; i++) {
            if (employees[i].getName().equals(name)) {
                return employees[i];
            }
        }
        return null;
    }

    @Override
    public int getEmployeeCount() {
        return employeeCount;
    }

    @Override
    public void printEmployeeList() {
        System.out.println("Employee List:");
        for (int i = 0; i < employeeCount; i++) {
            System.out.println(employees[i]);
        }
    }
    public Employee[] getEmployeesSortedByAge() {
        Employee[] sortedArray = Arrays.copyOf(employees, employeeCount);
        Arrays.sort(sortedArray, new EmployeeComparators.AgeComparator());
        return sortedArray;
    }

    public Employee[] getEmployeesSortedByExperience() {
        Employee[] sortedArray = Arrays.copyOf(employees, employeeCount);
        Arrays.sort(sortedArray, new EmployeeComparators.ExperienceComparator());
        return sortedArray;
    }

    //Collections.reverseOrder() to reverse sort employees by salary.
    public Employee[] getEmployeesSortedBySalary() {
        Employee[] sortedArray = Arrays.copyOf(employees, employeeCount);
        Arrays.sort(sortedArray, Collections.reverseOrder(new EmployeeComparators.SalaryComparator()));
        return sortedArray;
    }

    public Employee[] getEmployeesSortedByEducation() {
        Employee[] sortedArray = Arrays.copyOf(employees, employeeCount);
        Arrays.sort(sortedArray, new EmployeeComparators.EducationComparator());
        return sortedArray;
    }
   // Implementation of the method for finding employees with more than 5 years of experience
    public Employee[] findEmployeesWithExperience(int years) {
        Employee[] result = new Employee[employeeCount];
        int resultCount = 0;

        for (int i = 0; i < employeeCount; i++) {
            if (employees[i].getExperience() > years) {
                result[resultCount] = employees[i];
                resultCount++;
            }
        }
        return Arrays.copyOf(result, resultCount);
    }

    //Implementation of the method for finding employees with a salary of less than 2000 euros
    public Employee[] findEmployeesWithSalary(double amount) {
        Employee[] result = new Employee[employeeCount];
        int resultCount = 0;

        for (int i = 0; i < employeeCount; i++) {
            double salary;
            if (employees[i] instanceof Engineer) {
                salary = ((Engineer) employees[i]).calculateSalary();
            } else {
                salary = ((Worker) employees[i]).calculateSalary();
            }
            if (salary < amount) {
                result[resultCount] = employees[i];
                resultCount++;
            }
        }
        return Arrays.copyOf(result, resultCount);
    }

    //Implementation of the method for finding employees without higher education
    public Employee[] findEmployeesWithoutHigherEducation() {
        Employee[] result = new Employee[employeeCount];
        int resultCount = 0;

        for (int i = 0; i < employeeCount; i++) {
            if (!employees[i].getEducation().equalsIgnoreCase("higher")) {
                result[resultCount] = employees[i];
                resultCount++;
            }
        }
        return Arrays.copyOf(result, resultCount);
    }

}
