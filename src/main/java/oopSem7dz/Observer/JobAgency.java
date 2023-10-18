package oopSem7dz.Observer;

import java.util.ArrayList;
import java.util.List;

public class JobAgency implements Publisher{

    List<Observer> observers = new ArrayList<>();
    List<Vacancy> vacancies = new ArrayList<>();


    public void sendOffer(Vacancy vacancy) {
        vacancies.add(vacancy);
        for (Observer observer : observers){
            observer.receiveOffer(vacancy);
            if (vacancy.getStatus()==false) {
                removeObserver(observer);
                break;
            }
        }
    }

    public void allActiveVacancies(){
        for (Vacancy vacancy: vacancies) {
            if (vacancy.getStatus()) {
                System.out.println(vacancy);
            }
        }
    }

    @Override
    public void allObservers() {
        for (Observer observer : observers) {
            System.out.println(observer);
        }
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }
}
