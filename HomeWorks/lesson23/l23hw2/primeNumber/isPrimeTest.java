package primeNumber;
//Для метода проверки, является ли число простым, написать тест.
// Использовать assert для логических выражений.
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class isPrimeTest {
    isPrime isPrime;

    @BeforeEach
    void setUp() {
        isPrime = new isPrime();
    }

    @Test
    void isNumberPrime() {
        int num = 3;
        assertTrue(isPrime.isNumberPrime(num));
    }
}