package org.example.Lesson_2_7;

public class ArithmeticOperations {

    public static int aadd(int x, int y) {
        return x + y;
    }

    public static int subtract(int x, int y) {
        return x - y;
    }

    public static int multiply(int x, int y) {
        return x * y;
    }

    public static int divide(int x, int y) throws ArithmeticException {
        if (y == 0) {
            throw new ArithmeticException("Деление на ноль невозможно!");
        }
        return x / y;
    }
}
