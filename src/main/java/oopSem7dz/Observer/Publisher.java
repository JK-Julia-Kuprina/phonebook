package oopSem7dz.Observer;

public interface Publisher {

    void sendOffer(Vacancy vacancy);

    void registerObserver(Observer observer);
    void removeObserver(Observer observer);

    void allActiveVacancies();

    void allObservers();
}
