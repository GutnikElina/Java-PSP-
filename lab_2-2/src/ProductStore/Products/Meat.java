package ProductStore.Products;
import ProductStore.Object.ProductObject;

import java.util.Objects;

public class Meat extends ProductObject {
    private String type;
    private static int num=0;
    private int id;
    public Meat()
    {
        super();
        generateName();
        num=num+1;
        id=num;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    protected void generateName() {
        name = "Мясо";
    }

    @Override
    public String toString()
    {
        return super.toString() + "\nПродукт: "+name+"\nТип мяса: "+type;
    }

    @Override
    public boolean equals(Object obj)
    {
        if(obj==null)
            return false;
        if(this==obj)
            return true;
        if(obj instanceof Meat temp)
        {
            return this.id==temp.id &&
                    this.getCost()==temp.getCost() &&
                    this.getName().equals(temp.getName()) &&
                    this.getPrice()==temp.getPrice() &&
                    Objects.equals(this.getType(), temp.getType()) &&
                    Objects.equals(this.getDateEnd(), temp.getDateEnd()) &&
                    Objects.equals(this.getDateStart(), temp.getDateStart());
        }
        else
            return false;
    }

    @Override
    public int hashCode() {
        int hash = 11;
        hash = Integer.parseInt(23 * hash + this.type);
        hash = 23 * hash + this.id;
        return hash;
    }
}
