public abstract class Employee implements Payable {
    private String name;
    private double baseSalary;

    public String getName() {
        return name;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public Employee(String name, double baseSalary) {
        this.name = name;
        this.baseSalary = baseSalary;
    }

    public abstract double getBonus();

    @Override
    public double calculatePay() {
        return baseSalary + getBonus();
    }
}
