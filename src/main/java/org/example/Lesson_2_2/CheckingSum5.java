package Lesson_2_2;

public class CheckingSum5 {
    public static boolean checkingSum(int a, int b) {
        return ((a + b) >= 10 && (a + b) <= 20);
    }

    public static void main(String[] args) {
        int a = 1;
        int b = 10;

        boolean result = checkingSum(a, b);
        System.out.println(result);
    }
}