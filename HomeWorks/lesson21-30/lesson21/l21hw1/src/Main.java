/*
Выполнить все упражнения, которые мы делали на занятии со строкой.
В качестве примера строки взять свое слово или короткое предложение,
например, "Меня зовут Имя и Фамилия"
 */
public class Main {
    public static void main(String[] args) {
        String text = "My name is Sandor Ivanyo";
        System.out.println(text);

        int length = text.length();
        System.out.println("Text length: " + length);

        char charAtIndex = text.charAt(3);
        System.out.println("Symbol at e.q. index 3: " + charAtIndex);

        String text1 = "my name is sandor ivanyo";
        boolean equalsIgnoreCase = text.equalsIgnoreCase(text1);
        System.out.println("Texts are case-insensitive ?/!: " + equalsIgnoreCase);

        String upperText = text.toUpperCase();
        String lowerText = text.toLowerCase();
        System.out.println("Uppercase text: " + upperText);
        System.out.println("Lowercase text: " + lowerText);

        int indexOfSubstring = text.indexOf("name");
        int indexOfChar = text.indexOf('i');
        System.out.println("The index of the first occurrence of the substring 'name': " + indexOfSubstring);
        System.out.println("Index of the first occurrence of the 'i' symbol: " + indexOfChar);

        int lastIndexOfSubstring = text.lastIndexOf("o");
        int lastIndexOfChar = text.lastIndexOf('n');
        System.out.println("The index of the last occurrence of the substring 'o': " + lastIndexOfSubstring);
        System.out.println("Index of the last occurrence of the symbol 'n': " + lastIndexOfChar);

        String substring = text.substring(3, 7);
        System.out.println("Substring: " + substring);

        String replacedText = text.replace("Sandor Ivanyo", "FirstName LastName");
        System.out.println("Replaced text: " + replacedText);

        String trimmedText = text.trim();
        System.out.println("Trimmed text: " + trimmedText);

        String[] substrings = text.split(" ");
        System.out.println("Separated substrings:");
        for (String sub : substrings) {
            System.out.println(sub);
        }
    }
}
