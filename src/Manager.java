public class Manager extends Employee{
    public Manager(String name, double baseSalary) {
        super(name, baseSalary);
    }

    @Override
    public double calculatePay() {
        return super.calculatePay() * 1.2;
    }
}
