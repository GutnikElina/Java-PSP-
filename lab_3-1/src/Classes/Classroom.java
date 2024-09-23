package Classes;

public class Classroom extends Audience{
    private int amountOfTables;
    private boolean isComputer;

    public Classroom(int number, int floor, double square, int amountOfTables, boolean isComputer) {
        super(number, floor, square);
        this.amountOfTables = amountOfTables;
        this.isComputer = isComputer;
    }

    public int getAmountOfTables() {
        return amountOfTables;
    }

    public void setAmountOfTables(int amountOfTables) {
        this.amountOfTables = amountOfTables;
    }

    public boolean isComputer() {
        return isComputer;
    }

    public void setComputer(boolean computer) {
        isComputer = computer;
    }

    @Override
    public double calculatePlaces() {
        return (amountOfTables * 2);
    }

    @Override
    public String getInfo() {
        String str = (isComputer) ? "есть" : "нет";
        return "\n---------Учебный класс---------" + super.getInfo() + "\nКоличество столов: " + amountOfTables + "\nНаличие компьютера: " + str;
    }
}
