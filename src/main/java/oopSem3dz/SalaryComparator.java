package oopSem3dz;

import java.util.Comparator;

public class SalaryComparator implements Comparator<Employee> {

    private SortType sortType;

    public SortType getSortType() {
        return sortType;
    }

    public void setSortType(SortType sortType) {
        this.sortType = sortType;
    }

    public SalaryComparator(SortType sortType) {
        this.sortType = sortType;
    }

    @Override
    public int compare(Employee o1, Employee o2) {

        if (sortType == SortType.Ascending){
            return Double.compare(o1.calculateSalary(), o2.calculateSalary());
        }
        else {
            return Double.compare(o2.calculateSalary(), o1.calculateSalary());
        }

    }


}
