package oopSem1dz;

public class BottleOfWater extends Product {

    private  int volume; // объем

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public BottleOfWater(String brand, String name, double price, int volume, int fat) {
        super(brand, name, price);
        this.volume = volume;
    }

    @Override
    public String displayInfo() {
        return String.format("[ВОДА] %s - %s - %.2f - объем: %d",
                brand, name, price, volume);
    }

}
