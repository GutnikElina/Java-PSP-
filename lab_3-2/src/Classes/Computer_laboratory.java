package Classes;

import Interfaces.Object;

public class Computer_laboratory extends Laboratory implements Object {
    private int amountOfComputers;

    public Computer_laboratory(int number, int floor, double square, boolean isLaborant, int amountOfComputers) {
        super(number, floor, square, isLaborant);
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
    public String findLaborant() {
        return (super.getIsLaborant()) ? "есть лаборант в комп. лаб." : "нет  лаборанта в комп. лаб.";
    }

    @Override
    public String getInfo() {
        return "\n--------Компьютерная лаборатория--------" + super.getInfo() + "\nКоличество компьютеров: " + amountOfComputers + "\nНаличие лаборанта: " + findLaborant();
    }
}
