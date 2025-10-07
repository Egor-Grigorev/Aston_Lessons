package Lesson_2_2;

public class Array14 {
    public static void main(String[] args) {
        int[] result = initArray(9, 999);
        for (int num : result) {
            System.out.print(num + " ");
        }
    }

    public static int[] initArray(int len, int value) {
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = value;
        }
        return arr;
    }
}
