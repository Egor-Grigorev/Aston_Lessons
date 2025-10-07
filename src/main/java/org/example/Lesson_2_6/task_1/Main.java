package Lesson_2_6.task_1;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        // Создание коллекции студентов
        Set<Student> students = new HashSet<>();

        // Добавление объектов класса Student в коллекцию
        students.add(new Student("Иван Иванов", "ИСП-18", 1, Arrays.asList(4, 5)));
        students.add(new Student("Сергей Петров", "ИСП-18", 1, Arrays.asList(3, 4)));
        students.add(new Student("Анна Смирнова", "ИСП-18", 1, Arrays.asList(2, 3))); // Средний балл ниже 3
        students.add(new Student("Елена Кузнецова", "ИСП-18", 2, Arrays.asList(4, 4)));

        System.out.println("Студенты перед обработкой:");
        for (var student : students) {
            System.out.println(student);
        }

        // Удаление студентов со средним баллом менее 3
        removeBadStudents(students);

        // Перевод студентов на следующий курс
        promoteGoodStudents(students);

        System.out.println("\nСтуденты после обработки:");
        for (var student : students) {
            System.out.println(student);
        }

        // Печать списка студентов определенного курса
        printStudents(students, 2); // выводим всех студентов второго курса
    }

    /**
     * Убирает студентов со средним баллом меньше трех.
     */
    private static void removeBadStudents(Collection<Student> students) {
        students.removeIf(s -> s.getAverageScore() < 3);
    }

    /**
     * Переводит на следующий курс студентов со средним баллом больше или равным трем.
     */
    private static void promoteGoodStudents(Collection<Student> students) {
        students.forEach(s -> {
            if (s.getAverageScore() >= 3 && s.getCourse() != 5) { // Проверяем, что студент не последний курс
                s.setCourse(s.getCourse() + 1);
            }
        });
    }

    /**
     * Выводит на экран имена студентов заданного курса.
     */
    public static void printStudents(Set<Student> students, int course) {
        List<String> namesOnCourse = new ArrayList<>();
        for (var student : students) {
            if (student.getCourse() == course) {
                namesOnCourse.add(student.getName());
            }
        }
        System.out.println("Студенты на курсе №" + course + ":");
        namesOnCourse.forEach(System.out::println);
    }
}
