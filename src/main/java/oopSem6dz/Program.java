package oopSem6dz;

import java.util.ArrayList;
import java.util.Scanner;

public class Program {

    /**
     * TODO: Переработать структуру приложения Order, приложение должно соответствовать
     *  принципу SRP.
     * @param args
     */
    public static void main(String[] args) {

        ArrayList<Order> orders = new ArrayList<>();
        ReceivingAnOrders receiveOrderClient = new ReceiveOrderClient();
        SaveOrders toJSON = new SaveOrderToJSON();

        Scanner input = new Scanner(System.in);
        System.out.print("Введите количество заказов для оформления: ");
        int count = input.nextInt();

        for (int i = 0; i < count; i++) {
            System.out.println("Введите заказ:");
            orders.add(receiveOrderClient.receiveNewOder());
            System.out.println(orders.get(i));
        }

        for (Order order : orders) {
            toJSON.saveOrder(order);
        }

        System.out.println("Заказ создан и сохранен в формате JSON.");

        input.close();
    }

}
