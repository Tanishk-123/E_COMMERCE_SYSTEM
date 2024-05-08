package E_COMMERCE_SYSTEM;
public class Cart {
    private int id;
    private String itemName;
    private double cost;
    private int quantity;
    private double total;

    public Cart(int id, String itemName, double cost, int quantity) {
        this.id = id;
        this.itemName = itemName;
        this.cost = cost;
        this.quantity = quantity;
        this.total = cost * quantity;
    }

    public String getItemName() {
        return itemName;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getTotal() {
        return total;
    }
@Override
    public String toString() {
 return  String.format(
     "%02d\t %-40s %09.2f\t %02d\t\t %09.2f\t\t ",id, itemName, cost,quantity,total);
    }
}

