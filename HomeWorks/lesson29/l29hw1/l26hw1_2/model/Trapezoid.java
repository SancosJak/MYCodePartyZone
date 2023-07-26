package l29hw1.l26hw1_2.model;

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
        double side1 = side;
        double side2 = sideB;
        double side3 = Math.sqrt(Math.pow((sideB - side) / 2, 2) + h * h);
        double side4 = Math.sqrt(Math.pow((sideB - side) / 2, 2) + h * h);
        return side1 + side2 + side3 + side4;
        //return side + sideB + side1 + side2;
    }
}