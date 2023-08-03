package OOP_java_sem4.equipment;

import java.util.ArrayList;
import java.util.GregorianCalendar;

import OOP_java_sem4.shipment.Hot_beverage;
import OOP_java_sem4.shipment.Product;
                                               // Конструктор поиска в автомате, горячих напитков по температуре и объему (нет в тукущей реализации)
public class Hot_automat extends Automat{

    public Product findProduct(ArrayList<Product> list_products, String name,  double volume, int temperature){
        for (Product el : list_products) {
            if (el instanceof Hot_beverage ){
                if ((((Hot_beverage) el).getName().equals(name))&&
                    (((Hot_beverage) el).getVolume() == (volume))&&
                    (((Hot_beverage) el).getTemperature() == temperature)){
                      return el;  
                }
            }
        }
        return null;
    }
    public ArrayList <Product> getHotBeverrage(){
        ArrayList <Product> my_list = new ArrayList<>();
        my_list.add(new Hot_beverage(21,"Nesсafe", 150, 35, 
                    new GregorianCalendar(2024, 5, 12), 0.33, 25));
        my_list.add(new Hot_beverage(22,"Jacobs", 120, 3, 
                    new GregorianCalendar(2024, 6, 07), 0.33, 20));
        my_list.add(new Hot_beverage(24,"Bushido", 170, 12, 
                    new GregorianCalendar(2024, 03, 11), 0.6, 25));
        return my_list;

    }
}
