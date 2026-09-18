void main() {
    //1
//    Temperature t1 = new Temperature(-300);

    Temperature t2 = new Temperature(25);
    double fahrenheit = t2.toFahrenheit();
    System.out.println(fahrenheit);

    //2
    Shape s = new Rectangle(3, 4);

    double area = s.area();
    System.out.println("Area: " + area);

    Shape squareShape = Rectangle.square(5);
    System.out.println("Square area: " + squareShape.area());
    System.out.println("Square perimeter: " + squareShape.perimeter());
}
