package practice.dao;

import practice.model.Employee;

public class CompanyImpl implements Company {

    Employee[] employees;

    int size;
    public CompanyImpl(int capacity) {
        employees = new Employee[capacity]; // Создаем пустой массив сотрудников
    }


    @Override
    public boolean addEmployee(Employee employee) {
        if (employee == null || size == employees.length || findEmployee(employee.getId()) != null) {
            return false;
        }
        employees[size] = employee;
        size++;
        return true;
    }

    @Override
    public Employee removeEmployee(int id) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getId() == id) {
                Employee removedEmployee = employees[i];
                // Сдвигаем оставшихся сотрудников влево для удаления пустой ячейки
                for (int j = i; j < size - 1; j++) {
                    employees[j] = employees[j + 1];
                }
                employees[size - 1] = null; // Очищаем последний элемент, так как он был дублирован
                size--; // Уменьшаем размер компании после удаления
                return removedEmployee;
            }
        }
        return null; // Возвращаем null, если сотрудник с заданным ID не был найден
    }
    @Override
    public Employee findEmployee(int id) {
        for (int i = 0; i < size(); i++) {
            if (employees[i].getId() == id) {
                return employees[i];
            }
        }
        return null;
    }
    @Override
    public int size() {
        return size;
    }

    @Override
    public void printEmployees() {
        for (int i = 0; i < size; i++) {
            printEmployee(employees[i]);
        }
    }

    private void printEmployee(Employee employee) {
        if (employee != null) {
            System.out.println("Employee ID: " + employee.getId());
            System.out.println("Employee Name: " + employee.getFirstName() + " " + employee.getLastName());
            System.out.println("Employee Salary: " + employee.calcSalary());
            System.out.println();
        } else {
            System.out.println("Employee not found.");
        }
    }

}