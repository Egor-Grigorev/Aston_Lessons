package org.example.Lesson_2_7;

import java.util.Scanner;

public class NumberComparator {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);


        System.out.print("Введите первое число: ");
        int num1 = input.nextInt();


        System.out.print("Введите второе число: ");
        int num2 = input.nextInt();


        if (num1 > num2) {
            System.out.println(num1 + " больше, чем " + num2);
        } else if (num1 < num2) {
            System.out.println(num1 + " меньше, чем " + num2);
        } else {
            System.out.println(num1 + " равно " + num2);
        }


        input.close();
    }
}


 /*
public class NumberComparator {
    public static boolean isGreaterThan(int firstNumber, int secondNumber) {
        return firstNumber > secondNumber;
    }

    public static boolean areEqual(int firstNumber, int secondNumber) {
        return firstNumber == secondNumber;
    }
}

 */