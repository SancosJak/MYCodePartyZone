package CinemaSysManagment.thread;

import CinemaSysManagment.dao.ICustomer;
import CinemaSysManagment.role.ClientMenu;

public class ClientMenuThread extends Thread {
    private ICustomer customer;

    public ClientMenuThread(ICustomer customer) {
        this.customer = customer;
    }

    @Override
    public void run() {
        ClientMenu clientMenu = new ClientMenu(customer);
        if (clientMenu.authenticate()) {
            clientMenu.run();
        } else {
            System.out.println("Неверное имя пользователя или пароль.");
        }
    }
}
