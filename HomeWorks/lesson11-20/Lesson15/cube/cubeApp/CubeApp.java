package cube.cubeApp;
import cube.model.Cube;

public class CubeApp {

    public static void main(String[] args) {

        Cube cube1 = new Cube(7);
        Cube cube2 = new Cube(10);
        Cube cube3 = new Cube(5);

        double p1 = cube1.getPerimeter(7);
        System.out.println("The perimeter of the cube is: " + p1);
        double p2 = cube2.getPerimeter(10);
        System.out.println("The perimeter of the cube is: " + p2);
        double p3 = cube3.getPerimeter(5);
        System.out.println("The perimeter of the cube is: " + p3);


        double s1 = cube1.getArea(7);
        System.out.println("The Square of the Cube is: " + s1);
        double s2 = cube2.getArea(10);
        System.out.println("The Square of the Cube is: " + s2);
        double s3 = cube3.getArea(5);
        System.out.println("The Square of the Cube is: " + s3);

        double v1 = cube1.getVolume(7);
        System.out.println("The volume of the cube is: " + v1);
        double v2 = cube2.getVolume(10);
        System.out.println("The volume of the cube is: " + v2);
        double v3 = cube3.getVolume(5);
        System.out.println("The volume of the cube is: " + v3);
    }
}
