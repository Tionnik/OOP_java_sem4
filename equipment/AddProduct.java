package OOP_java_sem4.equipment;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Scanner;

import OOP_java_sem4.shipment.Beverage;
import OOP_java_sem4.shipment.Food;
import OOP_java_sem4.shipment.Hot_beverage;
import OOP_java_sem4.shipment.Product;

public class AddProduct {
    public void AddEquipment(ArrayList<Product> list_hot, ArrayList<Product> list_food){
        ArrayList <Product> list_product = new ArrayList<>();
        Scanner scan = new Scanner(System.in);
        int idCommand;
        int id_product;
        int quantity;
        int i;
        while (true) {
            System.out.println("[1]Добавить еду");
            System.out.println("[2]Добавить напиток");
            System.out.println("[3]Добавить горячий напиток");                                      // Меню добавления продуктов в автоматы
            System.out.println("[0]Закончить добавление товара");
            System.out.print("Выберете категорию: ");
            idCommand = scan.nextInt();
            scan.nextLine();

            if(idCommand == 1)  list_product = list_food;                                           // если добавляем еду или напиток работаем с 
            else if(idCommand == 2) list_product = list_food;                                       // базой продуктов автомата
            else if(idCommand == 0 ) break;                                                         // для выхода из меню добавления товара
            else list_product = list_hot;                                                           // работа с базой автомата с горячими напитками

            System.out.print("Введите ID добавляемого товара: ");
            id_product= scan.nextInt();
            scan.nextLine();
            for (i=0; i<list_product.size(); i++) {                                                 // пробегает весь список продуктов и ищет есть ли такой в базе
                if(list_product.get(i).getID()==id_product){                                        // Если находит такой товар
                    System.out.printf("Выбран товар: "+list_product.get(i).getName()+" С кол-вом в автомате: "+ list_product.get(i).getQuantity()+"\n");
                    System.out.print("Введите кол-во добавляемого товара: ");                     // Запращивает какое кол-во товара добавляется в автомат
                    quantity = scan.nextInt();
                    scan.nextLine();
                    if(quantity<(-1*list_product.get(i).getQuantity())){                            // Проверка на кол-ва изымаемого товара
                        System.out.println("Такое кол-во не может быть изъято из автомата");
                        break;
                    }
                    else {                                                                          // Добавляет или изымает кол-во товара автомата
                        list_product.get(i).setQuantity(quantity+list_product.get(i).getQuantity());
                        break;
                    }
                }
            }
            if(i == list_product.size()){                                     // если прошли весь список, но товара не нашли, то создаем новую запись
                System.out.println("Выбранного товаре нет в базе, Заполните все поля:");
                System.out.print("Введите ID нового товара, для отмены наберите 0: ");              
                int id = scan.nextInt();
                scan.nextLine();
                if (id >0){
                    System.out.print("Введите название нового товара: ");
                    String name = scan.nextLine();
                    System.out.print("Введите цену нового товара: ");
                    int price = scan.nextInt();
                    scan.nextLine();
                    System.out.print("Введите кол-во добавляемого товара: ");
                    quantity = scan.nextInt();
                    scan.nextLine();
                    System.out.print("Введите полностью год годности товара: ");
                    int YEAR = scan.nextInt();
                    scan.nextLine();
                    System.out.print("Введите месяц годности товара: ");
                    int MONTH = scan.nextInt();
                    scan.nextLine();
                    System.out.print("Введите день годности товара: ");
                    int DAY = scan.nextInt();
                    scan.nextLine();
                    if(idCommand == 1){                                             // от выбранной команды ранее добавляем еду
                        System.out.print("Введите массу товара: ");
                        int weight = scan.nextInt();
                        scan.nextLine();
                        System.out.printf("ID: "+id+"  "+" Название: "+name+ "  Цена: " + price + "  Кол-во: " + quantity + 
                        " Масса: " + weight + "  Годен до: " +DAY+"."+ MONTH+"." + YEAR+"\n");
                        System.out.print("Для внесения товара введите [1]: ");   // Подтверждение добавления товара
                        int cat = scan.nextInt();
                        scan.nextLine();
                        if(cat == 1){
                            list_food.add(new Food(id,name, price, quantity, new GregorianCalendar(YEAR, MONTH, DAY),weight));
                        }      
                    }
                    if(idCommand == 2){                                             // от выбранной команды ранее добавляем напиток
                        System.out.print("Введите объем товара: ");
                        double volume = Double.parseDouble(scan.nextLine());
                        System.out.printf("ID: "+id+"  "+" Название: "+name+ "  Цена: " + price + "  Кол-во: " + quantity + 
                        " Объем: " + volume + "  Годен до: " +DAY+"."+ MONTH+"." + YEAR+"\n");
                        System.out.print("Для внесения товара введите [1]: ");   // Подтверждение добавления товара
                        int cat = scan.nextInt();
                        scan.nextLine();
                        if(cat == 1){
                            list_food.add(new Beverage(id,name, price, quantity, new GregorianCalendar(YEAR, MONTH, DAY),volume));
                        }      
                    }
                    if(idCommand > 2){                                             // от выбранной команды ранее добавляем горячий напиток
                        System.out.print("Введите объем товара: ");
                        double volume = Double.parseDouble(scan.nextLine());
                        System.out.print("Введите температуру товара: ");
                        int temperature = scan.nextInt();
                        scan.nextLine();
                        System.out.printf("ID: "+id+"  "+" Название: "+name+ "  Цена: " + price + "  Кол-во: " + quantity + 
                        " Объем: " + volume + " Температура: "+temperature+"  Годен до: " +DAY+"."+ MONTH+"." + YEAR+"\n");
                        System.out.print("Для внесения товара введите [1]: ");   // Подтверждение добавления товара
                        int cat = scan.nextInt();
                        scan.nextLine();
                        if(cat == 1){
                            list_hot.add(new Hot_beverage(id,name, price, quantity, new GregorianCalendar(YEAR, MONTH, DAY),volume,temperature));
                        }      
                    }
                }
            }
        }
    }
}
