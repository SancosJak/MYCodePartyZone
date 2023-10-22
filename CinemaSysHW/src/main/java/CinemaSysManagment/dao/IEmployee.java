package CinemaSysManagment.dao;

import CinemaSysManagment.model.YourCustomException;

import java.util.List;

/**
 * Интерфейс IEmployee предоставляет контракт для класса, представляющего сотрудника в системе управления кинотеатром.
 */
public interface IEmployee extends IUser {

    /**
     * Получить должность сотрудника.
     *
     * @return Должность сотрудника.
     */
    String getPosition();

    /**
     * Установить новую должность сотруднику.
     *
     * @param position Новая должность сотрудника.
     */
    void setPosition(String position);

    /**
     * Получить список сеансов, за которые сотрудник отвечает.
     *
     * @return Список сеансов.
     */
    List<ISession> getManagedSessions();

    /**
     * Добавить сеанс, за который сотрудник будет отвечать.
     *
     * @param session Сеанс, за который сотрудник будет отвечать.
     *
     * @throws YourCustomException Этот метод должен обрабатывать собственные исключения,
     * например, когда сотрудник уже отвечает за максимальное количество сеансов.
     * Студенты должны создать свой собственный класс исключения и обработать его соответствующим образом.
     */
    void addManagedSession(ISession session) throws YourCustomException;

    /**
     * Удалить сеанс, за который сотрудник отвечает.
     *
     * @param session Сеанс, за который сотрудник перестает отвечать.
     */
    void removeManagedSession(ISession session);

    String getFirstName();

    void setFirstName(String firstName);

    String getLastName();

    void setLastName(String lastName);

    String getContactInfo();

    void setContactInfo(String contactInfo);
}