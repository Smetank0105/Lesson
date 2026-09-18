public record Rectangle(double width, double height) implements Shape {
    public Rectangle {
        if (width <= 0) {
            throw new IllegalArgumentException("Width должна быть положительной");
        }
        if (height <= 0) {
            throw new IllegalArgumentException("Height должна быть положительной");
        }
    }

    @Override
    public double area() {
        return width * height;
    }

    @Override
    public double perimeter() {
        return 2 * (width + height);
    }

    public static Rectangle square(double side) {
        if (side <= 0) {
            throw new IllegalArgumentException("Side должна быть положительной");
        }
        return new Rectangle(side, side);
    }
}