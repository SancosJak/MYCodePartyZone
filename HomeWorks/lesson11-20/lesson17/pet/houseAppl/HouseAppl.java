package pet.houseAppl;
/*
Создайте класс Pet (домашние животные) с полями:

тип (кошка, собака, ...)
вес
условия проживания (дома, на улице)
Создайте дочерние классы Cat и Dog c дополнительными полями: имя, порода, возраст.
Создайте метод eat, sleep для обоих классов и метод run (гулять) для класса Dog.
Создайте метод voice, который выдает "Мяу!" для класса Cat и и "Гав-гав!" для класса Dog.
Создайте HouseAppl, в котором есть метод main. Поселите в доме 2 собаки и 3 кошки.
Смоделируйте жизнь в этом доме в течение дня.
 */
import pet.model.Cat;
import pet.model.Dog;

class HouseAppl {
    public static void main(String[] args) {
        Dog dog1 = new Dog("Dog", 10.5, "Indoor", "Charlie", "Labrador", 3);
        Dog dog2 = new Dog("Dog", 8.2, "Outdoor", "Rex", "German Shepherd", 5);

        Cat cat1 = new Cat("Cat", 4.1, "Indoor", "Garfield", "Siamese", 2);
        Cat cat2 = new Cat("Cat", 3.5, "Indoor", "Dixie", "Persian", 4);
        Cat cat3 = new Cat("Cat", 5.0, "Outdoor", "Jessy", "Maine Coon", 1);

        System.out.println("Pet type is - '" + dog1.type + "' and name: " + dog1.getName());
        System.out.println("Breed: " + dog1.breed);
        System.out.println("Age: " + dog1.age + " years old");
        System.out.println("Living Conditions: " + dog1.livingConditions);
        dog1.eat();
        dog1.sleep();
        dog1.voice();
        dog1.run();

        System.out.println();

        System.out.println("Pet type is - '" + dog2.type + "' and name: " + dog2.getName());
        System.out.println("Breed: " + dog2.breed);
        System.out.println("Age: " + dog2.age + " years old");
        System.out.println("Living Conditions: " + dog2.livingConditions);
        dog2.eat();
        dog2.sleep();
        dog2.voice();
        dog2.run();

        System.out.println();

        System.out.println("Pet type is - '" + cat1.type + "' and name: " + cat1.getName());
        System.out.println("Breed: " + cat1.breed);
        System.out.println("Age: " + cat1.age + " years old");
        System.out.println("Living Conditions: " + cat1.livingConditions);
        cat1.eat();
        cat1.sleep();
        cat1.voice();

        System.out.println();

        System.out.println("Pet type is - '" + cat2.type + "' and name: " + cat2.getName());
        System.out.println("Breed: " + cat2.breed);
        System.out.println("Age: " + cat2.age + " years old");
        System.out.println("Living Conditions: " + cat2.livingConditions);
        cat2.eat();
        cat2.sleep();
        cat2.voice();

        System.out.println();

        System.out.println("Pet type is - '" + cat3.type + "' and name: " + cat3.getName());
        System.out.println("Breed: " + cat3.breed);
        System.out.println("Age: " + cat3.age + " years old");
        System.out.println("Living Conditions: " + cat3.livingConditions);
        cat3.eat();
        cat3.sleep();
        cat3.voice();
    }
}
