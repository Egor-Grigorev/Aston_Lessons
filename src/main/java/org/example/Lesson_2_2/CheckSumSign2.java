package Lesson_2_2;


public class CheckSumSign2 {
    public static void checkSumSign() {
        int a = 11;
        int b = 89;

        if ((a + b) >= 0)
            System.out.println("Сумма положительная");
        else
            System.out.println("Сумма отрицательная");
    }


    public static void main(String[] args) {

        checkSumSign();
    }
}