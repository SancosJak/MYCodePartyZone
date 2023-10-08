package attendance.dao;

import attendance.model.Student;

import java.time.LocalDate;
import java.util.*;

public class AttendanceTracker implements Attendance {
    private Map<String, Map<LocalDate, Boolean>> attendanceMap;
    private Map<String, Student> students;
    private List<LocalDate> lessonDates;

    public AttendanceTracker() {
        attendanceMap = new HashMap<>();
        students = new HashMap<>();
        lessonDates = new ArrayList<>();
    }

    @Override
    public void addStudent(String name) {
        if (!students.containsKey(name)) {
            students.put(name, new Student(name));
            attendanceMap.put(name, new HashMap<>());
        } else {
            System.out.println("Ученик с именем " + name + " уже существует.");
        }
    }
    public Student getStudent(String name) {
        return students.get(name);
    }

    @Override
    public void addLessonDate(LocalDate date) {
        for (Map<LocalDate, Boolean> studentAttendance : attendanceMap.values()) {
            studentAttendance.put(date, false);
        }
        lessonDates.add(date);
    }
    public List<LocalDate> getLessonDates() {
        return lessonDates;
    }

    @Override
    public void markAttendance(String name, LocalDate date, boolean attended) {
        if (attendanceMap.containsKey(name)) {
            Map<LocalDate, Boolean> studentAttendance = attendanceMap.get(name);
            if (studentAttendance.containsKey(date)) {
                studentAttendance.put(date, attended);
            } else {
                System.out.println("Урок с датой " + date + " не существует.");
            }
        } else {
            System.out.println("Ученик с именем " + name + " не найден.");
        }
    }

    public Map<String, Map<LocalDate, Boolean>> getAttendanceMap() {
        return attendanceMap;
    }

    @Override
    public void printAllAttendance() {
        if (attendanceMap.isEmpty()) {
            System.out.println("Список посещаемости пуст.");
            return;
        }
        for (Map.Entry<String, Map<LocalDate, Boolean>> entry : attendanceMap.entrySet()) {
            String name = entry.getKey();
            Map<LocalDate, Boolean> studentAttendance = entry.getValue();

            System.out.println("Посещаемость для ученика " + name + ":");
            for (Map.Entry<LocalDate, Boolean> lessonEntry : studentAttendance.entrySet()) {
                LocalDate date = lessonEntry.getKey();
                boolean attended = lessonEntry.getValue();

                System.out.println(date + ": " + (attended ? "посещено" : "пропущено"));
            }
            System.out.println();
        }
    }

    @Override
    public void printStudentAttendance(String name) {
        if (!attendanceMap.containsKey(name)) {
            System.out.println("Ученик с именем " + name + " не найден.");
            return;
        }

        Map<LocalDate, Boolean> studentAttendance = attendanceMap.get(name);

        System.out.println("Посещаемость для ученика " + name + ":");
        for (Map.Entry<LocalDate, Boolean> lessonEntry : studentAttendance.entrySet()) {
            LocalDate date = lessonEntry.getKey();
            boolean attended = lessonEntry.getValue();

            System.out.println(date + ": " + (attended ? "посещено" : "пропущено"));
        }
    }
    public Map<LocalDate, Boolean> getStudentAttendance(String name) {
        if (attendanceMap.containsKey(name)) {
            return attendanceMap.get(name);
        } else {
            return Collections.emptyMap();
        }
    }
}
