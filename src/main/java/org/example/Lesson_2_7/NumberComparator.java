package org.example.Lesson_2_7;

public class NumberComparator {
    public static String numberComparator(int a, int b) {

        if (a > b) {
            return a + " больше, чем " + b;
        } else if (a < b) {
            return a + " меньше, чем " + b;
        } else {
            return (a + " равно " + b);
        }
    }
}
