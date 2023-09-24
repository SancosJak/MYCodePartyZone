package attendance.dao;

import java.time.LocalDate;

public interface Attendance {
    void addStudent(String name);

    void addLessonDate(LocalDate date);

    void markAttendance(String name, LocalDate date, boolean attended);

    void printAllAttendance();

    void printStudentAttendance(String name);
}
