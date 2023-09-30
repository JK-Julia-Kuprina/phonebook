package oopSem2dz;

public class Plate {
    private int food;
    public Plate(int food) {
        this.food = food;
    }

    public int getFood() {
        return food;
    }

    public void setFood(int food) {
        if (food <=0) {
            this.food = 0;
        }
        else {
            this.food = food;
        }
    }

    public void info() {
        System.out.printf("Остаток еды в тарелке %d: \n ", food);
    }

    public boolean addFood(int food) {
        this.food += food;
        return false;
    }

//    @Override
//    public String toString() {
//        return String.format("Остаток еды в тарелке: %d");
//    }
}
