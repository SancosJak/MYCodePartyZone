package practice;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class ReadFileByWords {
    public static void main(String[] args) {
        List<String> words = readFileByWords("C:/Users/AIT TR Student/IdeaProjects/untitled/ClassWorks/lesson53/l53cw/practice/file.txt");

        ArrayList<LinkedList<String>> buckets = new ArrayList<>(16);
        for (int i = 0; i < 16; i++) {
            buckets.add(new LinkedList<String>());
        }

        words.forEach(i -> buckets.get(i.hashCode() & 0xF).add(i));

        for (LinkedList<String> bucket : buckets) {
            System.out.println(bucket.size() + " : " + bucket);
        }
    }

    public static List<String> readFileByWords(String filename) {
        List<String> wordList = new ArrayList<>();
        Set<String> uniqueWords = new HashSet<>(); // use SET

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;

//            while ((line = br.readLine()) != null) {
//                String[] words = line.split("\\s+");  // Разделяем строку на слова по пробелам
//                wordList.addAll(Arrays.asList(words));
//            }

            while ((line = br.readLine()) != null) {
                String[] words = line.split("\\s+");
                for (String word : words) {
                    if (uniqueWords.add(word)) { // Check if the word is unique
                        wordList.add(word);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return wordList;
    }
}
