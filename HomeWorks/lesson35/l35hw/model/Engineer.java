package l35hw.model;

public class Engineer extends Employee  {
    private double hourlyRate;
    private int hoursWorked;

    public Engineer(String name, int yearOfBirth, int experience, String education, double hourlyRate, int hoursWorked) {
        super(name, yearOfBirth, experience, education);
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public int getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(int hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    @Override
    public String toString() {
        return "Engineer{" +
                "hourlyRate=" + hourlyRate +
                ", hoursWorked=" + hoursWorked +
                "} " + super.toString();
    }

    public double calculateSalary() {
        return hourlyRate * hoursWorked;
    }
}

