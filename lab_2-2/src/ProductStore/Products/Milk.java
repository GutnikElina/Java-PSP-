package ProductStore.Products;
import ProductStore.Object.ProductObject;

import java.util.Objects;

public class Milk extends ProductObject{
    private double procent;
    private static int num=0;
    private int id;
    public Milk()
    {
        super();
        generateName();
        num=num+1;
        id=num;
    }

    public double getProcent() {
        return procent;
    }

    public void setProcents(double procent) {
        this.procent = procent;
    }

    @Override
    protected void generateName() {
        name = "Молоко";
    }

    @Override
    public String toString()
    {
        return super.toString() + "\nПродукт: "+name+"\nПроцент жирности : "+procent+"%";
    }

    @Override
    public boolean equals(Object obj)
    {
        if(obj==null)
            return false;
        if(this==obj)
            return true;
        if(obj instanceof Milk temp)
        {
            return this.id==temp.id &&
                    this.getCost()==temp.getCost() &&
                    this.getName().equals(temp.getName()) &&
                    this.getPrice()==temp.getPrice() &&
                    Objects.equals(this.getProcent(), temp.getProcent()) &&
                    Objects.equals(this.getDateEnd(), temp.getDateEnd()) &&
                    Objects.equals(this.getDateStart(), temp.getDateStart());
        }
        else
            return false;
    }

    @Override
    public int hashCode() {
        int hash = 8;
        hash = (int) (44 * hash + this.procent);
        hash = 44 * hash + this.id;
        return hash;
    }
}
