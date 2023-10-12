package oopSem5dz.models;

import oopSem5dz.presenters.Model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public class TableModel implements Model {

    private Collection<Table> tables;

    public void AllReservation(){
        for (Table table: loadTables()) {
            Collection<Reservation> reservations = table.getReservations();
            if (reservations.size() > 0)
                System.out.println(reservations);
        }
    }

    /**
     * Получение списка всех столиков
     */
    @Override
    public Collection<Table> loadTables() {

        if (tables == null){
            tables = new ArrayList<>();

            tables.add(new Table());
            tables.add(new Table());
            tables.add(new Table());
            tables.add(new Table());
            tables.add(new Table());
        }

        return tables;
    }

    /**
     * Бронирование столика
     * @param reservationDate Дата бронирования
     * @param name Имя
     */

    @Override
    public int reservationTable(Date reservationDate, int tableNo, String name) {
        for (Table table: loadTables()) {
            if (table.getNo() == tableNo){
                Reservation reservation = new Reservation(reservationDate, name);
                table.getReservations().add(reservation);
                return reservation.getId();
            }
        }
        throw  new RuntimeException("Некорректный номер столика.");
    }

    /**
     * @param reservationId отмена бронирования столика
     * @return
     */
    private boolean cancelReservation(int reservationId){
        for (Table table: loadTables()) {
            Collection<Reservation> reservations = table.getReservations();

            for (Reservation reservation: reservations) {
                if (reservation.getId() == reservationId) {
                    reservations.remove(reservation);
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * TODO: Доработать в рамках домашней работы
     * Отменить бронирование по номеру
     * @param oldReservation старый номер брони
     * @param orderDate дата новой
     * @param tableNo номер
     * @param name имя
     * @return
     */


    public int changeReservationTable(int oldReservation, Date orderDate, int tableNo, String name) {
        for (Table table : tables) {
            for (Reservation reservation : table.getReservations()) {
                if (reservation.getId() == oldReservation) {
                    table.getReservations().remove(reservation);
                    return reservationTable(orderDate, tableNo, name);
                }
            }
        }
        throw new RuntimeException("Некорректный номер брони столика.");
    }


}