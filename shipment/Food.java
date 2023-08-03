package OOP_java_sem4.shipment;

import java.util.Calendar;

public class Food  extends Product{
                                                // Конструктор объектов класса еда
    private int weight;

    public Food(int id, String name, int price, int quantity, Calendar best_before, int weight){
        super(id, name, price, quantity, best_before);
        this.weight = weight;
    }
    public int getWeight() {
        return weight;
    }

    @Override
    public String toString(){
        
        return "\n"+"ID: "+getID()+"  "+getName() + "  Цена: " + getPrice() + "  Кол-во: " + getQuantity() + " Масса: " + weight 
                              + "  Годен до: " +getBest_before().get(Calendar.DAY_OF_MONTH) +"."+ getBest_before().get(Calendar.MONTH)
                              +"." + getBest_before().get(Calendar.YEAR) ;
    }
}
