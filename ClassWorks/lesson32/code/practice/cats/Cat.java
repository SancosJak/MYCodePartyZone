package practice.cats;

import java.util.Objects;

public class Cat implements Comparable <Cat> {
    private String name; //кличка
    private int age;
    private String color;
    private double weight;

    public Cat(String name, int age, String color, double weight) {
        this.name = name;
        this.age = age;
        this.color = color;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + ", age=" + age + ", color='" + color + ", weight=" + weight +'}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cat cat = (Cat) o;
        return age == cat.age && Double.compare(cat.weight, weight) == 0 && name.equals(cat.name) && color.equals(cat.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, color, weight);
    }

    // rules for sorting
    @Override
    public int compareTo(Cat o) {
        //return this.age - o.age; // compare by age up
        //return o.age - this.age; // compare by age down

        //return this.name.compareTo(o.name); //compare by name a-z
        // return o.name.compareTo(this.name); //compare by name z-a
        //or make "-" before for change sorting by a-z, z-a

        //sort by name and age
        int res1 = this.name.compareTo(o.name); //name
        int res2 = this.age - o.age; //age
        int res = 0;
        if (res1 <= 0 && res2 <= 0){
            res = 1;
        } else {
            res = -1;
        }
        return res;

    }
}
