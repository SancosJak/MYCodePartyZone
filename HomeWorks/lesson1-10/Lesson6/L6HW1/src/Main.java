import java.io.*;


public class Main {
    public static void main(String[] args) throws IOException {

        String text = ("I'm proud to learn Java! Java is the most famous programming language!!!");
        System.out.println(text);

        System.out.println("Последний символ строки : " + text.charAt(text.length() - 1));

        System.out.println("Позиция подстроки “Java” в строке - " + text.indexOf("Java"));

        System.out.println("Содержит ли заданная строка подстроку “Java” - " + text.contains("Java"));

        System.out.println("Замена всех символы “o” на “a” - " + text.replace('o', 'a'));

        System.out.println("Строка к верхнему регистру - " + text.toUpperCase());

        System.out.println("Строка к нижнему регистру - " + text.toLowerCase());

        int startIndex = text.indexOf("J");
        int endIndex = text.indexOf("!");

        String textSub = text.substring(startIndex, endIndex);
        System.out.println("Вырезать подстроку Java из строки - " + textSub);

        System.out.println("Заканчивается ли строка подстрокой “!!!” : " + text.endsWith("!!!"));
        System.out.println("Начинается ли строка подстрокой “I'm proud” : " + text.startsWith("I'm proud"));

        System.out.println("HomeWork by Sandor Ivanyo");
    }
}