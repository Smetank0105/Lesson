public class BankAccount {
    private String owner;
    private double balance;

    public BankAccount(String owner, double balance) {
        this.owner = owner;
        this.balance = balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Пополнение на " + amount + " выполнено.");
        } else {
            System.out.println("Сумма пополнения должна быть положительной.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0) {
            if (balance >= amount) {
                balance -= amount;
                System.out.println("Снятие " + amount + " выполнено.");
            } else {
                System.out.println("Недостаточно средств");
            }
        } else {
            System.out.println("Сумма снятия должна быть положительной.");
        }
    }

    public void printInfo() {
        System.out.println("Владелец: "+this.owner+", Баланс: "+this.balance);
    }
}
