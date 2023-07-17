package l25hw2.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentsTest {

    private Students[] students;

    @BeforeEach
    public void setUp() {
        students = new Students[]{
                new Students("Ronaldo"),
                new Students("Messi"),
                new Students("Neymar"),
                new Students("Mbappe"),
                new Students("Benzema"),
                new Students("Muller")
        };
    }

    @Test
    public void splitStudentsTest() {
        String[] group1 = Students.splitStudents(students);

        // Check if group1 contains exactly half of the students
        assertEquals(students.length / 2, group1.length);

        // Check if all surnames in group1 are unique
        for (int i = 0; i < group1.length; i++) {
            for (int j = i + 1; j < group1.length; j++) {
                assertNotEquals(group1[i], group1[j]);
            }
        }

        // Check if all students in group1 have been removed from the original students array
        for (Students student : students) {
            if (student != null) {
                boolean found = false;
                for (String surname : group1) {
                    if (student.getSurname().equals(surname)) {
                        found = true;
                        break;
                    }
                }
                assertFalse(found);
            }
        }
    }

    @Test
    public void getOtherStudentsTest() {
        String[] group1 = new String[]{"Ronaldo", "Messi", "Neymar"};

        String[] group2 = Students.getOtherStudents(students, group1);

        // Check if group2 contains the remaining students
        assertEquals(students.length - group1.length, group2.length);

        // Check if all surnames in group2 are unique
        for (int i = 0; i < group2.length; i++) {
            for (int j = i + 1; j < group2.length; j++) {
                assertNotEquals(group2[i], group2[j]);
            }
        }

        // Check if all students in group2 are not present in group1
        for (String surname : group2) {
            for (String surnameInGroup1 : group1) {
                assertNotEquals(surname, surnameInGroup1);
            }
        }
    }
}