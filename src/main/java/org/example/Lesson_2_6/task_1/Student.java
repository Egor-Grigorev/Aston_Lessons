package Lesson_2_6.task_1;

import java.util.*;

class Student {
    private String name;
    private String group;
    private int course;
    private List<Integer> grades;

    public Student(String name, String group, int course, List<Integer> grades) {
        this.name = name;
        this.group = group;
        this.course = course;
        this.grades = grades;
    }

    public double getAverageScore() {
        return grades.stream().mapToInt(Integer::intValue).average().orElse(0);
    }

    public String getName() {
        return name;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student student = (Student) o;
        return Objects.equals(name, student.name)
                && Objects.equals(group, student.group)
                && Objects.equals(course, student.course)
                && Objects.equals(grades, student.grades);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, group, course, grades);
    }

    @Override
    public String toString() {
        return "Имя: " + name +
                ", Группа: " + group +
                ", Курс: " + course +
                ", Оценки: " + grades +
                ", Средн. балл: " + getAverageScore();
    }
}

