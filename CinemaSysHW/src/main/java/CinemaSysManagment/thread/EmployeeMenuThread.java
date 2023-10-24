package CinemaSysManagment.thread;

import CinemaSysManagment.dao.IEmployee;
import CinemaSysManagment.role.EmployeeMenu;

public class EmployeeMenuThread extends Thread {
    private IEmployee employee;

    public EmployeeMenuThread(IEmployee employee) {
        this.employee = employee;
    }

    @Override
    public void run() {
        EmployeeMenu employeeMenu = new EmployeeMenu(employee);
        if (employeeMenu.authenticate()) {
            employeeMenu.run();
        } else {
            System.out.println("Неверное имя пользователя или пароль.");
        }
    }
}
