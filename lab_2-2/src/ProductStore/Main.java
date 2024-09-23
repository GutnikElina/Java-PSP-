package ProductStore;

/*Построить иерархию объектов. Показать использование и понимание принципов инкапсуляции,
наследования, полиморфизма. В классах должны быть поля, конструкторы, методы. Обязательным
является переопределение методов класса Object  toString(), equals(), hashCode(). Использовать
абстрактные классы и интерфейсы. Собрать коллекции объектов.*/

//Продовольственный магазин (собрать заказ)

import ProductStore.Order.Order;
import ProductStore.Products.Bread;
import ProductStore.Products.Fruits;
import ProductStore.Products.Meat;
import ProductStore.Products.Milk;

public class Main {
    public static void main(String[] args) {
        Order order=new Order();

        Milk milk=new Milk();
        Meat meat=new Meat();
        Fruits fruits=new Fruits();
        Bread bread=new Bread();

        milk.setProcents(32);
        milk.setCost(4.2);
        milk.setPrice();
        milk.setDateEnd("12.09.2024");
        milk.setDateStart("28.08.2024");

        meat.setType("Говядина");
        meat.setCost(12.5);
        meat.setPrice();
        meat.setDateEnd("23.09.2024");
        meat.setDateStart("09.09.2024");

        fruits.setColor("Зеленый");
        fruits.setCost(2.4);
        fruits.setPrice();
        fruits.setDateEnd("18.09.2024");
        fruits.setDateStart("01.09.2024");

        bread.setColor("Белый");
        bread.setCost(2.7);
        bread.setPrice();
        bread.setDateEnd("02.10.2024");
        bread.setDateStart("10.09.2024");

        order.addProduct(milk);
        order.addProduct(meat);
        order.addProduct(fruits);
        order.addProduct(bread);

        order.countPrice();
        order.printOrder();
        System.out.println(order.toString());
    }
}