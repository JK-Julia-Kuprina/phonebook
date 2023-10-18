package oopSem7dz.Observer;

public class Program {

    /**
     *  TODO: Доработать приложение, которое разрабатывалось на семинаре, поработать с шаблоном проектирования Observer,
     *  добавить новый тип соискателя.
     *  Добавить новую сущность "Вакансия", компания должна рассылать вакансии.
     *  Только после этого вы можете усложнить ваше приложение (при желании), например, добавить тип вакансии (enum),
     *  учитывать тип вакансии при отправке предложения соискателю.
     * @param args
     */

    public static void main(String[] args) {

        Publisher jobAgency = new JobAgency();
        Company google = new Company("Google", jobAgency, 120000);
        Company yandex = new Company("Yandex", jobAgency, 95000);
        Company geekBrains = new Company("GeekBrains", jobAgency, 98000);

        Student student1 = new Student("Иванов");
        Master master1 = new Master("Петров");
        Master master2 = new Master("Сидоров");
        TeamLead teamLead1 = new TeamLead("Главный");
        Student student2 = new Student("Круглов");

        jobAgency.registerObserver(student1);
        jobAgency.registerObserver(master1);
        jobAgency.registerObserver(master2);
        jobAgency.registerObserver(teamLead1);
        jobAgency.registerObserver(student2);

        System.out.println("Вакансии готовы к рассылке:");

        for (int i = 0; i < 5; i++){
            google.needEmployee(Vacancy.Type.TeamLead);
            yandex.needEmployee(Vacancy.Type.Master);
            geekBrains.needEmployee(Vacancy.Type.Student);
        }

        System.out.println("\n\nВсе активные вакансии:");
        jobAgency.allActiveVacancies();

        System.out.println("Все соискатели:");
        jobAgency.allObservers();

    }
}
