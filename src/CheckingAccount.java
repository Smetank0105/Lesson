public class CheckingAccount extends BankAccount{
    private double overdraftFee;

    public CheckingAccount(String owner, double balance, double overdraftFee) {
        super(owner, balance);
        if (overdraftFee < 0) {
            throw new IllegalArgumentException("Комиссия не может быть отрицательной.");
        }
        this.overdraftFee = overdraftFee;
    }

    @Override
    public double calculateYearlyReport() {
        //double newBalance = super.getBalance() - overdraftFee;
        //return Math.max(newBalance, 0);
        return super.getBalance() - overdraftFee;
    }
}
