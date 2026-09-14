public class Student extends Person {
    private double grade;

    public Student(String name, int age, double grade) {
        super(name, age);
        setGrade(grade);
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        if (grade >= 0.0 && grade <= 10.0) {
            this.grade = grade;
        } else {
            System.out.println("Ошибка. Оценка должна быть в диапозоне от 0 до 10.");
        }
    }

    @Override
    public void displayInfo() {
        System.out.println("Имя: " + getName() + ", Возраст: " + getAge() + ", Оценка: " + getGrade());
    }
}
