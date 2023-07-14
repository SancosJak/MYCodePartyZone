package model;

public class Adult extends User {
    private String email;
    private String password;
    private String phoneNumber;
    private String ipAddress;

    public Adult(String firstName, String lastName, int age, String email, String password, String phoneNumber, String ipAddress) {
        super(firstName, lastName, age);
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.ipAddress = ipAddress;
    }

    @Override
    public String toString() {
        return "Adult{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", ipAddress='" + ipAddress + '\'' +
                '}';
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }
    public void resetPass() {
        System.out.println("Resetting password...");
    }
    public void quickLogIn() {
        System.out.println("Performing quick login by Facebook or Google...");
    }

}
