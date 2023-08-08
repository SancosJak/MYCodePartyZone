package l26hw1_2.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TriangleTest {

    @Test
    public void testTriangleCalcArea() {
        Triangle triangle = new Triangle(3, 4, 5);
        double expectedArea = 6.0;
        assertEquals(expectedArea, triangle.calcArea(), 0.0001);
    }

    @Test
    public void testTriangleCalcPerimeter() {
        Triangle triangle = new Triangle(3, 4, 5);
        double expectedPerimeter = 12.0;
        assertEquals(expectedPerimeter, triangle.calcPerimeter(), 0.0001);
    }
}