package l25hw2.model;
/*
Имеется список студентов с их фамилиями (задать внутри программы).
Распределить студентов на 2 примерно равных группы (+/- 1 человек) случайным образом.

сначала написать словами алгоритм того, как это будет делаться;
реализовать алгоритм в коде;
при реализации использовать метод(ы);
создать тесты.
 */
import java.util.Random;
public class Students {
    private String surname;

    public Students(String surname) {
        this.surname = surname;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    private static int getRandomStudentIndex(Students[] students, Random random) {
        int index = random.nextInt(students.length);
        while (students[index] == null) {
            index = random.nextInt(students.length);
        }
        return index;
    }

    public static String[] splitStudents(Students[] students) {
        int totalStudents = students.length;
        int groupSize = totalStudents / 2;

        Students[] group1 = new Students[groupSize];
        Random random = new Random();

        for (int i = 0; i < groupSize; i++) {
            int index = getRandomStudentIndex(students, random);

            group1[i] = students[index];
            students[index] = null;
        }

        String[] group1Surnames = new String[groupSize];
        for (int i = 0; i < groupSize; i++) {
            group1Surnames[i] = group1[i].getSurname();
        }

        return group1Surnames;
    }

    public static String[] getOtherStudents(Students[] students, String[] group1) {
        int totalStudents = students.length;
        int remainingSize = totalStudents - group1.length;
        String[] group2 = new String[remainingSize];
        int group2Index = 0;

        for (Students student : students) {
            if (student != null && !isSurnameInGroup(student, group1)) {
                group2[group2Index] = student.getSurname();
                group2Index++;
            }
        }

        return group2;
    }

    private static boolean isSurnameInGroup(Students student, String[] group) {
        for (String member : group) {
            if (student.getSurname().equals(member)) {
                return true;
            }
        }

        return false;
    }

}

