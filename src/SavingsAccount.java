public class SavingsAccount extends BankAccount{
    private double interestRate;

    public SavingsAccount(String owner, double balance, double interestRate) {
        super(owner, balance);
        if (interestRate < 0) {
            throw new IllegalArgumentException("Процентная ставка не может быть отрицательной.");
        }
        this.interestRate = interestRate;
    }

    @Override
    public double calculateYearlyReport() {
        double interest = super.getBalance() * interestRate;
        return super.getBalance() + interest;
    }
}
