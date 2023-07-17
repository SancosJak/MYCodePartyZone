package l26hw1_2.model;

public class Circle extends Shape {
    public Circle(double radius) {
        super(radius);
    }

    @Override
    public double calcArea() {
        return Math.PI * side * side;
    }

    @Override
    public double calcPerimeter() {
        return 2 * Math.PI * side;
    }
}