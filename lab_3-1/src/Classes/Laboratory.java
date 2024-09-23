package Classes;

public class Laboratory extends Audience{
    private int amountOfComputers;

    public Laboratory(int number, int floor, double square, int amountOfComputers) {
        super(number, floor, square);
        this.amountOfComputers = amountOfComputers;
    }

    public int getAmountOfComputers() {
        return amountOfComputers;
    }

    public void setAmountOfComputers(int amountOfComputers) {
        this.amountOfComputers = amountOfComputers;
    }

    @Override
    public double calculatePlaces() {
        return amountOfComputers;
    }

    @Override
    public String getInfo() {
        return "\n----------Лаборатория----------" + super.getInfo() + "\nКоличество компьютеров: " + amountOfComputers;
    }
}
