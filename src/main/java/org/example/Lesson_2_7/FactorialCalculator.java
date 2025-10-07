package org.example.Lesson_2_7;

public class FactorialCalculator {
    public static long factorial(int n) {
        if (n < 0)
            throw new IllegalArgumentException("Факториал отрицательного числа невозможен");

        return (n <= 1) ? 1 : n * factorial(n - 1); //  расчет факториала
    }
}
