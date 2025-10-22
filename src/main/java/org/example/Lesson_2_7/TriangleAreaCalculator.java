package org.example.Lesson_2_7;

public class TriangleAreaCalculator {
    public static double calculateTriangleArea(double base, double height) {
        if (base <= 0) {
            throw new IllegalArgumentException("Основание треугольника не может быть меньше или равно 0");
        }
        if (height <= 0) {
            throw new IllegalArgumentException("Высота треугольника не может быть меньше или равна 0");
        }
        return 0.5 * base * height;
    }
}
// Площадь треугольника = a*h/2;
