package Classes;

public class Lecture_audience extends Audience{
    private int amountOfRows;
    private int amountOfPlaces;
    private boolean isProjector;

    public Lecture_audience(int number, int floor, double square, int amountOfRows, int amountOfPlaces, boolean isProjector) {
        super(number, floor, square);
        this.amountOfRows = amountOfRows;
        this.amountOfPlaces = amountOfPlaces;
        this.isProjector = isProjector;
    }

    public int getAmountOfRows() {
        return amountOfRows;
    }

    public int getAmountOfPlaces() {
        return amountOfPlaces;
    }

    public boolean isProjector() {
        return isProjector;
    }

    public void setAmountOfRows(int amountOfRows) {
        this.amountOfRows = amountOfRows;
    }

    public void setAmountOfPlaces(int amountOfPlaces) {
        this.amountOfPlaces = amountOfPlaces;
    }

    public void setProjector(boolean projector) {
        isProjector = projector;
    }

    @Override
    public double calculatePlaces() {
        return this.getAmountOfPlaces() * this.getAmountOfRows();
    }

    @Override
    public String getInfo() {
        String str = (isProjector) ? "есть" : "нет";
        return "\n------Лекционная аудитория------" + super.getInfo() + "\nКоличество рядов: " + amountOfRows + "\nКоличество мест в ряду: " + amountOfPlaces + "\nНаличие проектора: " + str;
    }
}
