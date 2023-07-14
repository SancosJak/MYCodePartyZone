package l25hw2.model;

import java.util.Arrays;
import java.util.Random;

public class Students{
    public static void main(String[] args) {
        String[] studentList = createStudentList();

        String[] group1 = distributeStudents(studentList);

        // Формируем group2 из оставшихся студентов
        String[] group2 = getRemainingStudents(studentList, group1);

        // Выводим результаты
        System.out.println("Группа 1:");
        printArray(group1);

        System.out.println("\nГруппа 2:");
        printArray(group2);
    }

    public static String[] createStudentList() {
        return new String[]{"Иванов", "Петров", "Сидоров", "Козлов", "Смирнов", "Васильев", "Морозов", "Николаев"};
    }

    public static String[] distributeStudents(String[] studentList) {
        // Перемешиваем список студентов
        shuffleArray(studentList);

        int totalStudents = studentList.length;
        int groupSize = totalStudents / 2; // Размер каждой группы
        int remainingStudents = totalStudents % 2; // Оставшиеся студенты, если число студентов нечетное

        return Arrays.copyOf(studentList, groupSize + remainingStudents);
    }

    public static String[] getRemainingStudents(String[] studentList, String[] group1) {
        String[] remainingStudents = new String[studentList.length - group1.length];
        int index = 0;
        for (String student : studentList) {
            if (!Arrays.asList(group1).contains(student)) {
                remainingStudents[index] = student;
                index++;
            }
        }
        return remainingStudents;
    }

    public static void shuffleArray(String[] array) {
        Random random = new Random();
        for (int i = array.length - 1; i > 0; i--) {
            int index = random.nextInt(i + 1);
            String temp = array[index];
            array[index] = array[i];
            array[i] = temp;
        }
    }

    public static void printArray(String[] array) {
        for (String item : array) {
            System.out.println(item);
        }
    }
}
