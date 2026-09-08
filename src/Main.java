void main() {
    //Простая
    Book book1 = new Book("Война и мир", 1225);
    Book book2 = new Book("Мастер и Маргарита", 470);

    System.out.println("\nTitle: "+book1.title+", pages: "+book1.pages);
    System.out.println("\nTitle: "+book2.title+", pages: "+book2.pages);

    //Средняя
    Rectangle rect1 = new Rectangle(5.0, 3.0);
    Rectangle rect2 = new Rectangle(4.0, 4.0);

    System.out.println("\nRectangle 1:");
    System.out.println("Area: " + rect1.getArea());
    System.out.println("Perimeter: " + rect1.getPerimeter());

    System.out.println("\nRectangle 2:");
    System.out.println("Area: " + rect2.getArea());
    System.out.println("Perimeter: " + rect2.getPerimeter());

    if (Double.compare(rect1.getArea(),rect2.getArea()) > 0) {
        System.out.println("\nRectangle 1 has a larger area.");
    } else if (Double.compare(rect1.getArea(),rect2.getArea()) < 0) {
        System.out.println("\nRectangle 2 has a larger area.");
    } else {
        System.out.println("\nBoth rectangles have the same area.");
    }

    //Сложная
    System.out.println();
    BankAccount account = new BankAccount("Иван Иванов", 1000.00);
    account.printInfo();

    account.deposit(500.00);
    account.printInfo();

    account.withdraw(300.00);
    account.printInfo();

    account.withdraw(2000.00);
    account.printInfo();

    account.withdraw(-100.00);
    account.printInfo();

    account.deposit(-50.00);
    account.printInfo();
}
