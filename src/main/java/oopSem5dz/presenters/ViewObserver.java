package oopSem5dz.presenters;

import java.util.Date;

public interface ViewObserver {

    void onReservationTable(Date orderDate, int tableNo, String name);

    void onChangeReservationTable(int oldReservationNo, Date orderDate, int tableNo, String name);
}
