package oopSem6dz;

import java.io.FileWriter;
import java.io.IOException;

public class SaveOrderToJSON implements SaveOrders {

    public void saveOrder (Order order) {
        String fileName = "order.json";
        try (FileWriter writer = new FileWriter(fileName, false)) {
            writer.write("{\n");
            writer.write("\"id\":\"" + order.getId() + "\",\n");
            writer.write("\"clientName\":\""+ order.getClientName() + "\",\n");
            writer.write("\"product\":\""+order.getProduct() +"\",\n");
            writer.write("\"qnt\":"+order.getQnt() +",\n");
            writer.write("\"price\":"+order.getPrice() +"\n");
            writer.write("}\n");
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

    }
}
