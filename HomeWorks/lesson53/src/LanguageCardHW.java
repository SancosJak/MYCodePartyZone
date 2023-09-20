import java.util.*;

public class LanguageCardHW {
    private final HashMap<String, String> wordMap = new HashMap<>();
    private final HashMap<String, Integer> wrongAnswersMap = new HashMap<>();//Storage for the number of incorrect
    private final Scanner scanner; //Declaring Scanner as a Class Field

    public LanguageCardHW() {
        scanner = new Scanner(System.in); //Initialize the Scanner in the constructor
    }
    public void addWord(String foreignWord, String nativeWord) {
        wordMap.put(foreignWord, nativeWord);
        wrongAnswersMap.put(foreignWord, 0); //Initialize the number of incorrect answers for a new word with zero
    }

    public void practice() {
        if (wordMap.isEmpty()) {
            System.out.println("Словарь пуст. Пожалуйста, добавьте слова для практики.");
            return;
        }

        Random random = new Random();

        //Program will run until you enter "exit"
        while (true) {
            ArrayList<String> keys = new ArrayList<>(wordMap.keySet());
            String randomKey = keys.get(random.nextInt(keys.size()));
            String correctAnswer = wordMap.get(randomKey);

            System.out.println("Каков перевод слова " + randomKey + "?");
            String userAnswer = scanner.nextLine();

            if (userAnswer.equalsIgnoreCase("exit")) {
                break;
            }

            if (correctAnswer.equalsIgnoreCase(userAnswer)) {
                System.out.println("Верно!");
            } else {
                System.out.println("Неверно! Правильный ответ: " + correctAnswer);
                wrongAnswersMap.put(randomKey, wrongAnswersMap.get(randomKey) + 1);
            }
        }
    }

    // new method
    public void practiceDifficultWords() {
        if (wrongAnswersMap.isEmpty()) {
            System.out.println("Нет ошибочных слов для практики.");
            return;
        }
        for (Map.Entry<String, Integer> entry : wrongAnswersMap.entrySet()) {
            String word = entry.getKey();
            int incorrectCount = entry.getValue();
            if (incorrectCount > 0) {
                System.out.println("Слово: " + word + ", Количество неправильных ответов: " + incorrectCount);
            }
        }
    }

    public static void main(String[] args) {
        LanguageCardHW myCard = new LanguageCardHW();
        myCard.addWord("apple", "яблоко");
        myCard.addWord("dog", "собака");
        myCard.addWord("hello", "привет");

        System.out.println("Для завершения работы программы введите 'exit'.");

        myCard.practice();
        myCard.practiceDifficultWords(); //Starting the practice of erroneous words

        myCard.scanner.close();
    }
}
