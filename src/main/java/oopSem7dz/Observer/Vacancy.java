package oopSem7dz.Observer;

public class Vacancy {

    public int getSalary;

    public enum Type {
        Student,
        Master,
        TeamLead
    }

    private Type type;
    private boolean status = true;
    private static int counter;
    private int id;
    private String company;
    private int salary;

    {
        counter++;
        id = counter;
    }

    public Vacancy(Type type, int salary) {
        this.type = type;
        this.salary = salary;
    }

    public Vacancy(Type type, String company, int salary) {
        this(type, salary);
        this.company = company;
    }

    public void closeVacancy() {
        this.status = false;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Type getType() {
        return type;
    }

    public int getId() {
        return id;
    }

    public boolean getStatus() {
        return status;
    }

    public String getCompany() {
        return company;
    }

    public int getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        if (status)
            return String.format("Вакансия № %d \nтип вакансии: %s \nкомпания: %s \nзарплата: %d \n", id, type, company, salary);
        else
            return String.format("Вакансия закрыта.");
    }
}
