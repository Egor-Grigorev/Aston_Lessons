package Lesson_2_2;

public class LeapYearChecker9 {
    public static void main(String[] args) {
        int year = 2027;
        System.out.println(isLeapYear(year));
    }


    public static boolean isLeapYear(int year) {
        if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
            return true;
        } else {
            return false;
        }
    }
}