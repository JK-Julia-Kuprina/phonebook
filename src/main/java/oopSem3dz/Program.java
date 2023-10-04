package oopSem3dz;

import java.util.Arrays;
import java.util.Random;

public class Program {
    private static Random random = new Random();

    static Employee generateEmployee() {
        String[] names = new String[] {"Анатолий", "Глеб", "Клим", "Мартин", "Лазарь", "Владлен"};
        String[] surNames = new String[] {"Григорьев", "Фокин", "Шестаков", "Хохлов", "Шубин", "Бирюков"};

        String surName = surNames[(random.nextInt(surNames.length))];
        String name = names[(random.nextInt(names.length))];

        int salary = random.nextInt(50000, 120000);
        int salaryFree = random.nextInt(1000, 20000);

        int age = random.nextInt(25, 60);

        int employeeType = random.nextInt(2);

        if (employeeType == 0) {
            return new Freelancer(surName, name, salaryFree, age);
        }
        else {
            return new Worker(surName, name, salary, age);
        }

    }

    static Employee[] generateEmployees(int count){
        Employee[] array = new Employee[count];
        for (int i = 0; i < array.length; i++)
            array[i] = generateEmployee();
        return array;
    }

    public static void main(String[] args) {

        Employee[] employees = generateEmployees(15);

        Arrays.sort(employees, new AgeComparator(SortType.Ascending));

//        Arrays.sort(employees, new SalaryComparator(SortType.Ascending));

        for (Employee employee: employees) {
            System.out.println(employee);
        }

        System.out.println();

        Arrays.sort(employees, new AgeComparator(SortType.Descending));

//        Arrays.sort(employees, new SalaryComparator(SortType.Descending));

        for (Employee employee: employees) {
            System.out.println(employee);
        }
    }
}
