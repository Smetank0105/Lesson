public class Shape {
    private String name;

    public Shape(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public double area() {
        return 0.0;
    }

    public void describe() {
        System.out.println("Фигура: " + name + ", площадь: " + area());
    }
}
