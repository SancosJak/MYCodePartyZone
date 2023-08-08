package l29hw1.l26hw1_2.model;

public class Triangle extends Shape {
    private final double sideB;
    private final double sideC;

    public Triangle(double sideA, double sideB, double sideC) {
        super(sideA);
        this.sideB = sideB;
        this.sideC = sideC;
    }

    @Override
    public double calcArea() {
        // по формуле Герона
        double s = (side + sideB + sideC) / 2;
        return Math.sqrt(s * (s - side) * (s - sideB) * (s - sideC));
    }

    @Override
    public double calcPerimeter() {
        return side + sideB + sideC;
    }
}