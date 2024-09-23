package Student;

public class Student {
    private String surname;
    private int age;
    private boolean isDebts;

    public Student() {
        this.surname = "Иванов";
        this.age = 17;
        this.isDebts = true;
    }

    public Student(String surname) {
        this.surname = surname;
        this.age = 17;
    }

    public Student(String surname, int age) {
        this.surname = surname;
        this.age = age;
    }

    public Student(String surname, int age, boolean isDebts) {
        this.surname = surname;
        this.age = age;
        this.isDebts = isDebts;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    public boolean getIsDebts() {
        return isDebts;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setDebts(boolean isDebts) {
        this.isDebts = isDebts;
    }

    public String getInfo() {
        String debts = (getIsDebts()) ? "есть" : "нет";
        return "Студент: " + getSurname() + "\nВозраст: " + getAge() + "\nНаличие задолжностей: " + debts + "\n----------------------";
    }

    public static int averageAge (Student[] students) {
        double avAge = 0;
        for (Student student: students) {
            avAge+=((double) student.getAge() /students.length);
        }
        return (int)avAge;
    }

    public static int amountStudentsWithDebts (Student[] students) {
        int amount = 0;
        for (Student student: students) {
            amount += (student.isDebts) ? 1 : 0;
        }
        return amount;
    }
}
