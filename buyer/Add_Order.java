package OOP_java_sem4.buyer;

import java.util.ArrayList;
import java.util.Scanner;

import OOP_java_sem4.equipment.Automat;
import OOP_java_sem4.shipment.Beverage;
import OOP_java_sem4.shipment.Food;
import OOP_java_sem4.shipment.Hot_beverage;
import OOP_java_sem4.shipment.Product;

                                                //Класс для формирования и оплаты списка покупок
public class Add_Order{

    public ArrayList <Order> getList_order(ArrayList<Product> list_hot, ArrayList<Product> list_food){            // получает список продуктов в автомате
        Scanner scan = new Scanner(System.in);
        ArrayList <Order> list_order  = new ArrayList<>();                              // Создаем пустой список покупок
        ArrayList <Product> list_product;
        int idCommand;
        boolean no_exit = true;
        int id_product;
        int quantity;
        int count;
        int id_category;

        while (no_exit){                                                                // ожидание команды пользователя
            int sum = 0;
            System.out.println();
            System.out.println("Список выбранных товаров");
            System.out.println(list_order);                                             // Печать списка покупаемых товаров 
            for (Order order : list_order) {
                sum = sum + order.getPrice() * order.getQuantity();
            }
            System.out.print("Итого к оплате: ");
            System.out.println(sum);


            System.out.println();
            System.out.println("[1] Показать товар из категории");
            System.out.println("[2] Поиск товара по названию");
            System.out.println("[3] Добавить продукт в корзину по ID");                 //Меню для заполнения списка товаров и оформления покупки
            System.out.println("[4] Изменить продукт в корзину по ID");
            System.out.println("[9] Покинуть покупки");
            System.out.println("[0]Перейти к оплате");
            System.out.print("Выберете команду: ");
            idCommand = scan.nextInt();
            scan.nextLine();

        
            if (idCommand==1){
                System.out.println();
                System.out.println("[1] Показать продукты категории: Еда");
                System.out.println("[2] Показать продукты категории: Напитки");         // Меню выбора категории
                System.out.println("[3] Показать продукты категории: Горячии напитки");
                System.out.print("Выберете команду: ");
                id_category = scan.nextInt();
                scan.nextLine();

                if (id_category==1){
                    ArrayList <Food> list = new ArrayList<>();
                    for (Product el : list_food) {                                       // Пробегает весь список товаров 
                       if (el instanceof Food ){                                       // и показывает те которые подходят к выбранной категории
                            if (el.getQuantity()>0){
                                list.add((Food) el);
                            }
                        } 
                    }
                    list = new SortWeight().getSortWeight(list);
                    System.out.println(list); 
                } 

                if (id_category== 2){                                                       
                    ArrayList <Beverage> list = new ArrayList<>();                                                      
                    for (Product el : list_food) {                                       // Пробегает весь список товаров 
                        if (el instanceof Beverage ){                                       // и показывает те которые подходят к выбранной категории
                            if (el.getQuantity()>0){
                                list.add((Beverage) el);
                            }
                        }
                    }
                    list = new SortVolume().getSortVoiume(list); 
                    System.out.println(list); 
                }

                if (id_category == 3){
                    System.out.println();
                    System.out.println("[1] Отсортировать по объему");
                    System.out.println("[2] Отсортировать по температуре");         // Меню выбора категории
                    System.out.print("Выберете команду: ");
                    ArrayList <Hot_beverage> list = new ArrayList<>();
                    for (Product el : list_hot) {                                       // Пробегает весь список товаров
                        list.add((Hot_beverage)el);
                    }
                    int id_cat= scan.nextInt();
                    scan.nextLine();
                    if (id_cat == 1){
                        System.out.println(new SortTemp().getSortVoiumeTemp(list));
                    }
                    else {
                        System.out.println(new SortTemp().getSortTemp(list));
                    }
                } 
            }
            
            if (idCommand==2){                                                              // Показывает товар с совпадающим названием
                System.out.println();
                System.out.print("Введите название: ");
                String name = scan.nextLine();
                for (Product order : list_food) {                                        // Проверяет есть такое имя в базе продуктов 
                    if (order.getName().equals(name)){
                    System.out.println(new Automat().findProduct(list_food,name).toString());    
                    }
                }
                for (Product order : list_hot) {                                        // Проверяет есть такое имя в базе продуктов 
                    if (order.getName().equals(name)){
                    System.out.println(new Automat().findProduct(list_hot,name).toString());    
                    }
                }


            }

            if (idCommand==3){                                                              // Добавление товара в список покупок по его номеру

                System.out.println();
                System.out.println("[1] Добавить еду или напиток");
                System.out.println("[2] Добавить горячий напиток");         // Меню выбора категории
                System.out.print("Выберете команду: ");
                int id_cat = scan.nextInt();
                scan.nextLine();
                if (id_cat==1){ list_product = list_food;}
                else list_product = list_hot;

                System.out.print("Выберете ID товара: ");
                id_product = scan.nextInt();
                scan.nextLine();
                for (Product product : list_product) {                                      // Пробегает весь список товаров
                    if (id_product == product.getID()){                                     // и находит совпадение с веденным 
                        count = product.getQuantity();                                      // Запоминает его количество доступное к покупке
                        System.out.println("Доступно для покупки: "+count);
                        System.out.print("Выберете кол-во товара: ");                     //  Просит от пользователя кол-во к покупке 
                        quantity = scan.nextInt();
                        scan.nextLine();
                        if (quantity <0){                                                   // Проверка правильности ввода
                            System.out.println();
                            System.out.println("Вы ввели отрицательное число");
                            break;
                        }
                        if (quantity <= count){                                             // Проверяет возможно ли купить такое количество товара
                            list_order.add(new Order(product.getID(),product.getName(),product.getPrice(),quantity)); // Вносит текущуй товар в список покупок
                            product.setQuantity(count-quantity);                            // формирует доступный остаток для покупки товара
                        }    
                        if (quantity>count) {
                            System.out.println("Вы запросили кол-ва большее чем в автомате");
                        }
                    break;                                                                  // После нахождения товара останавливает последующий поиск
                    }
                }
            }

            if (idCommand == 4){                                                            // Изменяет количество товара к покупке 

                System.out.println();
                System.out.println("[1] Изменить еду или напиток по ID");
                System.out.println("[2] Изменить горячий напиток по ID");         // Меню выбора категории
                System.out.print("Выберете команду: ");
                id_category = scan.nextInt();
                scan.nextLine();
                if (id_category==1){ list_product = list_food;}
                else list_product = list_hot;
                System.out.print("Выберете ID товара на изменение: ");
                id_product = scan.nextInt();
                scan.nextLine();
                for (Order pr : list_order) {                                               // Пробегает весь список покупок 
                    if (id_product == pr.getID()){                                          // и находит нужный товар
                        for (Product el : list_product) {                                   // Пробегает по всему списку товаров
                            if (id_product == el.getID()){                                  // и находит тот же товар
                                count = el.getQuantity() + pr.getQuantity();                // и суммирует его остаток и кол-во в текущем заказе 
                                System.out.println("Доступно для покупки: "+count);
                                System.out.print("Выберете кол-во товара: ");
                                quantity = scan.nextInt();
                                scan.nextLine();
                                if (quantity <0){                                           // Проверка правильности ввода
                                    System.out.println();
                                    System.out.println("Вы ввели отрицательное число");
                                    break;
                                }
                                if (quantity == 0){                                         // Если кол-во выбранного товара 0                                        
                                    list_order.remove(pr);                                  // Удаляет этот товар из списка покупок
                                }
                                if (quantity <= count){                                     // Если кол-во доступно для покупки
                                    pr.setQuantity(quantity);                               // Запоминает новое кол-во в листе покупок
                                    el.setQuantity(count-quantity);                         // Запоминает новый остаток
                                }
                                if (quantity> count){
                                    System.out.println();
                                    System.out.println("Вы запросили кол-ва большее чем в автомате");
                                }
                                break; 
                            }
                        }
                    break;   
                    }
                }
            }

            if (idCommand == 0) {                                                           // Проведение оплаты
                System.out.print("Введите сумму для оплаты: ");
                int summa = scan.nextInt();
                scan.nextLine();
                if (summa < sum){                                                          // Если средств меньше чем требуется для покупки
                    System.out.println();
                    System.out.println("Недостаточно средст отмените часть товара");
                    System.out.println();
                }
                else {                                                                      // Успешная покупка
                    System.out.println();
                    System.out.println("Спасибо за покупку");
                    System.out.print("Ваша сдача: ");
                    System.out.println(summa-sum);
                    System.out.println("Не забудьте ваш товар и сдачу");
                    System.out.println();
                    no_exit =false;
                }
            }

            if (idCommand == 9){                                                            // Сброс покупок
                System.out.println("Спасибо за покупку");
                no_exit =false;
            }
        }
    return list_order;
    }

}
