package sentence;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SentenceTest {
    Sentence sentence;

    @BeforeEach
    void setUp() {
        sentence = new Sentence("It`s my text");
    }

    @Test
    void countWordsTest() {
        String st = "Hello and Bye";
        assertEquals(3, sentence.countWords(st));
    }

    @Test
    void countLettersTest() {
        String st = "I write to you, what else...";
        assertEquals(19, sentence.countLetters(st));
    }
}