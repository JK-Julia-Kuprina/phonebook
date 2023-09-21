//Реализуйте структуру телефонной книги с помощью Map, учитывая, что 1 человек может
// иметь несколько телефонов и у человека уникальное имя. Поработать с методами Map.
//Отсортировать Map в обратном порядке.
package org.example;

import java.util.*;

public class Phonebook {
    public static void main(String[] args) {
        Map<String, ArrayList<Integer>> bookPhone = new HashMap<>();
        addNumber("Васильков", 11111, bookPhone);
        addNumber("Пион", 22222, bookPhone);
        addNumber("Вереск", 33333, bookPhone);
        addNumber("Амарелис", 44444, bookPhone);
        addNumber("Вереск", 22322, bookPhone);
        addNumber("Шиповников", 55555, bookPhone);
        addNumber("Вереск", 33733, bookPhone);
        addNumber("Вереск", 334133, bookPhone);
        addNumber("Пион", 334933, bookPhone);

        System.out.println(bookPhone);

        printMapSortedByName(bookPhone);

        printMapSortedByPhonesQuantity(bookPhone);
    }
    public static void addNumber(String key, int value, Map<String, ArrayList<Integer>> map) {
        if (map.containsKey(key)) {
            map.get(key).add(value);
        } else {
            ArrayList<Integer> list = new ArrayList<>();
            list.add(value);
            map.put(key, list);
        }
    }
    private static void printMapSortedByName(Map<String, ArrayList<Integer>> map) {
        System.out.println("Сортировка по фамилиям:");
        map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(System.out::println);
        System.out.println();
    }
    private static void printMapSortedByPhonesQuantity(Map<String, ArrayList<Integer>> map) {
        System.out.println("Сортировка от большего количества телефонов к меньшему:");
        map.entrySet()
                .stream()
                .sorted((k1, k2) -> Integer.valueOf(k2.getValue().size()).compareTo(Integer.valueOf(k1.getValue().size())))
                .forEach(System.out::println);
        System.out.println();
    }
}
