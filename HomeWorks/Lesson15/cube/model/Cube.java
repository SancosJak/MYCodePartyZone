package cube.model;
/*
Создать класс Cube, описывающий куб cо стороной a.
Реализовать в нем методы определения периметра p, площади s и объема v.
Создать приложение CubeAppl, в котором создать несколько экземпляров класса Cube.
Для каждого экземпляра вызвать методы класса Cube и рассчитать p, s и v.
 */
public class Cube{
    public double storonaCuba;

    public Cube(double storonaCuba) {
        this.storonaCuba = storonaCuba;
    }

    public double getPerimeter(double storonaCuba) {
        return 12 * storonaCuba;
    }

    public double getArea(double storonaCuba) {
        return Math.pow(storonaCuba, 2) * 6;
    }

    public double getVolume(double storonaCuba) {
        return Math.pow(storonaCuba,3);
    }
}
