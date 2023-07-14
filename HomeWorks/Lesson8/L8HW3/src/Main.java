import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Hello. Please enter your first and last name");
        String fullName = br.readLine();

        fullName = fullName.trim();

        String[] parts = fullName.split(" ");
        for ( String part : parts){
            System.out.println((part.substring(0,1).toUpperCase() + part.substring(1)));
        }


    }
}