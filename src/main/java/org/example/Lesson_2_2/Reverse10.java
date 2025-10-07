package Lesson_2_2;

public class Reverse10 {
    public static void main(String[] args) {
        int[] array = {1, 1, 0, 1, 1, 0, 0, 1, 1, 0};
        reverse(array);
        for (int num : array) {
            System.out.print(num + " ");
        }
    }

    public static void reverse(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i] == 0 ? 1 : 0;
        }
    }
}
