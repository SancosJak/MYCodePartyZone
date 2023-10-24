package CinemaSysManagment.thread;

import CinemaSysManagment.dao.ICustomer;
import CinemaSysManagment.dao.IEmployee;
import CinemaSysManagment.model.Customer;
import CinemaSysManagment.model.Employee;

public class CinemaManagementThreadApp {

    public static void main(String[] args) {

        IEmployee employee = new Employee("employeeName", "employeePassword", "employeePosition", "employeeFirstName", "employeeLastName", "employeeContactInfo");
        ICustomer customer = new Customer("clientName", "clientPassword");

        Thread employeeThread = new EmployeeMenuThread(employee);
        Thread clientThread = new ClientMenuThread(customer);

        employeeThread.start();
        try {
            employeeThread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        clientThread.start();
    }
}
