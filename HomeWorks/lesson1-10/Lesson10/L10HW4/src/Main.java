import java.util.Scanner;
/*
Написать программу, которая принимает с клавиатуры номер месяца и год
и выводит на экран название месяца и количество дней в нем.
 */
public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Enter the month number: ");
        int monthNum = in.nextInt();
        int ndm = 0; //number of days in month
        String mouth =" ";

        System.out.println("Enter the year: ");
        int year = in.nextInt();

        switch (monthNum) {
            case 1:
                mouth = "January";
                ndm = 31;
                break;
            case 2:
                mouth = "February";
                if ((year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0))) {
                    ndm = 29;
                } else {
                    ndm = 28;
                }
                break;
            case 3:
                mouth ="March";
                ndm = 31;
                break;
            case 4:
                mouth ="April";
                ndm = 30;
                break;
            case 5:
                mouth ="May";
                ndm = 31;
                break;
            case 6:
                mouth ="June";
                ndm = 30;
                break;
            case 7:
                mouth ="July";
                ndm = 31;
                break;
            case 8:
                mouth ="August";
                ndm = 31;
                break;
            case 9:
                mouth ="September";
                ndm = 30;
                break;
            case 10:
                mouth ="October";
                ndm = 31;
                break;
            case 11:
                mouth ="November";
                ndm = 30;
                break;
            case 12:
                mouth ="December";
                ndm = 31;
                break;
            default:
                System.out.println("Wrong input!");
                System.exit(1); //Terminate
                // если ввести неправильно месяц, то нижний sout
                // все равно будет выводить со значением ndm = 0
        }
        System.out.print(mouth + " " + year + " has " + ndm + " days");
    }

}