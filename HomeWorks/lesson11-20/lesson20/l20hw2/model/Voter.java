package model;

import java.time.LocalDate;

public class Voter {
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;

    public Voter(String firstName, String lastName, LocalDate dateOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public boolean checkVoteStatus() {
        LocalDate today = LocalDate.now();
        LocalDate votingAge = dateOfBirth.plusYears(18);
        return votingAge.isBefore(today) || votingAge.isEqual(today);
    }

}
