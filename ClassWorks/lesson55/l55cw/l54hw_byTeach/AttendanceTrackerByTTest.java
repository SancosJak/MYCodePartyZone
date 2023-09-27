package l54hw_byTeach;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class AttendanceTrackerByTTest {
    private AttendanceTrackerByT attendanceTracker;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    void setUp() {
        attendanceTracker = new AttendanceTrackerByT();
        System.setOut(new PrintStream(outContent));  // Перенаправляем стандартный вывод в ByteArrayOutputStream для проверки
    }

    @Test
    void addStudent() {
        attendanceTracker.addStudent("Alice");
        attendanceTracker.printStudentAttendance("Alice");
        String expectedOutput = "Student: Alice\n";
        assertEquals(expectedOutput.trim(), outContent.toString().trim());
    }

    @Test
    void addLessonDate() {
        attendanceTracker.addStudent("Alice");
        attendanceTracker.addLessonDate(LocalDate.of(2023, 10, 10));
        attendanceTracker.printStudentAttendance("Alice");
        String expectedOutput = "Student: Alice" + System.lineSeparator() + "2023-10-10: Missed" + System.lineSeparator();
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    void markAttendance() {
        attendanceTracker.addStudent("Alice");
        attendanceTracker.addLessonDate(LocalDate.of(2023, 10, 10));
        attendanceTracker.markAttendance("Alice", LocalDate.of(2023, 10, 10), true);
        attendanceTracker.printStudentAttendance("Alice");
        String expectedOutput = "Student: Alice" + System.lineSeparator() + "2023-10-10: Attended" + System.lineSeparator();
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    void printAllAttendance() {
        attendanceTracker.addStudent("Alice");
        attendanceTracker.addLessonDate(LocalDate.of(2023, 10, 10));
        attendanceTracker.markAttendance("Alice", LocalDate.of(2023, 10, 10), true);
        attendanceTracker.printAllAttendance();
        String expectedOutput = "Student: Alice" + System.lineSeparator() + "2023-10-10: Attended" + System.lineSeparator();
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    void printStudentAttendance_noData() {
        attendanceTracker.printStudentAttendance("Bob");
        String expectedOutput = "No data found for student: Bob" + System.lineSeparator();
        assertEquals(expectedOutput, outContent.toString());
    }
}
