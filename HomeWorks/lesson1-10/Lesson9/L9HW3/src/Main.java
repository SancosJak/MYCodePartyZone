import java.util.Scanner;

public class  Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Enter the number of kilometers that the sportsman ran on the first day:");
        double s = in.nextDouble();

        System.out.println("Enter your target:");
        double t = in.nextDouble();

        int day = 1;

        while (s <= t) {
            s = s + (s * 0.1); // 10%
            day++;
        }
        System.out.println("On the " + day + " the athlete reached his goal " + t + " km");
    }
}
