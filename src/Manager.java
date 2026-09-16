public class Manager extends Employee{
    public Manager(String name, double baseSalary) {
        super(name, baseSalary);
    }

    @Override
    public double getBonus() {
        return super.getBaseSalary() * 0.2;
    }
}
