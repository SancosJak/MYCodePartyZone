package quadratice.Equation;
import quadratice.QuadraticEquationAppl.QuadraticEquationAppl;
/*
Создать класс, описывающий квадратные уравнения с коэффициетами a, b и c. Реализовать в нем методы:
вычисления дискриминанта b*b - 4 * a *c
определения количества корней в зависимости от значения дискриминанта
(d>0 - два корня, d=0 - один корень, d<0 - корней нет)
Вызвать методы из приложения QuadraticEquationAppl
 */

public class QuadraticEquation {

    public static void main(String[] args) {
        QuadraticEquationAppl equation = new QuadraticEquationAppl(1, -3, 2); // D > 0, roots: 2
       // QuadraticEquationAppl equation1 = new QuadraticEquationAppl(2, 4, 2); // D = 0, roots: 1
       // QuadraticEquationAppl equation2 = new QuadraticEquationAppl(3, 2, 5); // D < 0, roots: 0

        double discriminant = equation.discriminant();
        System.out.println("Дискриминант: " + discriminant);

        int numberOfRoots = equation.determineNumberOfRoots();
        System.out.println("Количество корней: " + numberOfRoots);

    }
}
