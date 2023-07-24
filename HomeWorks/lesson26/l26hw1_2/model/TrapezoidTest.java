package l26hw1_2.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TrapezoidTest {

    @Test
    void calcAreaTest() {
        double sideA = 5;
        double sideB = 7;
        double height = 10;

        Trapezoid trapezoid = new Trapezoid(sideA, sideB, height);

        double expectedArea = 0.5 * (sideA + sideB) * height;
        double actualArea = trapezoid.calcArea();

        assertEquals(expectedArea, actualArea, 0.0001);
    }

    @Test
    void calcPerimeterTest() {
        double sideA = 5;
        double sideB = 7;
        double height = 10;

        Trapezoid trapezoid = new Trapezoid(sideA, sideB, height);

        double side1 = Math.sqrt(Math.pow((sideB - sideA) / 2, 2) + height * height);
        double side2 = Math.sqrt(Math.pow((sideB - sideA) / 2, 2) + height * height);
        double expectedPerimeter = sideA + sideB + side1 + side2;
        double actualPerimeter = trapezoid.calcPerimeter();

        assertEquals(expectedPerimeter, actualPerimeter, 0.0001);
    }
}