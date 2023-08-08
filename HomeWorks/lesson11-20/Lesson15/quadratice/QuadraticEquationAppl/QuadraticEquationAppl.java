package quadratice.QuadraticEquationAppl;

public class QuadraticEquationAppl {
    public double a;
    public double b;
    public double c;

    public QuadraticEquationAppl(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    public double discriminant() {
        return b * b - 4 * a * c;
    }

    public int determineNumberOfRoots() {
        double discriminant = discriminant();
        if (discriminant > 0) {
            return 2; // Два корня
        } else if (discriminant == 0) {
            return 1; // Один корень
        } else {
            return 0; // Корней нет
        }
    }
}
