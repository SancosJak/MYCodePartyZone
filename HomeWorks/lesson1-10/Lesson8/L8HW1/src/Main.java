import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Enter a number:");
        String number = br.readLine();
        int n = Integer.parseInt(number);
        //System.out.println("The absolute value (modulus) of a number " + n + " equally " + Math.abs(n));
        String securityAnswer = (n >= 0) ? "The absolute value (modulus) of a number = " + n : "The absolute value (modulus) of a number = " + -n;
        System.out.println(securityAnswer);
    }
}