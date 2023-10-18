package oopSem7dz.Observer;

public class Student implements Observer {

    private String name;
    private int salary = 2000;


    public Student(String name) {
        this.name = name;
    }

    public void receiveOffer(Vacancy vacancy) {
        if (vacancy.getType() == Vacancy.Type.Student) {
            if (this.salary <= vacancy.getSalary()) {
                System.out.printf("Студент %s: Мне нужна эта работа! (компания: %s; заработная плата: %d)\n",
                        name, vacancy, salary);
                this.salary = vacancy.getSalary;
                vacancy.closeVacancy();
            } else {
                System.out.printf("Студент %s: Я найду работу получше! (компания: %s; заработная плата: %d)\n",
                        name, vacancy, salary);
            }
        }

    }

    @Override
    public String toString() {
        return String.format("Студент %s, желаемая заработная плата %d", name,salary);
    }
}
