public class Main {
/*
Прочитать статью "Перегрузка и переопределение методов в Java:
примеры" https://timeweb.cloud/tutorials/java/peregruzka-i-pereopredelenie-metodov-v-java-primery
Реализовать свои собственные примеры по типу тех, которые описаны в статье.
 */
    public static class Animal {
        public void makeSound() {
            System.out.println("The animal makes a sound");
        }
    }

    public static class Cat extends Animal {
        @Override
        public void makeSound() {
            System.out.println("The cat meows");
        }
    }

    public static class Dog extends Animal {
        @Override
        public void makeSound() {
            System.out.println("The dog barks");
        }
    }

    public static void main(String[] args) {
        Animal animal = new Animal();
        animal.makeSound();

        Animal cat = new Cat();
        cat.makeSound();

        Animal dog = new Dog();
        dog.makeSound();
    }
}
