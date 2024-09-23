package Classes;

/*Родительский класс требуется заменить одноимённым интерфейсом. Метод, ранее определённый в
супер-классе, записать в интерфейс в качестве абстрактного. Добавить интерфейс Object, в котором
объявить абстрактный метод print(). Далее создать 3 класса, реализующих оба интерфейса. Один из
этих классов нужно представить как абстрактный (не реализовать абстрактные методы). Нереализованные
методы реализуются в двух классах-наследниках абстрактного класса.*/

public class WriterInfo {
    public static void main(String[] args) {
        Classroom classroom1 = new Classroom(123, 3, 60, 15, true);
        Chemistry_laboratory chemical_lab1 = new Chemistry_laboratory(398, 9, 100, true, 45);
        Computer_laboratory computer_lab1 = new Computer_laboratory(398, 9, 100, false, 28);
        Lecture_audience lecture_audience = new Lecture_audience(456, 2, 50, 9, 20, true);

        System.out.println(classroom1.getInfo());
        System.out.println("\nКоличество мест в аудитории: " + (int)classroom1.calculatePlaces());

        System.out.println(chemical_lab1.getInfo());
        System.out.println("\nКоличество мест в аудитории: " + (int)chemical_lab1.calculatePlaces());

        System.out.println(computer_lab1.getInfo());
        System.out.println("\nКоличество мест в аудитории: " + (int)computer_lab1.calculatePlaces());

        System.out.println(lecture_audience.getInfo());
        System.out.println("\nКоличество мест в аудитории: " + (int)lecture_audience.calculatePlaces());
    }
}