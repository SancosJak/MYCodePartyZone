package l26hw1_2;
/*
Задача 2.
Создайте абстрактный класс Shape с типом поля double и абстрактными методами calcArea и calcPerimeter.
Создать классы Circle, Triangle, Square, расширяющие класс Shape и реализующие абстрактные методы.
Напишите класс FigureAppl с методом main. В методе создайте массив фигур. Добавьте в массив два круга, один треугольник и один квадрат. Рассчитайте общую площадь и общий периметр всех фигур из массива фигур.

Задача 3.(*) Рассчитайте общую площадь кругов из задачи 2.
 */
import l26hw1_2.model.Shape;
import l26hw1_2.model.Circle;
import l26hw1_2.model.Square;
import l26hw1_2.model.Triangle;

public class FigureAppl {
    public static void main(String[] args) {

        Shape[] shapes = new Shape[4];
        shapes[0] = (Shape) new Circle(10);
        shapes[1] = (Shape) new Circle(3);
        shapes[2] = (Shape) new Triangle(3, 4, 5);
        shapes[3] = (Shape) new Square(4);

        double totalArea = 0;
        for (Shape shape : shapes) {
            totalArea += shape.calcArea();
        }

        double totalPerimeter = 0;
        for (Shape shape : shapes) {
            totalPerimeter += shape.calcPerimeter();
        }

        double totalCircleArea = 0;
        for (Shape shape : shapes) {
            if (shape instanceof Circle) {
                totalCircleArea += shape.calcArea();
            }
        }

        System.out.println("The total area of all shapes: " + totalArea);
        System.out.println("The common perimeter of all shapes: " + totalPerimeter);
        System.out.println("Total area of circles: " + totalCircleArea);

    }
}
