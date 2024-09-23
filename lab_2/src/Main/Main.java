package Main;
import Student.Student;

public class Main {
    public static void main(String[] args) {
        Student[] students = new Student[4];

        students[0] = new Student();
        students[1] = new Student("Петров");
        students[2] = new Student("Сачук", 19);
        students[3] = new Student("Гутник", 19, false);

        for (Student student: students) {
            System.out.println(student.getInfo());
        }

        System.out.println("Средник возраст студентов: " + Student.averageAge(students));

        System.out.println("Количество студентов с задолженностями: " + Student.amountStudentsWithDebts(students));
    }
}