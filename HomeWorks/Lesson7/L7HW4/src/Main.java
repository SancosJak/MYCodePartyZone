import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Введите год:");
        String god = br.readLine();
        int year = Integer.parseInt(god);

        if ( ( ( year % 4 == 0 ) && ( year % 100 != 0 ) ) || ( year% 400 == 0 ) ) {
            System.out.println(year + " год является високосным.");
        }
        else {
            System.out.println(year + " год не является високосным.");
        }

        System.out.println("HomeWork by Sandor Ivanyo");
    }
}