package user_test.model;

public class User {
    private String username;
    private String email;
    private String password;

    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public User() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    /* Пароль валиден, если все требования выполняются:
     - Пароль должен содержать от 8 до 20 символов
     - любые латинские символы (a-z, A-Z);
     - любые цифры;
     - специальные символы: ! @ # $ % ^ & * ( ) - _ + = ; : , ./ ? \ | ` ~ [ ] { }.
     */
    public boolean validatePassword() {
        if (password.length() < 8 || password.length() > 20) {
            return false;
        }
        boolean hasUppercase = false;
        boolean hasLowercase = false;
        boolean hasDigit = false;
        boolean hasSpecialChar = false;

        // Проверка каждого символа пароля
        for (char ch : password.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                hasUppercase = true;
            } else if (Character.isLowerCase(ch)) {
                hasLowercase = true;
            } else if (Character.isDigit(ch)) {
                hasDigit = true;
            } else {
                hasSpecialChar = true;
            }
        }

        return hasUppercase && hasLowercase && hasDigit && hasSpecialChar;
    }

    public boolean validateEmail() {
        // Регулярное выражение для проверки адреса электронной почты
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";

        return email.matches(emailRegex);
    }
}
