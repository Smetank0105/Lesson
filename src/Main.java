void main() {
    //1
    Dog myDog = new Dog("Барс");
    System.out.println("Имя собаки: " + myDog.getName());
    myDog.makeSound();

    //2
    Car myCar = new Car();
    myCar.setSpeed(-10);
    myCar.setSpeed(60);
    System.out.println("Текущая скорость: " + myCar.getSpeed());
    myCar.setBrand("Toyota");
    System.out.println("Марка автомобиля: " + myCar.getBrand());
    // myCar.speed = -5;
    myCar.setSpeed(90);
    System.out.println("Новая скорость: " + myCar.getSpeed());

    //3
    Scanner scanner = new Scanner(System.in);
    System.out.print("Введите количество сотрудников: ");
    int n = scanner.nextInt();
    scanner.nextLine();

    Employee[] employees = new Employee[n];

    for (int i = 0; i < n; i++) {
        System.out.print("Введите имя сотрудника: ");
        String name = scanner.nextLine();
        System.out.print("Введите базовую зарплату: ");
        double baseSalary = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Введите тип сотрудника (M - Manager, D - Developer): ");
        String type = scanner.nextLine().trim().toUpperCase();
        Employee emp = null;

        switch (type) {
            case "M":
                emp = new Manager(name, baseSalary);
                break;
            case "D":
                emp = new Developer(name, baseSalary);
                break;
            default:
                System.out.println("Некорректный тип, используется Developer по умолчанию.");
                emp = new Developer(name, baseSalary);
                break;
        }
        employees[i] = emp;
    }

    double totalPay = 0.0;
    System.out.println("\nВедомость:");
    System.out.println("Имя\tТип\tБазовая зарплата\tИтоговая зарплата");

    for (Employee e : employees) {
        double pay = e.calculatePay();
        totalPay += pay;
        String typeStr = "unknown";
        if (e instanceof Manager) {
            typeStr = "Manager";
        } else if (e instanceof Developer) {
            typeStr = "Developer";
        }
        System.out.println(e.getName()+"\t"+typeStr+"\t"+e.getBaseSalary()+"\t"+pay);
    }
    System.out.println("\nОбщая сумма выплат: "+totalPay);

    //4
    //Scanner console = new Scanner(System.in);
    System.out.print("Введите количество фигур: ");
    int count = scanner.nextInt();
    scanner.nextLine();

    Shape[] shapes = new Shape[count];

    for (int i = 0; i < count; i++) {
        System.out.print("Тип фигуры (C - круг, R - прямоугольник): ");
        char typeChar = scanner.nextLine().trim().charAt(0);

        Shape shape = null;
        if (typeChar == 'C') {
            System.out.print("Радиус круга: ");
            double radius = Double.parseDouble(scanner.nextLine().trim());
            shape = new Circle(radius);
        } else if (typeChar == 'R') {
            System.out.print("Ширина прямоугольника: ");
            double width = Double.parseDouble(scanner.nextLine().trim());
            System.out.print("Высота прямоугольника: ");
            double height = Double.parseDouble(scanner.nextLine().trim());
            shape = new Rectangle(width, height);
        } else {
            System.out.println("Неизвестный тип фигуры. Используйте 'C' или 'R'. Пропускаем ввод.");
            i--;
            continue;
        }
        shapes[i] = shape;
    }

    System.out.println("\nПлощади фигур:");
    double maxArea = Double.MIN_VALUE;
    Shape maxShape = null;
    for (Shape s : shapes) {
        if (s != null) {
            double area = s.area();
            char type = s.getType();
            System.out.println("Фигура типа "+type+", площадь: "+area);
            if (area > maxArea) {
                maxArea = area;
                maxShape = s;
            }
        }
    }

    if (maxShape != null) {
        System.out.println("\nФигура с максимальной площадью:");
        double maxAreaValue = maxShape.area();
        char maxType = maxShape.getType();
        System.out.println("Тип: "+maxType+", площадь: "+maxAreaValue);
    } else {
        System.out.println("Нет введённых фигур.");
    }

    scanner.close();
}
