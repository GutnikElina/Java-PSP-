package WriterInfo;

import lab_1.Student;

public class WriterInfo {
    public static void main(String[] args) {
        Student student1 = new Student();
        Student student2 = new Student("Петров");
        Student student3 = new Student("Сачук", 19);
        Student student4 = new Student("Гутник", 19, false);

        System.out.println(student1.getInfo());
        System.out.println(student2.getInfo());
        System.out.println(student3.getInfo());
        System.out.println(student4.getInfo());

        System.out.println("Четные числа второго десятка: ");
        Student.evenNumbers();
    }
}
