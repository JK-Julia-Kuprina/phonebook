package dzSem6;

public class Laptop {
    private Brand brand;
    private Color color;
    private Price price;

    public Laptop(Brand brand, Color color, Price price) {
        this.brand = brand;
        this.color = color;
        this.price = price;
    }
    public Brand getBrand(){
        return brand;
    }
    public Color getColor(){
        return color;
    }
    public Price getPrice(){
        return price;
    }

    @Override
    public String toString() {
        return String.format("Laptop brand: %s, color: %s", brand, color, price);
    }
}
