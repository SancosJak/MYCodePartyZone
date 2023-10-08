package attendance;

import attendance.dao.AttendanceTracker;
import attendance.model.AttendanceAction;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class AttendanceTrackerApp {
    public static void main(String[] args) {
        AttendanceTracker tracker = new AttendanceTracker();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            AttendanceAction.printMenu();
            System.out.print("Выберите действие: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            AttendanceAction action = null;
            for (AttendanceAction enumAction : AttendanceAction.values()) {
                if (enumAction.getMenuItem() == choice) {
                    action = enumAction;
                    break;
                }
            }

            if (action == null) {
                System.out.println("Некорректный выбор. Пожалуйста, выберите снова.");
                continue;
            }

            switch (action) {
                case ADD_STUDENT:
                    System.out.print("Введите имя ученика: ");
                    String studentName = scanner.nextLine();
                    tracker.addStudent(studentName);
                    break;
                case ADD_LESSON_DATE:
                    LocalDate lessonDate = null;
                    boolean validDate = false;
                    while (!validDate) {
                        try {
                            System.out.print("Введите дату урока (гггг-мм-дд): ");
                            String inputDate = scanner.nextLine();
                            lessonDate = LocalDate.parse(inputDate);
                            validDate = true;
                        } catch (DateTimeParseException e) {
                            System.out.println("Некорректный формат даты. Пожалуйста, используйте формат гггг-мм-дд.");
                        }
                    }
                    tracker.addLessonDate(lessonDate);
                    break;
                case MARK_ATTENDANCE:
                    System.out.print("Введите имя ученика: ");
                    String name = scanner.nextLine();
                    LocalDate lessonDateForMark = null;
                    boolean validDateForMark = false;
                    while (!validDateForMark) {
                        try {
                            System.out.print("Введите дату урока (гггг-мм-дд): ");
                            String inputDate = scanner.nextLine();
                            lessonDateForMark = LocalDate.parse(inputDate);
                            validDateForMark = true;
                        } catch (DateTimeParseException e) {
                            System.out.println("Некорректный формат даты. Пожалуйста, используйте формат гггг-мм-дд.");
                        }
                    }
                    System.out.print("Посещение (true/false): ");
                    boolean attended = scanner.nextBoolean();
                    tracker.markAttendance(name, lessonDateForMark, attended);
                    break;
                case PRINT_ALL_ATTENDANCE:
                    tracker.printAllAttendance();
                    break;
                case PRINT_STUDENT_ATTENDANCE:
                    System.out.print("Введите имя ученика: ");
                    String studentNameToPrint = scanner.nextLine();
                    tracker.printStudentAttendance(studentNameToPrint);
                    break;
                case EXIT:
                    System.out.println("Выход из программы.");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Некорректный выбор. Пожалуйста, выберите снова.");
                    break;
            }
        }
    }
}
