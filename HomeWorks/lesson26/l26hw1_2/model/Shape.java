package l26hw1_2.model;

public abstract class Shape {
    protected final double side;

    public Shape(double side) {
        this.side = side;
    }

    public abstract double calcArea();
    public abstract double calcPerimeter();
}