package dzSem6;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Laptop laptop1 = new Laptop(Brand.Lenovo, Color.black, Price.cost1);
        Laptop laptop2 = new Laptop(Brand.Asus, Color.white, Price.cost2);
        Laptop laptop3 = new Laptop(Brand.Asus, Color.white, Price.cost3);
        Laptop laptop4 = new Laptop(Brand.HP, Color.red, Price.cost4);
        Laptop laptop5 = new Laptop(Brand.Lenovo, Color.black, Price.cost3);

        Set<Laptop> laptops = new HashSet<>();
        laptops.add(laptop1);
        laptops.add(laptop2);
        laptops.add(laptop3);
        laptops.add(laptop4);
        laptops.add(laptop5);

        Set<Brand> brandSet = new TreeSet<>();
        Set<Color> colorSet = new TreeSet<>();
        Set<Price> priceSet = new TreeSet<>();
        for (Laptop l : laptops) {
            brandSet.add(l.getBrand());
            colorSet.add(l.getColor());
            priceSet.add(l.getPrice());
        }
        Scanner sc = new Scanner(System.in);
        int userEnter = userEnter();
        Map<String, Object> userFilter = new HashMap<>();
        if (userEnter == 1) {
            System.out.println(brandSet);
            System.out.println("Бренд:");
            Brand filter = Brand.valueOf(sc.nextLine().toUpperCase());
            userFilter.put("Brand", filter);

        } else if (userEnter == 2) {
            System.out.println(colorSet);
            System.out.println("Цвет:");
            Color filter = Color.valueOf(sc.nextLine().toUpperCase());
            userFilter.put("Color", filter);

        } else {
            System.out.println(colorSet);
            System.out.println("Цену:");
            Color filter = Color.valueOf(sc.nextLine().toUpperCase());
            userFilter.put("Price", filter);
        }


        filterPrint(laptops, userFilter);

    }

    public static int userEnter() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите цифру:");
        System.out.println("1 - Бренд");
        System.out.println("2 - Цвет");
        System.out.println("3 - Цена");
        return scan.nextInt();
    }

    public static void filterPrint(Set<Laptop> laptops, Map<String, Object> userFilter) {
        for (Laptop laptopset : laptops) {
            boolean isAvailable = false;

            for (Map.Entry<String, Object> entries : userFilter.entrySet()) {
                String enKey = entries.getKey();
                Object enValue = entries.getValue();

                if (enKey.equals("Brand")) {
                    if (laptopset.getBrand().equals(enValue)) {
                        isAvailable = true;
                    }
                } else if (enKey.equals("Color")) {
                    if (laptopset.getColor().equals(enValue)) {
                        isAvailable = true;
                    }
                } else if (enKey.equals("Price")) {
                    if (laptopset.getPrice().equals(enValue)) {
                        isAvailable = true;
                    }
                }
            }
            if (isAvailable) {
                System.out.println(laptops);
            }
        }
    }
}
