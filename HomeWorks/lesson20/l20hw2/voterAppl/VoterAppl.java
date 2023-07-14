package voterAppl;
/*
Реализовать класс Избиратель.
Обеспечить невозможность регистрации в качестве избирателя лица, которому еще не исполнилось 18 лет.
 */
import model.Voter;
import java.time.LocalDate;
import java.util.Scanner;

public class VoterAppl {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your first name: ");
        String firstName = scanner.nextLine();

        System.out.print("Enter your last name: ");
        String lastName = scanner.nextLine();

        System.out.print("Enter your date of birth (YYYY-MM-DD): ");
        String date = scanner.nextLine();
        LocalDate dateOfBirth = LocalDate.parse(date);

        Voter voter = new Voter(firstName, lastName, dateOfBirth);

        if (voter.checkVoteStatus()) {
            System.out.println("Congratulations, " + voter.getFirstName() + " " + voter.getLastName() + "! You are allowable to vote.");
        } else {
            System.out.println("Sorry, " + voter.getFirstName() + " " + voter.getLastName() + ". You are not allowable to vote yet.");
        }
    }
}


