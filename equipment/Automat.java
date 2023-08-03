package OOP_java_sem4.equipment;

import java.util.ArrayList;
import java.util.GregorianCalendar;

import OOP_java_sem4.shipment.Beverage;
import OOP_java_sem4.shipment.Food;
import OOP_java_sem4.shipment.Product;
                                                // Конструктор поиска в автомате, продуктов по имени
public class Automat {

    public Product findProduct(ArrayList<Product> list_products, String name){
          for (Product el : list_products) {
            if (el.getName().equals(name)){
                return el;
            }
        }
        return null;
    }
    public ArrayList <Product> getFood(){
        ArrayList <Product> my_list = new ArrayList<>();
        my_list.add(new Food(15,"Twix", 80, 10, new GregorianCalendar(2026, 10, 15),80));
        my_list.add(new Food(16,"Mars", 90, 9, new GregorianCalendar(2026, 10,0), 150));
        my_list.add(new Food(13,"Snickers", 60, 15, new GregorianCalendar(2026, 10,0),150));
        my_list.add(new Food(14,"Bounty", 85, 18, new GregorianCalendar(2026, 9, 13), 120));
        my_list.add(new Beverage(32,"Coca-Cola", 150, 7, new GregorianCalendar(2026, 3, 8), 0.5));

        return my_list;

    }
}
