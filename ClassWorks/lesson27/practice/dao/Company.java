package practice.dao;

import practice.model.Employee;

public interface Company {
    // перечень действий = методов

    boolean addEmployee(Employee employee); //берем на роботу
    Employee removeEmployee(int id); // удаляем сотрудника из компании увольнение
    Employee findEmployee(int id); // ищем сотруднка в компании по id
    int size(); // размер компании
    void printEmployees(); // печатаем спсок компании


}
