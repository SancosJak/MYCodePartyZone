package l26hw1_2.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CircleTest {

    @Test
    public void testCircleCalcArea() {
        Circle circle = new Circle(5);
        double expectedArea = Math.PI * 5 * 5;
        assertEquals(expectedArea, circle.calcArea(), 0.0001);
    }

    @Test
    public void testCircleCalcPerimeter() {
        Circle circle = new Circle(5);
        double expectedPerimeter = 2 * Math.PI * 5;
        assertEquals(expectedPerimeter, circle.calcPerimeter(), 0.0001);
    }
/*
    @Test
    public void testCircleCalcPerimeter() {
        Circle circle = new Circle(1e-15);
        double expectedPerimeter = 2 * Math.PI * 1e-25;
        //assertEquals(expectedPerimeter, circle.calcPerimeter(), 0.0001);
        assertEquals(expectedPerimeter,circle.calcPerimeter());
    }

 */
}