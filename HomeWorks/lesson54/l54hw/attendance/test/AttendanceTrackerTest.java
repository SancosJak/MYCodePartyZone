package attendance.test;

import attendance.dao.AttendanceTracker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDate;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class AttendanceTrackerTest {

    private AttendanceTracker attendanceTracker;

    @BeforeEach
    public void setUp() {
        attendanceTracker = new AttendanceTracker();
    }

    @Test
    public void testAddStudent() {
        attendanceTracker.addStudent("Spider-Man");
        attendanceTracker.addStudent("Iron Man");

        assertNotNull(attendanceTracker.getStudent("Spider-Man"));
        assertTrue(attendanceTracker.getStudent("Iron Man") != null);
        assertNull(attendanceTracker.getStudent("Captain America"));

        String studentName = "Thanos";
        attendanceTracker.addStudent(studentName);
        assertTrue(attendanceTracker.getStudentAttendance(studentName).isEmpty());
    }

    @Test
    public void testAddLessonDate() {

        LocalDate lessonDate = LocalDate.of(2023, 12, 1);
        attendanceTracker.addLessonDate(lessonDate);
        assertEquals(1, attendanceTracker.getLessonDates().size());
        assertTrue(attendanceTracker.getLessonDates().contains(lessonDate));

        LocalDate date1 = LocalDate.of(2023, 9, 1);
        LocalDate date2 = LocalDate.of(2023, 10, 2);

        attendanceTracker.addLessonDate(date1);
        attendanceTracker.addLessonDate(date2);

        assertTrue(attendanceTracker.getLessonDates().contains(date1));
        assertTrue(attendanceTracker.getLessonDates().contains(date2));
    }
    @Test
    public void testPrintAllAttendance() {
        AttendanceTracker attendanceTracker = new AttendanceTracker();

        String studentName = "Iron Man";
        LocalDate date = LocalDate.of(2023, 7, 1);

        attendanceTracker.addStudent(studentName);
        attendanceTracker.addLessonDate(date);
        attendanceTracker.markAttendance(studentName, date, true);

        // буфер для перехвата вывода
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        attendanceTracker.printAllAttendance();

        System.setOut(System.out);

        String expectedOutput = "Посещаемость для ученика Iron Man:" + System.lineSeparator() +
                "2023-07-01: посещено" + System.lineSeparator();

        assertEquals(expectedOutput.trim(), outContent.toString().trim());
    }

    @Test
    public void testMarkAttendance() {
        String studentName = "Spider-Man";
        LocalDate date = LocalDate.of(2023, 9, 1);

        attendanceTracker.addStudent(studentName);
        attendanceTracker.addLessonDate(date);
        attendanceTracker.markAttendance(studentName, date, true);

        assertTrue(attendanceTracker.getAttendanceMap().get(studentName).get(date));

    }

    @Test
    public void testPrintStudentAttendance() {
        String studentName = "Iron Man";
        LocalDate date = LocalDate.of(2023, 9, 1);

        attendanceTracker.addStudent(studentName);
        attendanceTracker.addLessonDate(date);
        attendanceTracker.markAttendance(studentName, date, true);

        Map<LocalDate, Boolean> studentAttendance = attendanceTracker.getStudentAttendance(studentName);

        assertTrue(studentAttendance.containsKey(date));
        assertTrue(studentAttendance.get(date));
    }
}
