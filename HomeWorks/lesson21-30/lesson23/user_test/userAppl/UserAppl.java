package user_test.userAppl;

import user_test.model.User;

public class UserAppl {
    public static void main(String[] args) {
        User user = new User();
        user.setUsername("sasha.ivanyo");
        user.setPassword("qwerty123");
        user.setEmail("sasha@example.com");

        if (user.validatePassword()) {
            System.out.println("The password is valid.");
        } else {
            System.out.println("The password does not meet the requirements.");
        }

        if (user.validateEmail()) {
            System.out.println("The email is valid.");
        } else {
            System.out.println("The email is invalid.");
        }

        User user1 = new User();
        user1.setUsername("jack.sparrow");
        user1.setPassword("Qwerty1@!");
        user1.setEmail("jack.sparrow@example.com");

        if (user1.validatePassword()) {
            System.out.println("The password is valid.");
        } else {
            System.out.println("The password does not meet the requirements.");
        }

        if (user1.validateEmail()) {
            System.out.println("The email is valid.");
        } else {
            System.out.println("The email is invalid.");
        }

        User user2 = new User();
        user2.setUsername("john.doe");
        user2.setPassword("password123");
        user2.setEmail("invalid_email");

        if (user2.validatePassword()) {
            System.out.println("The password is valid.");
        } else {
            System.out.println("The password does not meet the requirements.");
        }

        if (user2.validateEmail()) {
            System.out.println("The email is valid.");
        } else {
            System.out.println("The email is invalid.");
        }
    }
}


