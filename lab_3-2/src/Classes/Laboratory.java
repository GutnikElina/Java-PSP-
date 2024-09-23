package Classes;

import Interfaces.Object;

abstract public class Laboratory extends Audience implements Object {
    private boolean isLaborant;

    public Laboratory(int number, int floor, double square, boolean isLaborant) {
        super(number, floor, square);
        this.isLaborant = isLaborant;
    }

    public boolean getIsLaborant() {
        return isLaborant;
    }

    public void setLaborant(boolean laborant) {
        isLaborant = laborant;
    }

    abstract String findLaborant();
}
