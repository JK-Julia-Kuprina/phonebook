package oopSem2dz;

import java.util.ArrayList;

public class Program {
    public static void main(String[] args) {

        Cat cat1 = new Cat("Кокос",20);
        Cat cat2 = new Cat("Марк",25);
        Cat cat3 = new Cat("Люк", 35);
        Cat cat4 = new Cat("Зара", 15);
        Cat cat5 = new Cat("Лиса", 10);

        ArrayList<Cat> cats = new ArrayList<>();
        cats.add(cat1);
        cats.add(cat2);
        cats.add(cat3);
        cats.add(cat4);
        cats.add(cat5);

        Plate plate = new Plate(100);

        for (Cat cat : cats) {
            boolean isEaten = cat.eat(plate);
            if (!isEaten) {
                cat.eat(plate);
            }
        }

        plate.info();

        if (plate.getFood() < 10) {
            plate.addFood(100);
        }
            for (Cat cat : cats) {
                boolean isEaten = cat.eat(plate);
            if (!isEaten) {
                cat.eat(plate);
            }
        }
        plate.info();
    }

}
