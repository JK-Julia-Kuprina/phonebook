package oopSem5dz.presenters;

import oopSem5dz.models.Table;

import java.util.Collection;
import java.util.Date;

public class BookingPresenter implements ViewObserver {

    private Model model;
    private View view;
    private int oldReservationId;

    public BookingPresenter(Model model, View view) {
        this.model = model;
        this.view = view;
        view.setObserver(this);
    }

    /**
     * Получение списка всех столиков
     */
    private Collection<Table> loadTables(){
        return model.loadTables();
    }

    /**
     * Отобразить список столиков
     */
    public void updateUIShowTables(){
        view.showTables(loadTables());
    }

    /**
     * Отобразить результат бронирования на представлении
     * @param reservationId результат бронирования
     */
    private void updateUIShowReservationResult(int reservationId){
        view.showReservationTableResult(reservationId);
    }

    /**
     * Произошло событие, пользователь нажал на кнопку резерва столика
     * @param orderDate дата резерва
     * @param tableNo номер столика
     * @param name имя клиента
     */
    @Override
    public void onReservationTable(Date orderDate, int tableNo, String name) {
        try {
            int reservationNo = model.reservationTable(orderDate, tableNo, name);
            updateUIShowReservationResult(reservationNo);
        }
        catch (RuntimeException e){
            updateUIShowReservationResult(-1);
        }
    }

    @Override
    public void onChangeReservationTable(int oldReservationId, Date orderDate, int tableNo, String name) {
        try {
            int newReservationId = model.changeReservationTable(oldReservationId, orderDate, tableNo, name);
            updateUIShowChangeReservationResult(oldReservationId, newReservationId);
        }
        catch (RuntimeException e){
            updateUIShowReservationResult(-1);
        }
    }

    private void updateUIShowChangeReservationResult(int oldReservationId, int newReservationId) {
        this.oldReservationId = oldReservationId;
        view.showReservationTableResult(newReservationId);
    }
}
