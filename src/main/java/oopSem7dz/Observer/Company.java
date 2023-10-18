package oopSem7dz.Observer;

import java.util.Random;

public class Company {

    private Random random = new Random();

    private String nameCompany;

    private int maxSalary;

    private Publisher jobAgency;



    public Company(String nameCompany, Publisher jobAgency, int maxSalary) {
        this.nameCompany = nameCompany;
        this.maxSalary = maxSalary;
        this.jobAgency = jobAgency;
    }


    public void needEmployee(Vacancy.Type type) {
        int salary = 0;
        switch (type) {
            case Student:
                salary = random.nextInt(2000, maxSalary);
                break;
            case Master:
                salary = random.nextInt(60000, maxSalary);
                break;
            case TeamLead:
                salary = random.nextInt(150000, maxSalary);
                break;
            default:
                break;
        }
        Vacancy vacancy = new Vacancy(type, nameCompany, salary);
        jobAgency.sendOffer(vacancy);
    }

}
