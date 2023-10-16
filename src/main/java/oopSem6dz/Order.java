package oopSem6dz;


public class Order {

    protected String clientName;
    protected String product;
    protected int qnt;
    protected double price;
    private int id;
    private int count;
    {
        count++;
        id = count;
    }


    public Order(String clientName, String product, int qnt, double price) {
        this.clientName = clientName;
        this.product = product;
        this.qnt = qnt;
        this.price = price;
    }

    public String getClientName() {
        return clientName;
    }

    public String getProduct() {
        return product;
    }

    public int getQnt() {
        return qnt;
    }

    public double getPrice() {
        return price;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return String.format("Order %d by %s, product %s, qnt - %d, price - %f", id, clientName, product, qnt, price);
    }
}
