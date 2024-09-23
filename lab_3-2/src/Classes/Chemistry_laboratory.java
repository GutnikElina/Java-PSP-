package Classes;

import Interfaces.Object;

public class Chemistry_laboratory extends Laboratory implements Object {
    private int amountOfChemicalElements;
    public Chemistry_laboratory(int number, int floor, double square, boolean isLaborant, int amountOfChemicalElements) {
        super(number, floor, square, isLaborant);
        this.amountOfChemicalElements = amountOfChemicalElements;
    }

    public int getAmountOfChemicalElements() {
        return amountOfChemicalElements;
    }

    public void setAmountOfChemicalElements(int amountOfChemicalElements) {
        this.amountOfChemicalElements = amountOfChemicalElements;
    }

    @Override
    public double calculatePlaces() {
        return amountOfChemicalElements;
    }

    @Override
    public String findLaborant() {
        return (super.getIsLaborant()) ? "есть лаборант в хим. лаб." : "нет  лаборанта в хим. лаб.";
    }

    @Override
    public String getInfo() {
        return "\n--------Химическая лаборатория--------" + super.getInfo() + "\nКоличество хим. элементов: " + amountOfChemicalElements + "\nНаличие лаборанта: " + findLaborant();
    }
}
