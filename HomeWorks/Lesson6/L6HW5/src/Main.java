import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Введите строку: ");
        String text = br.readLine();

        char firstSymbol = text.charAt(0);
        int fisrtIndex = text.indexOf(firstSymbol);
        System.out.println("Первый символ данной строки: " + firstSymbol + " индекс этого символа " + fisrtIndex);

        char lastSymbol = text.charAt(text.length() - 1);
        int lastIndex = text.lastIndexOf(lastSymbol);
        System.out.println("Последний символ данной строки: " + lastSymbol + " индекс этого символа " + lastIndex);

        String result = text.substring(fisrtIndex,lastIndex);
        System.out.println("Результат substring с левым и правым индексом: " + result);

        System.out.println("Результат с левым и правым индексом: " + fisrtIndex + lastIndex);
        System.out.println("HomeWork by Sandor Ivanyo");
    }
}