package org.example.Lesson_2_5;

import java.util.Arrays;

public class Array4x4 {

    // Метод для суммирования элементов массива
    public static int sumArrayElements(String[][] array) throws MyArraySizeException, MyArrayDataException {
        // Проверяем размер массива
        if (array.length != 4 || Arrays.stream(array).anyMatch(row -> row.length != 4)) {
            throw new MyArraySizeException("Массив должен быть размером 4×4.");
        }

        int sum = 0;

        // Проходим по всем элементам массива
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                try {
                    // Пытаемся преобразовать строку в число
                    sum += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    // Если преобразование не удалось, бросаем наше исключение
                    throw new MyArrayDataException("Неверные данные в ячейке [" + i + "][" + j + "]: '" + array[i][j] + "'");
                }
            }
        }

        return sum;
    }

    // Метод для демонстрации ArrayIndexOutOfBoundsException
    public static void demonstrateArrayIndexOutOfBounds() {
        System.out.println("\n=== Демонстрация ArrayIndexOutOfBoundsException ===");

        int[] smallArray = {1, 2, 3};

        try {
            // Обращаемся к несуществующему элементу
            System.out.println("Попытка обратиться к элементу с индексом 5...");
            int value = smallArray[5];
            System.out.println("Значение: " + value);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Поймано ArrayIndexOutOfBoundsException!");
            System.out.println("Сообщение: " + e.getMessage());
            System.out.println("Рекомендация: Всегда проверяйте индексы массива перед доступом к элементам.");
        }
    }

    public static void main(String[] args) {
        // Тест 1: Корректный массив
        System.out.println("=== Тест 1: Корректный массив ===");
        String[][] correctArray = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };

        try {
            int result = sumArrayElements(correctArray);
            System.out.println("Сумма элементов: " + result);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        // Тест 2: Массив неправильного размера
        System.out.println("\n=== Тест 2: Массив неправильного размера ===");
        String[][] wrongSizeArray = {
                {"1", "2", "3"},
                {"4", "5", "6"},
                {"7", "8", "9"}
        };

        try {
            int result = sumArrayElements(wrongSizeArray);
            System.out.println("Сумма элементов: " + result);
        } catch (MyArraySizeException e) {
            System.out.println("Ошибка размера: " + e.getMessage());
        } catch (MyArrayDataException e) {
            System.out.println("Ошибка данных: " + e.getMessage());
        }

        // Тест 3: Массив с нечисловыми данными
        System.out.println("\n=== Тест 3: Массив с нечисловыми данными ===");
        String[][] wrongDataArray = {
                {"1", "2", "3", "4"},
                {"5", "шесть", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };

        try {
            int result = sumArrayElements(wrongDataArray);
            System.out.println("Сумма элементов: " + result);
        } catch (MyArraySizeException e) {
            System.out.println("Ошибка размера: " + e.getMessage());
        } catch (MyArrayDataException e) {
            System.out.println("Ошибка данных: " + e.getMessage());
        }

        // Демонстрация ArrayIndexOutOfBoundsException
        demonstrateArrayIndexOutOfBounds();
    }
}

