package Lesson_2_2;

public class Array12 {
    public static void main(String[] args) {
        int[] array = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        doubleSmallNumbers(array);
        for (int num : array) {
            System.out.print(num + " ");
        }
    }

    public static void doubleSmallNumbers(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 6) {
                arr[i] *= 2;
            }
        }
    }
}

