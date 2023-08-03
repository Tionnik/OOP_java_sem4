package OOP_java_sem4.buyer;

import java.util.ArrayList;

import OOP_java_sem4.shipment.Food;


 public class SortWeight { 
    public ArrayList <Food> getSortWeight(ArrayList <Food> no_sort_list){
        ArrayList <Food> sort_list = new ArrayList<>();
        int i;
        int max;
        int max_index;
        while (no_sort_list.size() > 0){
            max = no_sort_list.get(0).getWeight();
            max_index = 0;
            for (i=1; i<no_sort_list.size(); i++){
                if(no_sort_list.get(i).getWeight()>max){
                    max = no_sort_list.get(i).getWeight();
                    max_index = i;
                }
            }
            sort_list.add(no_sort_list.get(max_index));
            no_sort_list.remove(max_index);
        }

        return sort_list;

    }
}
