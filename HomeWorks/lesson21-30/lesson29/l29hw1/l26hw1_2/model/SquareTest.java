package l29hw1.l26hw1_2.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SquareTest {

    @Test
    public void testSquareCalcArea() {
        Square square = new Square(4);
        double expectedArea = 16.0;
        assertEquals(expectedArea, square.calcArea(), 0.0001);
    }

    @Test
    public void testSquareCalcPerimeter() {
        Square square = new Square(4);
        double expectedPerimeter = 16.0;
        assertEquals(expectedPerimeter, square.calcPerimeter(), 0.0001);
    }
}