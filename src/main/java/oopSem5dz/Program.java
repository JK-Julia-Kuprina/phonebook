package oopSem5dz;

import oopSem5dz.View.BookingView;
import oopSem5dz.models.TableModel;
import oopSem5dz.presenters.BookingPresenter;
import oopSem5dz.presenters.Model;
import oopSem5dz.presenters.View;

import java.util.Date;

public class Program {

    /**
     * TODO: ДОМАШНЯЯ РАБОТА
     *  метод changeReservationTable должен заработать!
     * @param args
     */
    public static void main(String[] args) {

        Model tableModel = new TableModel();
        View bookingView = new BookingView();
        BookingPresenter presenter = new BookingPresenter(tableModel, bookingView);
        presenter.updateUIShowTables();
        bookingView.reservationTable(new Date(), 2, "Станислав");

        tableModel.AllReservation();

        ((BookingView) bookingView).changeReservationTable(1001, new Date(), 3, "Станислав");
        tableModel.AllReservation();

        bookingView.reservationTable(new Date(), 5, "Юлия");
        tableModel.AllReservation();
    }
}
