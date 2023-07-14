import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Hello! What is your name?");
        String nameInfo = br.readLine();
        System.out.println("Hi, " + nameInfo + ". Nice to meet you");

        System.out.println("How old are you?");
        String ageInfo = br.readLine();

        System.out.println("Where you from?");
        String locationInfo = br.readLine();

        int age = Integer.parseInt(ageInfo);

        System.out.println("Let'summarize: Your name is " + nameInfo + ". You are " + age + " old and you are from " + locationInfo);
        System.out.println("HomeWork by Sandor Ivanyo");
    }
}