package ProductStore.Object;

import ProductStore.SetPrice;

abstract public class ProductObject implements SetPrice {
    private String dateStart;
    private String dateEnd;
    private double price;
    private double cost;
    protected String name;

    abstract protected void generateName();

    public ProductObject() {
        this.dateStart = "";
        this.dateEnd = "";
        this.price = 0;
        this.cost = 0;
    }

    public String getName() { return name; }

    public String getDateStart() {
        return dateStart;
    }

    public String getDateEnd() {
        return dateEnd;
    }

    public double getPrice() {
        return price;
    }

    public double getCost() {
        return cost;
    }

    public void setDateStart(String dateStart) {
        this.dateStart = dateStart;
    }

    public void setDateEnd(String dateEnd) {
        this.dateEnd = dateEnd;
    }

    public void setPrice() {
        this.price = countPrice();
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    @Override
    public double countPrice() {
        return ((cost*1.2)*1.2);
    }

    @Override
    public String toString()
    {
        return "Дата изготовления: "+dateStart+"\nДата окончания срока годности: "+dateEnd+"\nЦена: "+price+"\nСебестоимость: " + cost;
    }
}
