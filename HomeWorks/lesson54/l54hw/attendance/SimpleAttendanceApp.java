package attendance;

import attendance.dao.AttendanceTracker;

import java.time.LocalDate;

public class SimpleAttendanceApp {
    public static void main(String[] args) {

        AttendanceTracker tracker = new AttendanceTracker();

        tracker.addStudent("Spider-Man");
        tracker.addStudent("Iron Man");
        tracker.addStudent("Captain America");
        tracker.addStudent("Thor");
        tracker.addStudent("Black Widow");

        tracker.addLessonDate(LocalDate.of(2023, 9, 1));
        tracker.addLessonDate(LocalDate.of(2024, 10, 5));
        tracker.addLessonDate(LocalDate.of(2025, 11, 10));

        tracker.markAttendance("Spider-Man", LocalDate.of(2023, 9, 1), true);
        tracker.markAttendance("Iron Man", LocalDate.of(2023, 9, 1), true);
        tracker.markAttendance("Captain America", LocalDate.of(2023, 9, 1), false);
        tracker.markAttendance("Thor", LocalDate.of(2023, 9, 1), true);
        tracker.markAttendance("Black Widow", LocalDate.of(2023, 9, 1), false);

        tracker.markAttendance("Spider-Man", LocalDate.of(2024, 10, 5), true);
        tracker.markAttendance("Iron Man", LocalDate.of(2024, 10, 5), false);
        tracker.markAttendance("Captain America", LocalDate.of(2024, 10, 5), true);
        tracker.markAttendance("Thor", LocalDate.of(2024, 10, 5), true);
        tracker.markAttendance("Black Widow", LocalDate.of(2024, 10, 5), false);

        tracker.markAttendance("Spider-Man", LocalDate.of(2025, 11, 10), false);
        tracker.markAttendance("Iron Man", LocalDate.of(2025, 11, 10), false);
        tracker.markAttendance("Captain America", LocalDate.of(2025, 11, 10), true);
        tracker.markAttendance("Thor", LocalDate.of(2025, 11, 10), true);
        tracker.markAttendance("Black Widow", LocalDate.of(2025, 11, 10), true);

        tracker.printAllAttendance();

        tracker.printStudentAttendance("Iron Man");
    }
}
