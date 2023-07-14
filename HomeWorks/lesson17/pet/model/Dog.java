package pet.model;

public class Dog extends Pet {
    public String name;
    public String breed;
    public int age;

    public Dog(String type, double weight, String livingConditions, String name, String breed, int age) {
        super(type, weight, livingConditions);
        this.name = name;
        this.breed = breed;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void voice() {
        System.out.println("Гав-гав!");
    }

    public void run() {
        System.out.println("The dog is running.");
    }

}