package CinemaSysManagment.model;

import CinemaSysManagment.dao.IEmployee;
import CinemaSysManagment.dao.ISession;

import java.util.ArrayList;
import java.util.List;

public class Employee implements IEmployee {

    private static final int MAX_MANAGED_SESSIONS = 10;
    private String username;
    private String password;
    private String position;
    private List<ISession> managedSessions;

    public Employee(String username, String password, String position) {
        this.username = username;
        this.password = password;
        this.position = position;
        this.managedSessions = new ArrayList<>();
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String getPosition() {
        return position;
    }

    @Override
    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public List<ISession> getManagedSessions() {
        return managedSessions;
    }

    @Override
    public void addManagedSession(ISession session) throws YourCustomException {
        // Проверка на максимальное количество управляемых сеансов
        if (managedSessions.size() >= MAX_MANAGED_SESSIONS) {
            throw new YourCustomException("Достигнуто максимальное количество управляемых сеансов.");
        }

        // реализация добавления сеанса к управляемым сеансам
        managedSessions.add(session);
    }

    @Override
    public void removeManagedSession(ISession session) {
        //  реализация удаления сеанса из управляемых сеансов
        managedSessions.remove(session);
    }
}