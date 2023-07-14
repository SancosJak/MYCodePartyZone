package user_test.model;
//Написать тесты для методов класса User (валидация email и password).
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    private  User user;

    @BeforeEach
    void setUp() {
       user = new User();
    }

    @Test
    public void validatePasswordTest_ValidPassword_ReturnsTrue() {
        user.setPassword("StrongPassword1@");
        boolean isValid = user.validatePassword();
        assertTrue(isValid);
    }
    @Test
    public void validatePasswordTest_InvalidPassword_ReturnsFalse() {
        user.setPassword("weak");
        boolean isValid = user.validatePassword();
        assertFalse(isValid);
    }

    @Test
    public void validateEmailTest_ValidEmail_ReturnsTrue() {
        user.setEmail("test@example.com");
        boolean isValid = user.validateEmail();
        assertTrue(isValid);
    }

    @Test
    public void validateEmailTest_InvalidEmail_ReturnsFalse() {
        user.setEmail("invalid_email");
        boolean isValid = user.validateEmail();
        assertFalse(isValid);
    }
}