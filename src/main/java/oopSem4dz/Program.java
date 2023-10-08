package oopSem4dz;

//a. Даны классы Fruit, Apple extends Fruit, Orange extends Fruit;
//b. Класс Box, в который можно складывать фрукты. Коробки условно сортируются по типу фрукта,
//   поэтому в одну коробку нельзя сложить и яблоки, и апельсины;
//c. Для хранения фруктов внутри коробки можно использовать ArrayList;
//d. Сделать метод getWeight(), который высчитывает вес коробки, зная вес одного фрукта и их количество:
//   вес яблока – 1.0f, апельсина – 1.5f (единицы измерения не важны);
//e. Внутри класса Box сделать метод compare(), который позволяет сравнить текущую коробку с той, которую
//   подадут в compare() в качестве параметра. true – если их массы равны, false в противоположном случае.
//   Можно сравнивать коробки с яблоками и апельсинами;
//f. Написать метод, который позволяет пересыпать фрукты из текущей коробки в другую.
//   Помним про сортировку фруктов: нельзя яблоки высыпать в коробку с апельсинами.
//   Соответственно, в текущей коробке фруктов не остается, а в другую перекидываются объекты, которые были в первой;
//g. Не забываем про метод добавления фрукта в коробку.

import java.util.ArrayList;
import java.util.Random;

public class Program {

    public static void main(String[] args) {
        Random random = new Random();

        ArrayList<Box> boxes = new ArrayList<>();

        for (int i = 0; i < random.nextInt(10, 20); i++) {
            boolean typeOfFruit = random.nextBoolean();

            if (typeOfFruit) {
                ArrayList<Apple> apples = new ArrayList<>();
                for (int j = 0; j < random.nextInt(1, 20); j++) {
                    apples.add(new Apple());
                }
                Box<Apple> appleBox = new Box<>(apples);
                boxes.add(appleBox);
            } else {
                ArrayList<Orange> oranges = new ArrayList<>();
                for (int k = 0; k < random.nextInt(1, 20); k++) {
                    oranges.add(new Orange());
                }
                Box<Orange> orangeBox = new Box<>(oranges);
                boxes.add(orangeBox);
            }
        }
        for (Box box : boxes) {
            System.out.println(box);
        }
        System.out.println("\nСравнили коробоки:");
        System.out.println(boxes.get(0).compareBoxes(boxes.get(1)));

        System.out.println("\nДобавили фрукт в коробку:");
        boxes.get(0).addFruits(new Orange());
        System.out.println(boxes.get(0));

        System.out.println("\nПересыпали фрукт из коробки в коробку:");
        boxes.get(0).pureOverFruits(2, boxes.get(1));
        System.out.println(boxes.get(0) + " была пересыпана в " + boxes.get(1));

    }



}
