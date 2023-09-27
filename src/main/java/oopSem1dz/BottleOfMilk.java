package oopSem1dz;

public class BottleOfMilk extends Product {

    private int volume;

    private int fat;

    public int getVolume() {return volume; }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public int getFat() {
        return fat;
    }

    public void setFat(int fat) {
        this.fat = fat;
    }

    public BottleOfMilk (String name, String brand, double price, int volume, int fat) {
        super(name, brand, price);
        this.volume = volume;
        this.fat = fat;
    }

    @Override
    public String displayInfo() {
        return String.format("[МОЛОКО] %s - %s - %.2f - объем: %d - жирность: %d", brand, name, price, volume, fat);
    }
}
