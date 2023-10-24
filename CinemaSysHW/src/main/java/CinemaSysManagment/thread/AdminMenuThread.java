package CinemaSysManagment.thread;

import CinemaSysManagment.role.AdminMenu;

public class AdminMenuThread extends Thread {
    @Override
    public void run() {
        AdminMenu adminMenu = new AdminMenu();
        if (adminMenu.authenticate()) {
            adminMenu.run();
        } else {
            System.out.println("Неверное имя пользователя или пароль.");
        }
    }
}