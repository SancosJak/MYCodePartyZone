package model;
public class User {
    private String firstName;
    private String lastName;
    private int age;

    public User(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    public void login() {
        System.out.println("Logging in...");
    }

    public void logout() {
        System.out.println("Logging out...");
    }

    public void sendMessage() {
        System.out.println("Sending message...");
    }

    public void updateSettings() {
        System.out.println("Updating settings...");
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                '}';
    }
    public void checkAge() {
        if (age < 0 || age > 150) {
            System.out.println("Invalid age!");
        } else if (age < 18) {
            System.out.println("Must be over 18 years old!");
        }
    }
}
