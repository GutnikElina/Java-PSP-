package WriterInfo;

import Classes.Classroom;
import Classes.Laboratory;
import Classes.Lecture_audience;

public class WriterInfo {
    public static void main(String[] args) {
        Classroom classroom1 = new Classroom(123, 3, 60, 15, true);
        Laboratory lab1 = new Laboratory(321, 6, 45, 25);
        Lecture_audience lecture_audience = new Lecture_audience(456, 2, 50, 9, 30, true);

        System.out.println(classroom1.getInfo());
        System.out.println("\nКоличество мест в аудитории: " + (int)classroom1.calculatePlaces());

        System.out.println(lab1.getInfo());
        System.out.println("\nКоличество мест в аудитории: " + (int)lab1.calculatePlaces());

        System.out.println(lecture_audience.getInfo());
        System.out.println("\nКоличество мест в аудитории: " + (int)lecture_audience.calculatePlaces());
    }
}