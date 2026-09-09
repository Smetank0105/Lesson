void main() {
    //1
    Person user = new Person("Ivan", 18);
    user.setName("Peter");
    user.setAge(36);
    System.out.println("Name: "+user.getName()+", Age: "+user.getAge());
    System.out.println();

    //2
    Product product = new Product("Potato", 2.5);
    product.setPrice(-1.0);
    product.setPrice(4.6);
    System.out.println(product.getPrice());
    System.out.println();

    //3
    BankAccount bank = new BankAccount("MySber");
    //bank.balance = 1000000;
    bank.deposit(100.0);
    bank.deposit(-100.0);
    bank.withdraw(1000.0);
    bank.withdraw(-1000.0);
    bank.withdraw(99.0);
}
