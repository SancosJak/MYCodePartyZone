package practice;
// Создать класс Person, в котором будет скрыто поле password и будет доступный метод для изменения пароля.
public class Person {
    private  String password;

    public void setPassword(String password) {
        this.password = password;
    }

    public String getInfo() {
        return "This is a person with a password: " + password;
    }
    public static void main(String[] args) {
        Person person = new Person();

        person.setPassword("mySecretPassword");

        System.out.println(person.getInfo());
    }
}
