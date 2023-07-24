package l26hw1_2.model;

public class Trapezoid extends Shape {
    private final double sideB;
    private final double h;

    public Trapezoid(double sideA, double sideB, double h) {
        super(sideA);   //side
        this.sideB = sideB;
        this.h = h;
    }

    @Override
    public double calcArea() {
        return 0.5 * (side + sideB) * h;
    }

    @Override
    public double calcPerimeter() {
        double side1 = Math.sqrt(Math.pow((sideB - side) / 2, 2) + h * h);
        double side2 = Math.sqrt(Math.pow((sideB - side) / 2, 2) + h * h);
        return side + sideB + side1 + side2;
    }
}