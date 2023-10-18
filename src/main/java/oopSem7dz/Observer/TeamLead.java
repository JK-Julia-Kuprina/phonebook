package oopSem7dz.Observer;

public class TeamLead implements Observer {

    private String name;
    private int salary = 200000;


    public TeamLead (String name) {
        this.name = name;
    }

    public void receiveOffer(Vacancy vacancy) {
        if (vacancy.getType() == Vacancy.Type.TeamLead) {
            if (this.salary <= vacancy.getSalary()) {
                System.out.printf("Тимлид %s: Мне нужна эта работа! (компания: %s; заработная плата: %d)\n",
                        name, vacancy, salary);
                this.salary = vacancy.getSalary;
                vacancy.closeVacancy();
            } else {
                System.out.printf("Тимлид %s: Я найду работу получше! (компания: %s; заработная плата: %d)\n",
                        name, vacancy, salary);
            }
        }

    }

    @Override
    public String toString() {
        return String.format("Тимлид %s, желаемая заработная плата %d", name,salary);
    }
}
