package lab_1;

public class Student {
    private String surname;
    private int age;
    private boolean isDebts;

    public Student() {
        this.surname = "Иванов";
        this.age = 18;
        this.isDebts = true;
    }

    public Student(String surname) {
        this.surname = surname;
        this.age = 18;
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

    public Student(Student obj) {
        this.surname = obj.getSurname();
        this.age = obj.getAge();
        this.isDebts = obj.getIsDebts();
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
        return "Студент: " + getSurname() + "\nВозраст: " + getAge() + "\nНаличие задолжностей: " + debts + "\n";
    }

    public static void evenNumbers() {
        for (int i = 0; i < 20; ++i) {
            if (i > 10 && i%2==0) {
                System.out.println(i + " ");
            }
        }
    }
}
