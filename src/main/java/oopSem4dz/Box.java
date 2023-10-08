package oopSem4dz;

import java.util.ArrayList;

public class Box <T extends Fruit> {
    private int name;
    private static int number = 1;

    {
        name = number;
        number++;
    }
    ArrayList<T> fruits;


    public Box(ArrayList<T> fruits) {
        this.fruits = fruits;
    }

    public float getWeight() {
        return fruits.size() * fruits.get(0).getWheight();
    }

    public T getOneFruit(int index) {
        if (index < fruits.size())
            return fruits.get(index);
        else
            return null;
    }

    public boolean compareBoxes(Box<T> fruits2) {
        if (getWeight() == fruits2.getWeight()) {
            return true;
        } else
            return false;
    }

    public void addFruits(T fruit) {
        if (fruits.get(0).getClass().isInstance(fruit))
            fruits.add(fruit);
        else
            System.out.println("Вы пытаетесь добавить другой тип фруктов.");
    }

    public void pureOverFruits(int quantity, Box<T> fruits2) {
        if (fruits.get(0).getClass().equals(fruits2.getOneFruit(0).getClass()) && fruits.size() >= quantity) {
            for (int i = 0; i < quantity; i++) {
                fruits2.addFruits(fruits.get(i));
                fruits.remove(i);
            }
        } else {
            System.out.println("Вы пытаетесь пересыпать другой тип фруктов или неверное количество.");
        }
    }

    @Override
    public String toString() {
        return String.format("Коробка № %d: %s, %d шт., общий вес: %.2f кг",
                name, fruits.get(0).getName(), fruits.size(), getWeight());
    }

}
