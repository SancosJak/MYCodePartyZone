package l35hw.dao;

import l35hw.model.Employee;
import l35hw.model.Engineer;
import l35hw.model.Worker;

import java.util.Comparator;

public class EmployeeComparators {
    //public static Comparator<Employee> AgeComparator = Comparator.comparingInt(Employee::getYearOfBirth);
    public static class AgeComparator implements Comparator<Employee> {
        @Override
        public int compare(Employee employee1, Employee employee2) {
            return Integer.compare(employee1.getYearOfBirth(), employee2.getYearOfBirth());
        }
    }

    //public static Comparator<Employee> ExperienceComparator = Comparator.comparingInt(Employee::getExperience);
    public static class ExperienceComparator implements Comparator<Employee> {
        @Override
        public int compare(Employee employee1, Employee employee2) {
            return Integer.compare(employee1.getExperience(), employee2.getExperience());
        }
    }

    public static class SalaryComparator implements Comparator<Employee> {
        @Override
        public int compare(Employee employee1, Employee employee2) {
            if (employee1 instanceof Engineer && employee2 instanceof Engineer) {
                double salary1 = ((Engineer) employee1).calculateSalary();
                double salary2 = ((Engineer) employee2).calculateSalary();
                return Double.compare(salary1, salary2);
            } else if (employee1 instanceof Worker && employee2 instanceof Worker) {
                double salary1 = ((Worker) employee1).calculateSalary();
                double salary2 = ((Worker) employee2).calculateSalary();
                return Double.compare(salary1, salary2);
            }
            return 0;
        }
    }

    // public static Comparator<Employee> EducationComparator = Comparator.comparing(Employee::getEducation, String::compareToIgnoreCase);
    public static class EducationComparator implements Comparator<Employee> {
        @Override
        public int compare(Employee employee1, Employee employee2) {
            return employee1.getEducation().compareToIgnoreCase(employee2.getEducation());
        }
    }
}