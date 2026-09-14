void main() {
    //1
    Scanner scanner = new Scanner(System.in);
    int n = 4;

    Person[] people = new Person[n];

    System.out.println("Введите 4 человека. Для каждого выберите тип:");
    System.out.println("1 — Person, 2 — Student");
    for (int i = 0; i < n; i++) {
        System.out.print("Тип (" + (i + 1) + "): 1 — Person, 2 — Student > ");
        int type = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Имя: ");
        String name = scanner.nextLine();

        System.out.print("Возраст: ");
        int age = scanner.nextInt();
        scanner.nextLine();

        if (type == 1) {
            people[i] = new Person(name, age);
        } else if (type == 2) {
            System.out.print("Оценка (от 0 до 10): ");
            double grade = scanner.nextDouble();
            scanner.nextLine();

            people[i] = new Student(name, age, grade);
        } else {
            System.err.println("Неправильный выбор типа! Пропускаем.");
            people[i] = new Person("John Doe", 0);
            continue;
        }
    }

    System.out.println("\nИнформация о всех людях:");
    for (Person p : people) {
        p.displayInfo();
    }


    //2
    BankAccount[] accounts = new BankAccount[] {
            new SavingsAccount("Nick", 1000.0, 0.05),
            new CheckingAccount("Mike", 800.0, 10.0),
            new SavingsAccount("Sam", 2000.0, 0.03),
            new CheckingAccount("Dean", 500.0, 5.0)
    };

    double totalBalance = 0.0;

    for (BankAccount acc : accounts) {
        totalBalance += acc.calculateYearlyReport();
        System.out.println("Owner: "+acc.getOwner()+", Balance: "+acc.getBalance()+", After Year: "+acc.calculateYearlyReport());
    }
    System.out.println();
    System.out.println("Total forecasted balance after year: " + totalBalance);

    //3
    System.out.println("Введите количество фигур:");
    n = Integer.parseInt(scanner.nextLine());

    Shape[] shapes = new Shape[n];

    for (int i = 0; i < n; i++) {
        System.out.println("Введите тип фигуры (c - circle/r - rectangle), затем имя, затем параметры:");
        String type = scanner.nextLine().trim().toLowerCase();
        String name = scanner.nextLine().trim();

        if (type.equals("c")) {
            System.out.println("Введите радиус:");
            double radius = Double.parseDouble(scanner.nextLine().trim());
            shapes[i] = new Circle(name, radius);
        } else if (type.equals("r")) {
            System.out.println("Введите ширину:");
            double width = Double.parseDouble(scanner.nextLine().trim());
            System.out.println("Введите высоту:");
            double height = Double.parseDouble(scanner.nextLine().trim());
            shapes[i] = new Rectangle(name, width, height);
        } else {
            System.out.println("Неизвестный тип, используем квадрат как заглушку");
            shapes[i] = new Rectangle(name, 0, 0);
        }
    }

    for (Shape shape : shapes) {
        shape.describe();
    }

    //4
    ComparableStudent[] students = new ComparableStudent[5];

    System.out.println("Введите 5 студентов (имя и средняя оценка, разделенные пробелом):");
    for (int i = 0; i < 5; i++) {
        System.out.print((i + 1) + ". ");
        String line = scanner.nextLine().trim();
        String[] parts = line.split(" ");
        if (parts.length < 2) {
            System.out.println("Ошибка ввода. Введите имя и оценку.");
            i--;
            continue;
        }
        String name = parts[0];
        try {
            double avgGrade = Double.parseDouble(parts[1]);
            students[i] = new ComparableStudent(name, avgGrade);
        } catch (NumberFormatException e) {
            System.out.println("Ошибка: средняя оценка должна быть числом.");
            i--;
            continue;
        }
    }

    Arrays.sort(students);

    System.out.println("\nСписок студентов, отсортированных по возрастанию средней оценки:");
    for (ComparableStudent s : students) {
        System.out.println(s);
    }


    scanner.close();
}
