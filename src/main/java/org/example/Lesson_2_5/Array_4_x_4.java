package Lesson_2_5;



class MyArraySizeException extends Exception {
    public MyArraySizeException(String message) {
        super(message);
    }
}

class MyArrayDataException extends Exception {
    public MyArrayDataException(String message) {
        super(message);
    }
}

public class Array_4_x_4 {

    // Метод для суммирования элементов массива
    public static int sumArrayElements(String[][] array) throws MyArraySizeException, MyArrayDataException {
        // Проверяем размер массива
        if (array.length != 4) {
            throw new MyArraySizeException("Массив должен быть размером 4х4. Получено строк: " + array.length);
        }

        for (int i = 0; i < array.length; i++) {
            if (array[i].length != 4) {
                throw new MyArraySizeException("Каждая строка должна содержать 4 элемента. Строка " + i + " содержит: " + array[i].length);
            }
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

        int[] smallArray = {1, 2, 3}; // Массив всего из 3 элементов

        try {
            // Пытаемся обратиться к несуществующему элементу
            System.out.println("Попытка обратиться к элементу с индексом 5...");
            int value = smallArray[5]; // Здесь произойдет исключение!
            System.out.println("Значение: " + value); // Эта строка не выполнится
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Поймано ArrayIndexOutOfBoundsException!");
            System.out.println("Сообщение: " + e.getMessage());
            System.out.println("Рекомендация: всегда проверяйте границы массива перед обращением к элементам");
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