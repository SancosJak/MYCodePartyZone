package userAppl;

import model.Adult;
import model.User;
import java.util.Random;

/*
Создайте собственный класс и его методы из классной групповой работы.
Создайте несколько экземпляров объектов созданного класса.
Выполните действия с помощью методов класса.
 */
public class UserAppl {

    private static String generateRandomName() {
        String[] names = {"Dmitriy", "Sasha", "David", "Ina", "Michael", "Alexandr"};
        Random random = new Random();
        int index = random.nextInt(names.length);
        return names[index];
    }
    private static String generateRandomSurname() {
        String[] surnames = {"Smith", "Johnson", "Williams", "Brown", "Jones", "Garcia"};
        Random random = new Random();
        int index = random.nextInt(surnames.length);
        return surnames[index];
    }

    private static int generateRandomAge() {
        Random random = new Random();
        return random.nextInt(10) + 15;
    }
    private static int generateRandomAgeUnder18() {
        Random random = new Random();
        return random.nextInt(17) + 1;
    }
    private static String generateRandomEmail() {
        String[] domains = {"example.com", "test.com", "domain.com", "email.com"};
        Random random = new Random();
        int index = random.nextInt(domains.length);
        return generateRandomName().toLowerCase() + "@" + domains[index];
    }

    private static String generateRandomPassword() {
        String[] passwordOptions = {"password1", "123456", "qwerty", "letmein", "admin"};
        Random random = new Random();
        int index = random.nextInt(passwordOptions.length);
        return passwordOptions[index];
    }

    private static String generateRandomPhoneNumber() {
        StringBuilder phoneNumber = new StringBuilder("+1");
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            phoneNumber.append(random.nextInt(10));
        }
        return phoneNumber.toString();
    }

    private static String generateRandomIpAddress() {
        Random random = new Random();
        StringBuilder ipAddress = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            ipAddress.append(random.nextInt(256)).append(".");
        }
        return ipAddress.substring(0, ipAddress.length() - 1);
    }
    public static void main(String[] args) {
        int arraySize = 6;
        User[] peopleArray = new User[arraySize];

        for (int i = 0; i < arraySize -1; i++) {
            String firstName = generateRandomName();
            String lastName = generateRandomSurname();
            int age = generateRandomAge();
            String email = generateRandomEmail();
            String password = generateRandomPassword();
            String phoneNumber = generateRandomPhoneNumber();
            String ipAddress = generateRandomIpAddress();

            peopleArray[i] = new Adult(firstName, lastName, age, email, password, phoneNumber, ipAddress);
        }
        // Add an under-18 person
        String firstName = generateRandomName();
        String lastName = generateRandomSurname();
        int age = generateRandomAgeUnder18();
        peopleArray[arraySize - 1] = new User(firstName, lastName, age);

        for (User person : peopleArray) {
            if (person.getAge() >= 18) {
                Adult adult = (Adult) person;
                System.out.println("First Name: " + adult.getFirstName());
                System.out.println("Last Name: " + adult.getLastName());
                System.out.println("Age: " + adult.getAge());
                System.out.println("Email: " + adult.getEmail());
                System.out.println("Password: " + adult.getPassword());
                adult.login();
                System.out.println("Welcome in web-site");
                adult.sendMessage();
                System.out.println("Phone Number: " + adult.getPhoneNumber());
                adult.updateSettings();
                System.out.println("IP Address: " + adult.getIpAddress());
                adult.logout();
                System.out.println();

            } else {
                System.out.println("First Name: " + person.getFirstName());
                System.out.println("Last Name: " + person.getLastName());
                System.out.println("Age: " + person.getAge());
                System.out.println("Access denied. Invalid age. Must be over 18 years old.");
                System.out.println();
            }
        }
    }
}
