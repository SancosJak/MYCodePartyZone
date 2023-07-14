public class Main1 {
/*
Прочитать статью "Перегрузка и переопределение методов в Java:
примеры" https://timeweb.cloud/tutorials/java/peregruzka-i-pereopredelenie-metodov-v-java-primery
Реализовать свои собственные примеры по типу тех, которые описаны в статье.
 */
    public static void checkAge(int age) {
        if (age < 0) {
            System.out.println("Age cannot be negative!");
        } else if (age < 18) {
            System.out.println("You are " + age + " years old. You are a minor.");
        } else if (age >= 18 && age < 65) {
            System.out.println("You are " + age + " years old. You're an adult.");
        } else {
            System.out.println("You are " + age + " years old. You are an elderly person.");
        }
    }

    public static void checkAge(String name, int age) {
        System.out.print(name + ", ");
        checkAge(age);
    }

    public static void main(String[] args) {
        checkAge(15); // вызывается метод checkAge(int age)
        checkAge("Guest", 30); // вызывается метод checkAge(String name, int age)
        checkAge(70); // вызывается метод checkAge(int age)
    }
    /*
    Первый метод принимает только возраст (int age) и выполняет проверку и выводит описание возрастной группы.
    Второй метод принимает имя (String name) и возраст (int age), а затем вызывает первый метод, добавляя имя в вывод.
    Таким образом, мы можем вызывать метод checkAge с одним или двумя аргументами.
     */
}
