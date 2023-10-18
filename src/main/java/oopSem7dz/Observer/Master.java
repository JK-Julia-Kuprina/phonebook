package oopSem7dz.Observer;

public class Master implements Observer {

    protected String name;
    protected int salary;


    public Master(String name) {
        this.name = name;
        salary = 80000;
    }


    @Override
    public void receiveOffer(Vacancy vacancy) {
        if (vacancy.getType() == Vacancy.Type.Master) {
            if (this.salary <= vacancy.getSalary()) {
                System.out.printf("Специалист %s: Мне нужна эта работа! (компания: %s; заработная плата: %d)\n",
                        name, vacancy, salary);
                this.salary = vacancy.getSalary;
                vacancy.closeVacancy();
            } else {
                System.out.printf("Специалист %s: Я найду работу получше! (компания: %s; заработная плата: %d)\n",
                        name, vacancy, salary);
            }
        }

    }

    @Override
    public String toString() {
        return String.format("Мастер %s, желаемая заработная плата %d", name,salary);
    }
}
