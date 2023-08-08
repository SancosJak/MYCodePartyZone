package l24hw2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuadEquaSolTest {
    private QuadEquaSol equation1;
    private QuadEquaSol equation2;
    private QuadEquaSol equation3;

    @BeforeEach
    void setUp() {
        equation1 = new QuadEquaSol(1.0, -5.0, 6.0);
        equation2 = new QuadEquaSol(1.0, -4.0, 4.0);
        equation3 = new QuadEquaSol(2.0, 3.0, 4.0);
    }

    @Test
    public void getDiscriminantTest() {
        Double expectedDiscriminant1 = 1.0;
        assertEquals(expectedDiscriminant1, equation1.getDiscriminant());

        Double expectedDiscriminant2 = 0.0;
        assertEquals(expectedDiscriminant2, equation2.getDiscriminant());

        Double expectedDiscriminant3 = -23.0;
        assertEquals(expectedDiscriminant3, equation3.getDiscriminant());
    }
    // Проверка для случая, когда уравнение имеет два корня
    @Test
    public void testTwoRealRoots() {
        QuadEquaSol equation = new QuadEquaSol(1.0, -5.0, 6.0);
        equation.solve();
        Double expectedRoot1 = 3.0;
        Double expectedRoot2 = 2.0;
        assertEquals(expectedRoot1, equation.getX1());
        assertEquals(expectedRoot2, equation.getX2());
    }
    // Проверка для случая, когда уравнение имеет один корень
    @Test
    public void testOneRealRoot() {
        QuadEquaSol equation = new QuadEquaSol(1.0, -4.0, 4.0);
        equation.solve();
        Double expectedRoot = 2.0;
        assertEquals(expectedRoot, equation.getX1());
        assertEquals(expectedRoot, equation.getX2());
    }
    // Проверка для случая, когда уравнение не имеет корней
    @Test
    public void testNoRealRoots() {
        QuadEquaSol equation = new QuadEquaSol(2.0, 3.0, 4.0);
        equation.solve();
        assertNull(equation.getX1());
        assertNull(equation.getX2());
    }
}
