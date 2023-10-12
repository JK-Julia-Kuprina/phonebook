package oopSem5dz.presenters;

import oopSem5dz.models.Table;

import java.util.Collection;
import java.util.Date;

public interface View {

    /**
     * Отображение списка столиков в приложении
     * @param tables список столиков
     */
    void showTables(Collection<Table> tables);

    /**
     * Отобразить результат бронирования столика
     * @param reservationId номер брони
     */
    void showReservationTableResult(int reservationId);



    /**
     * Действие клиента (пользователь нажал на кнопку бронирования), бронирование столика
     * @param orderDate дата бронирования
     * @param tableNo номер столика
     * @param name Имя
     */
    void reservationTable(Date orderDate, int tableNo, String name);

    /**
     * @param oldReservationId старая бронь
     * @param newReservationId новая бронь
     */
    void showChangeReservationResult(int oldReservationId, int newReservationId);

    /**
     * @param oldReservation старый номер столика
     * @param orderDate дата заказа
     * @param tableNo новый столик
     * @param name Имя
     */
    void changeReservationTable(int oldReservation, Date orderDate, int tableNo, String name);
    /**
     * Установить наблюдателя для представления
     * @param observer наблюдатель
     */
    void setObserver(ViewObserver observer);

}
