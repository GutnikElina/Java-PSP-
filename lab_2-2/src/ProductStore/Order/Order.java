package ProductStore.Order;

import java.util.*;
import ProductStore.Object.ProductObject;
import ProductStore.SetPrice;

public class Order implements SetPrice {
    private List<ProductObject> products;
    private double cost;
    private double price;
    private static int orderNumber=0;

    public Order()
    {
        products = new ArrayList<ProductObject> ();
        orderNumber++;
    }

    public void addProduct(ProductObject obj)
    {
        products.add(obj);
    }

    public void printOrder()
    {
        int i = 1;
        Iterator it = products.iterator();
        System.out.println("-------------------------------------------------");
        while(it.hasNext())
        {
            System.out.println(i+")\n"+(it.next()).toString());
            i = i + 1;
        }
        System.out.println();
        System.out.println("-------------------------------------------------");
        System.out.println("Себестоимость заказа: " + cost + " Цена заказа: "+price);
        System.out.println("-------------------------------------------------");
    }

    @Override
    public double countPrice() {
        double tempPrice=0, tempCost=0;
        Iterator it = products.iterator();
        ProductObject obj;
        while(it.hasNext())
        {
            obj=(ProductObject) it.next();
            tempCost=tempCost+obj.getCost();
            tempPrice=tempPrice+obj.getPrice();
        }
        cost=tempCost;
        price=tempPrice;
        return tempPrice;
    }
}
