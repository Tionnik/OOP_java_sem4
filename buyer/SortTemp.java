package OOP_java_sem4.buyer;

import java.util.ArrayList;

import OOP_java_sem4.shipment.Hot_beverage;

public class SortTemp {

    public ArrayList <Hot_beverage> getSortTemp(ArrayList <Hot_beverage> no_sort_list){
        ArrayList <Hot_beverage> sort_list = new ArrayList<>();
        int i;
        double max;
        int max_index;
        while (no_sort_list.size() > 0){
            max = no_sort_list.get(0).getTemperature();
            max_index = 0;
            for (i=1; i<no_sort_list.size(); i++){
                if(no_sort_list.get(i).getTemperature()>max){
                    max = no_sort_list.get(i).getTemperature();
                    max_index = i;
                }
            }
            sort_list.add(no_sort_list.get(max_index));
            no_sort_list.remove(max_index);
        }
        return sort_list;
    }

    public ArrayList <Hot_beverage> getSortVoiumeTemp(ArrayList <Hot_beverage> no_sort_list){
        ArrayList <Hot_beverage> sort_list = new ArrayList<>();
        int i;
        double max;
        int max_index;
        while (no_sort_list.size() > 0){
            max = no_sort_list.get(0).getVolume();
            max_index = 0;
            for (i=1; i<no_sort_list.size(); i++){
                if(no_sort_list.get(i).getVolume()>max){
                    max = no_sort_list.get(i).getVolume();
                    max_index = i;
                }
            }
            sort_list.add(no_sort_list.get(max_index));
            no_sort_list.remove(max_index);
        }

        return sort_list;
    }
}
