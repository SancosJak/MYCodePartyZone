package l24hw2;

public class QuadEquaSol {
    private Double a;
    private Double b;
    private Double c;

    public QuadEquaSol(Double a, Double b, Double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public Double getDiscriminant() {
        return Math.pow(b, 2) - 4 * a * c;
    }

    public Double getX1() {
        if (getDiscriminant() < 0) {
            return null;
        } else {
            return (-b + Math.sqrt(getDiscriminant())) / (2 * a);
        }
    }

    public Double getX2() {
        if (getDiscriminant() < 0) {
            return null;
        } else {
            return (-b - Math.sqrt(getDiscriminant())) / (2 * a);
        }
    }
    public void solve() {
        Double discriminant = getDiscriminant();

        if (discriminant > 0) {
            Double root1 = getX1();
            Double root2 = getX2();
            System.out.println("The equation has two roots::");
            System.out.println("Root 1: " + root1);
            System.out.println("Root 2: " + root2);
        } else if (discriminant == 0) {
            Double root = -b / (2 * a);
            System.out.println("The equation has one root:");
            System.out.println("Root: " + root);
        } else {
            System.out.println("The equation has no real roots.");
        }
    }
}

