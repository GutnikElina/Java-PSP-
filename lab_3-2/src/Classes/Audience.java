package Classes;

import Interfaces.Object;

abstract public class Audience implements Object {
    private int number;
    private int floor;
    private double square;

    public Audience() {
        this.number = 0;
        this.floor = 0;
        this.square = 0;
    }

    public Audience(int number, int floor) {
        this.number = number;
        this.floor = floor;
    }

    public Audience(int number, int floor, double square) {
        this.number = number;
        this.floor = floor;
        this.square = square;
    }

    public int getNumber() {
        return number;
    }

    public int getFloor() {
        return floor;
    }

    public double getSquare() {
        return square;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public void setSquare(double square) {
        this.square = square;
    }

    abstract double calculatePlaces();

    @Override
    public String getInfo() {
        return "\nНомер аудитории: " + number + "\nЭтаж: " + floor + "\nПлощадь: " + square;
    }
}
