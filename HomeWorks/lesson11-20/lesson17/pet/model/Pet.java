package pet.model;

public class Pet {
    public String type;
    public double weight;
    public String livingConditions;

    public Pet(String type, double weight, String livingConditions) {
        this.type = type;
        this.weight = weight;
        this.livingConditions = livingConditions;
    }

    public void eat() {
        System.out.println("The pet is eating.");
    }

    public void sleep() {
        System.out.println("The pet is sleeping.");
    }

}