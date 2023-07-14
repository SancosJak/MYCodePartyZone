import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Введите строку разной длины (длина - чётное число):");
        String text = br.readLine();
        int dlina = text.length();

        if (dlina % 2 == 0 )
        {
            int mid = dlina / 2;
            String result = text.substring(mid - 1, mid + 1);
            System.out.println("Два средних знака этой строки: " + result);
        }
        else
            System.out.println("Не соблюдены условия задачи:  ДЛИНА - ЧЁТНОЕ ЧИСЛО ");

        System.out.println("HomeWork by Sandor Ivanyo");
    }
}