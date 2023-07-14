package l25hw2.model;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Students {
    public static void main(String[] args) {
        List<String> studentList = new ArrayList<>();
        studentList.add("Иванов");
        studentList.add("Петров");
        studentList.add("Сидоров");
        studentList.add("Козлов");
        studentList.add("Смирнов");
        studentList.add("Васильев");
        studentList.add("Морозов");
        studentList.add("Николаев");

        // Перемешиваем список студентов
        Collections.shuffle(studentList);

        int totalStudents = studentList.size();
        int groupSize = totalStudents / 2; // Размер каждой группы
        int remainingStudents = totalStudents % 2; // Оставшиеся студенты, если число студентов нечетное

        List<String> group1 = new ArrayList<>(studentList.subList(0, groupSize));
        List<String> group2 = new ArrayList<>(studentList.subList(groupSize, groupSize + groupSize + remainingStudents));

        // Выводим результаты
        System.out.println("Группа 1:");
        for (String student : group1) {
            System.out.println(student);
        }

        System.out.println("\nГруппа 2:");
        for (String student : group2) {
            System.out.println(student);
        }
    }
}
