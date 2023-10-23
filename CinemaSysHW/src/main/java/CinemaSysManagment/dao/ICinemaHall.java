package CinemaSysManagment.dao;

import CinemaSysManagment.model.CinemaHall;

/**
 * Интерфейс ICinemaHall предоставляет контракт для класса, представляющего кинозал в системе управления кинотеатром.
 */
public interface ICinemaHall {

    /**
     * Получить номер кинозала.
     *
     * @return Номер кинозала.
     */
    int getHallNumber();

    /**
     * Установить новый номер кинозала.
     *
     * @param hallNumber Новый номер кинозала.
     */
    void setHallNumber(int hallNumber);

    /**
     * Получить вместимость кинозала.
     *
     * @return Вместимость кинозала.
     */
    int getCapacity();

    /**
     * Установить новую вместимость кинозала.
     *
     * @param capacity Новая вместимость кинозала.
     */
    void setCapacity(int capacity);

    void setHallType();

    /**
     * Получить тип кинозала.
     *
     * @return Тип кинозала (например, 2D, 3D, IMAX).
     */
    CinemaHall.HallType getHallType();

    /**
     * Установить новый тип кинозала.
     *
     * @param hallType Новый тип кинозала.
     */
    void setHallType(CinemaHall.HallType hallType);
    void decreaseCapacity(int amount);
    void increaseCapacity(int amount);
    int getNumRows();
    int getSeatsPerRow();
}
