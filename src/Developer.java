public class Developer extends Employee{
    private static final double BONUS = 15000;

    public Developer(String name, double baseSalary) {
        super(name, baseSalary);
    }

    @Override
    public double calculatePay() {
        return super.calculatePay() + BONUS;
    }
}
