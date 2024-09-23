package ProductStore.Products;
import ProductStore.Object.ProductObject;

import java.util.Objects;

public class Bread extends ProductObject{
    private String color;
    private static int num=0;
    int id;
    public Bread()
    {
        super();
        generateName();
        num=num+1;
        id=num;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    protected void generateName() {
        name = (Objects.equals(color, "белый") || Objects.equals(color, "Белый"))? "Батон" : "Хлеб";
    }

    @Override
    public String toString()
    {
        return super.toString() + "\nПродукт: "+name+"\nТип продукта: "+color;
    }

    @Override
    public boolean equals(Object obj)
    {
        if(obj==null)
            return false;
        if(this==obj)
            return true;
        if(obj instanceof Bread temp)
        {
            return this.id==temp.id && this.getCost()==temp.getCost() &&
                    this.getName().equals(temp.getName()) &&
                    this.getPrice()==temp.getPrice() &&
                    Objects.equals(this.getDateEnd(), temp.getDateEnd()) &&
                    Objects.equals(this.getDateStart(), temp.getDateStart());
        }
        else
            return false;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = Integer.parseInt(47 * hash + this.color);
        hash = 47 * hash + this.id;
        return hash;
    }
}
