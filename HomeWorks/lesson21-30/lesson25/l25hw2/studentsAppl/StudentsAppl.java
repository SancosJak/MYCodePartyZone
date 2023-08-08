package l25hw2.studentsAppl;
// Алгоритм того, как это будет делаться
/*
1. Создать класс Students для представления модели студента с фамилией.
- В классе Students определить конструктор, геттер и сеттер для фамилии студента.

2. Реализовать  метод, который принимает массив объектов Students и выполняет распределение студентов на группы.
Внутри метода:
- Определить общее количество студентов в массиве.
- Вычислить размер группы (половину от общего количества студентов) и создать массив для первой группы.
- Создать объект Random для генерации случайных чисел.
- Сгенерировать случайный индекс от 0 до totalStudents - 1.
- Если студент с выбранным индексом не равен null, добавить его фамилию в group1,
а затем установить значение null для этого студента в исходном массиве.
- Создать новый массив group1Surnames и заполнить его фамилиями из group1.
- Вернуть group1Surnames.


3. Реализовать метод, который принимает массив объектов Students и массив фамилий из первой группы (group1),
и возвращает фамилии студентов для второй группы.
Внутри метода:
- Определить общее количество студентов в массиве.
- Вычислить размер второй группы (разница между общим количеством студентов и размером первой группы)
и создать массив group2.
- Если студент не равен null и его фамилия отсутствует в group1, добавить его фамилию в group2.
- Вернуть group2.

4. Создать класс StudentsAppl и импортировать в него Students.model

5. Создать массив объектов Students с фамилиями студентов.
- Вызвать метод splitStudents для распределения студентов на первую группу.
- Вызвать метод getOtherStudents для получения студентов второй группы.
- Вывести на экран фамилии студентов из обеих групп.

6. Создать тесты для методов
- В методе setUp создается массив объектов Students с шестью экземплярами, каждый из которых
инициализирован с разными фамилиями.
6.1 Затем вызывается метод splitStudents для разделения массива на две группы.
- Длина group1 должна быть равной половине длины массива студентов.
- Фамилии в group1 должны быть уникальными.
- Все студенты из group1 должны быть удалены из исходного массива студентов.
Если студент из group1 найден в исходном массиве, тест не пройден.

6.2 getOtherStudentsTest:
Этот метод принимает два массива строк: один представляет первую группу студентов,
а другой - исходный массив всех студентов. Метод getOtherStudents возвращает массив с оставшимисся
студентами, которые не входят в первую группу.
- Тест создает массив group1, содержащий первые три фамилии из исходного массива студентов.
- Затем вызывается метод getOtherStudents для получения массива group2 с остальными студентами из исходного массива.
- Длина group2 должна быть равной разнице между длиной исходного массива и длиной group1.
- Фамилии в group2 должны быть уникальными.
- Все студенты из group2 не должны присутствовать в group1. Если фамилия из group2 найдена в group1, тест не пройден.

 */
import l25hw2.model.Students;
import java.util.Arrays;


public class StudentsAppl {
    public static String[] getAllStudents(Students[] students) {
        String[] allStudents = new String[students.length];
        for (int i = 0; i < students.length; i++) {
            allStudents[i] = students[i].getSurname();
        }
        return allStudents;
    }

    public static void main(String[] args) {
        Students[] students = {
                new Students("Skywalker"),
                new Students("Potter"),
                new Students("Stark"),
                new Students("Wayne"),
                new Students("Romanoff"),
                new Students("Parker"),
                new Students("Banner")
        };
        System.out.println("All Students: " + Arrays.toString(getAllStudents(students)));

        String[] group1 = Students.splitStudents(students);
        String[] group2 = Students.getOtherStudents(students, group1);
        System.out.println("Group 1: " + Arrays.toString(group1));
        System.out.println("Group 2: " + Arrays.toString(group2));
    }
}
