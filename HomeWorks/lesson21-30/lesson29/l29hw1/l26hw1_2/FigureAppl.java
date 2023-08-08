package l29hw1.l26hw1_2;
/*
Задача 2.
Создайте абстрактный класс Shape с типом поля double и абстрактными методами calcArea и calcPerimeter.
Создать классы Circle, Triangle, Square, расширяющие класс Shape и реализующие абстрактные методы.
Напишите класс FigureAppl с методом main. В методе создайте массив фигур. Добавьте в массив два круга, один треугольник и один квадрат. Рассчитайте общую площадь и общий периметр всех фигур из массива фигур.

Задача 3.(*) Рассчитайте общую площадь кругов из задачи 2.

Нарисовать UML- диаграмму для абстрактного класса Shape и его наследников.
Сделать классы Rectangle и Trapezoid, расширяющие класс Shape.
Реализовать методы расчета площади и периметра для трапеции и прямоугольнике.
Проверить правильность их работы с помощью тестов.
 */
import l29hw1.l26hw1_2.model.*;

public class FigureAppl {
    public static void main(String[] args) {

        Shape[] shapes = new Shape[6];
        shapes[0] =  new Circle(10);
        shapes[1] = new Circle(3);
        shapes[2] =  new Triangle(3, 4, 5);
        shapes[3] =  new Square(4);
        shapes[4] = new Rectangle(5, 10);
        shapes[5] = new Trapezoid(5, 10, 7);


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

        System.out.println("Rectangle Area: " + shapes[4].calcArea());
        System.out.println("Rectangle Perimeter: " + shapes[4].calcPerimeter());

        System.out.println("Trapezoid Area: " + shapes[5].calcArea());
        System.out.println("Trapezoid Perimeter: " + shapes[5].calcPerimeter());

    }
}
