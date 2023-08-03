package OOP_java_sem4.shipment;

import java.util.Calendar;

public abstract class Product {
                                        // Конструктор объектов класса продукт
    private int ID;
    private String name;
    private int price;
    private int quantity;
    private Calendar best_before;

    public Product(int id, String name, int price, int quantity, Calendar best_before){
        this.ID = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.best_before = best_before;
    }
    public int getID() {
        return ID;
    }
    public String getName() {
        return name;
    }
    public int getPrice() {
        return price;
    }
    public int getQuantity() {
        return quantity;
    }
    public Calendar getBest_before() {
        return best_before;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
