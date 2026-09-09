public class BankAccount {
    private String owner;
    private double balance;

    public BankAccount(String owner){
        this.owner = owner;
        this.balance = 0.0;
    }

    public String getOwner() {
        return owner;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount){
        if(amount <= 0){
            System.out.println("Некорректная сумма пополнения.");
        } else {
            this.balance += amount;
            System.out.println("Состояние счёта: "+getBalance());
        }
    }

    public void withdraw(double amount){
        if(amount <= 0){
            System.out.println("Некорректная сумма для снятия.");
        }else if(Double.compare(amount, getBalance()) > 0){
            System.out.println("Недостаточно средств.");
        }else{
            this.balance -= amount;
            System.out.println("Состояние счёта: "+getBalance());
        }
    }
}
