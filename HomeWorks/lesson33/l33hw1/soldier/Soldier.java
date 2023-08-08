package soldier;

import java.util.Objects;

public class Soldier implements Comparable<Soldier> {
    private String name;
    private double height;
    private double weight;
    private int profile;

    public Soldier(String name, double height, double weight, int profile) {
        this.name = name;
        this.height = height;
        this.weight = weight;
        this.profile = profile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getProfile() {
        return profile;
    }

    public void setProfile(int profile) {
        if (profile >= 1 && profile <= 99) {
            this.profile = profile;
        } else {
            System.out.println("Profile should be between 1 and 99. Setting default value: 1");
            this.profile = 1;
        }
    }

    @Override
    public String toString() {
        return "Soldier{" +
                "name='" + name + '\'' +
                ", height=" + height +
                ", weight=" + weight +
                ", profile=" + profile +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Soldier soldier = (Soldier) o;
        return Double.compare(soldier.height, height) == 0 && Double.compare(soldier.weight, weight) == 0 && profile == soldier.profile && Objects.equals(name, soldier.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, height, weight, profile);
    }

    @Override
    public int compareTo(Soldier o) {
        int res = (int) (this.height - o.height);
        return res != 0 ? res : -(this.profile - o.profile); // сравнивает по профилям
    }
}
