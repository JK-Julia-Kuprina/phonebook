package oopSem1dz;

import java.util.List;

public class VendingMachine {

    private List<Product> products;

    public VendingMachine(List<Product> products){
        this.products = products;
    }
    public BottleOfMilk getBottleOfMilk(String name, int volume) {
        for (Product product : products){
            if (product instanceof BottleOfMilk){
                BottleOfMilk bottleOfMilk = (BottleOfMilk)product;
                if (bottleOfMilk.getName().equals(name) && bottleOfMilk.getVolume() == volume)
                    return bottleOfMilk;
            }
        }
        return null;
    }

    public Chips getChips(String name, int weight) {
        for (Product product : products){
            if (product instanceof Chips){
                Chips chips = (Chips)product;
                if (chips.getName().equals(name) && chips.getWeight() == weight)
                    return chips;
            }
        }
        return null;
    }
}
