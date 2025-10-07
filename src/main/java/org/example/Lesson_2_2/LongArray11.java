package Lesson_2_2;

public class LongArray11 {
    public static void main(String[] args) {
        int[] array = new int[100];
        fillArray(array);
        for (int num : array) {
            System.out.print(num + " ");
        }
    }

    public static void fillArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }
    }
}