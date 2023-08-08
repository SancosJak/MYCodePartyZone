package l35hw.model;

import java.util.Objects;

public abstract class Employee {
    private String name;
    private int yearOfBirth;
    private int experience;
    private String education;

    public Employee(String name, int yearOfBirth, int experience, String education) {
        this.name = name;
        this.yearOfBirth = yearOfBirth;
        this.experience = experience;
        this.education = education;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", yearOfBirth=" + yearOfBirth +
                ", experience=" + experience +
                ", education='" + education + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return yearOfBirth == employee.yearOfBirth && experience == employee.experience && Objects.equals(name, employee.name) && Objects.equals(education, employee.education);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, yearOfBirth, experience, education);
    }
}

