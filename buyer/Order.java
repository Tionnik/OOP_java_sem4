package OOP_java_sem4.buyer;
                                    // Конструктор для списка товаров на покупку
public class Order {
    
    private int ID;
    private String name;
    private int price;
    private int quantity;

    public Order(int id, String name, int price, int quantity){
        this.ID = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
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

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString(){
        
        return "\n"+"ID: "+getID()+"  "+getName() + "  Цена: " + getPrice() + "  Кол-во: " + getQuantity();
                             
    }

}
