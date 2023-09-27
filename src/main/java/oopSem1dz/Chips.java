package oopSem1dz;

public class Chips extends Product {

    private int fat;
    private int weight;

    public int getFat() {
        return fat;
    }

    public void setFat(int fat) {
        this.fat = fat;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Chips (String name, String brand, double price, int fat, int weight) {
        super(name, brand, price);
        this.weight = weight;
        this.fat = fat;
    }

    @Override
    public String displayInfo() {
        return String.format("[ЧИПСЫ] %s - %s - %.2f - жиры: %d - вес: %d", brand, name, price, fat, weight);
    }
}
