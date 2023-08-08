package l26hw1_2.model;

public class Rectangle extends Shape {
      private final double height;

    public Rectangle(double weight, double height) {
        super(weight); //side
        this.height = height;
    }

    @Override
    public double calcArea() {
        return side * height;
    }

    @Override
    public double calcPerimeter() {
        return 2 * (side + height);
    }
}