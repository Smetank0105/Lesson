void main() {
    //1
    Animal[] animals = {
            new Dog("Барсик"),
            new Cat("Мурзик")
    };

    for (Animal animal : animals) {
        animal.makeSound();
        animal.sleep();
    }

    //2
    Drawable[] drawings = new Drawable[2];

    drawings[0] = new Circle(5.5);
    drawings[1] = new TextLabel("Hello, World!");

    for (Drawable d : drawings) {
        d.draw();
    }

    //3
    Scanner scanner = new Scanner(System.in);

    System.out.print("Введите количество сотрудников: ");
    int n = scanner.nextInt();
    scanner.nextLine();

    Payable[] employees = new Payable[n];

    for (int i = 0; i < n; i++) {
        System.out.print("Введите имя сотрудника: ");
        String name = scanner.nextLine();

        System.out.print("Введите базовый оклад: ");
        double baseSalary = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Введите тип сотрудника (1 - Manager, 2 - Developer): ");
        int type = scanner.nextInt();
        scanner.nextLine();

        Payable emp = null;
        if (type == 1) {
            emp = new Manager(name, baseSalary);
        } else if (type == 2) {
            emp = new Developer(name, baseSalary);
        } else {
            System.out.println("Неизвестный тип. Используем Developer по умолчанию.");
            emp = new Developer(name, baseSalary);
        }
        employees[i] = emp;
    }

    double totalSalary = 0.0;
    double maxBonusSalary = Double.MIN_VALUE;
    String maxEmployeeName = "";

    for (Payable emp : employees) {
        double pay = emp.calculatePay();
        totalSalary += pay;
        System.out.println(((Employee)emp).getName()+": "+pay);

        if (pay > maxBonusSalary) {
            maxBonusSalary = pay;
            maxEmployeeName = ((Employee) emp).getName();
        }
    }

    System.out.println("\nОбщая сумма выплат: "+totalSalary);
    System.out.println("Наибольшая зарплата с бонусом у "+maxEmployeeName+": "+maxBonusSalary);
}
