package Lesson_2_2;

public class IsNegative7 {
    public static boolean isNegative(int value) {
        return value < 0;
    }
    public static void main(String[] args) {
        boolean result = isNegative(-1); // сохраняем результат вызова метода
        System.out.println(result);
    }
}
