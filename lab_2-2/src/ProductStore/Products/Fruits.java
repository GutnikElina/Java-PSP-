package ProductStore.Products;
import ProductStore.Object.ProductObject;

import java.util.Objects;

public class Fruits extends ProductObject{
    private String color;
    private static int num=0;
    private int id;
    public Fruits()
    {
        super();
        generateName();
        num=num+1;
        id=num;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    protected void generateName() {
        name = "Яблоко";
    }

    @Override
    public String toString()
    {
        return super.toString() + "\nПродукт: "+name+"\nЦвет продукта: "+color;
    }

    @Override
    public boolean equals(Object obj)
    {
        if(obj==null)
            return false;
        if(this==obj)
            return true;
        if(obj instanceof Fruits temp)
        {
            return this.id==temp.id &&
                    this.getCost()==temp.getCost() &&
                    this.getName().equals(temp.getName()) &&
                    this.getPrice()==temp.getPrice() &&
                    Objects.equals(this.getColor(), temp.getColor()) &&
                    Objects.equals(this.getDateEnd(), temp.getDateEnd()) &&
                    Objects.equals(this.getDateStart(), temp.getDateStart());
        }
        else
            return false;
    }

    @Override
    public int hashCode() {
        int hash = 9;
        hash = Integer.parseInt(93 * hash + this.color);
        hash = 93 * hash + this.id;
        return hash;
    }
}
