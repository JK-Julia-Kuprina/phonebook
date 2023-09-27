package oopSem1dz;

public class Product {

    protected String name;

    protected String brand;

    protected double price;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        if (brand == null || brand.length() < 3){
            this.brand  = "<Brand>";
        }
        else{
            this.brand = brand;
        }
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price < 100){
            this.price = 100;
        }
        else{
            this.price = price;
        }
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        checkName(name);
    }

    public Product(){
        this("<Product>");
    }

    public Product(String name){
        this(name, 100);
    }

    public Product(String name, double price){
        this("<Brand>", name, price);
    }

    public Product(String brand, String name, double price){
        if (brand == null || brand.length() < 3){
            this.brand  = "<Brand>";
        }
        else{
            this.brand = brand;
        }
        checkName(name);
        if (price < 100){
            this.price = 100;
        }
        else{
            this.price = price;
        }
    }

    private void checkName(String name){
        if (name == null || name.length() < 3){
            this.name  = "<Product>";
        }
        else{
            this.name = name;
        }
    }

    public String displayInfo(){
        return String.format("%s - %s - %.2f", brand, name, price);
    }

}

