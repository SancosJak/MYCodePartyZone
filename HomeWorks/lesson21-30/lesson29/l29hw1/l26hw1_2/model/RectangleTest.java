package l29hw1.l26hw1_2.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RectangleTest {

    @Test
    void calcAreaTest() {
        double width = 5;
        double height = 10;

        Rectangle rectangle = new Rectangle(width, height);

        double expectedArea = width * height;
        double actualArea = rectangle.calcArea();

        assertEquals(expectedArea, actualArea, 0.0001);
    }

    @Test
    void calcPerimeterTest() {
        double width = 5;
        double height = 10;

        Rectangle rectangle = new Rectangle(width, height);

        double expectedPerimeter = 2 * (width + height);
        double actualPerimeter = rectangle.calcPerimeter();

        assertEquals(expectedPerimeter, actualPerimeter, 0.0001);
    }
}