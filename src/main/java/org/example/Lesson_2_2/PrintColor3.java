package Lesson_2_2;

public class PrintColor3 {
    public static void printColor () {
        int value = 100000;
        if (value <= 0) {
            System.out.println("Красный");
        } else if (value >= 1 && value <= 100) {
                System.out.println("Желтый");
        } else {
            System.out.println("Зеленый");
        }
    }

    public static void main(String[] args) {
        printColor ();
    }
}
