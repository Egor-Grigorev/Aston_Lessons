package Lesson_2_6.task_2;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

// Класс PhoneBook реализует простейший телефонный справочник
public class PhoneBook {

    // Внутренняя структура хранения записей
    private final HashMap<String, List<String>> phoneBook;

    // Конструктор создает пустой телефонный справочник
    public PhoneBook() {
        phoneBook = new HashMap<>();
    }

    // Метод добавляет запись в справочник
    public void add(String surname, String number) {
        // Получаем существующий список номеров по фамилии,
        // если его нет, создаем новый
        List<String> numbers = phoneBook.computeIfAbsent(surname, k -> new ArrayList<>());
        // Добавляем номер в список
        numbers.add(number);
    }

    // Метод ищет номера телефонов по фамилии
    public List<String> get(String surname) {
        // Возвращаем список номеров, соответствующий указанной фамилии
        return phoneBook.getOrDefault(surname, new ArrayList<>());
    }

    //  тестирование  справочника
    public static void main(String[] args) {
        PhoneBook book = new PhoneBook(); // создаём экземпляр справочника

        // добавляем некоторые записи
        book.add("Иванов", "+79211234567");
        book.add("Петров", "+79217654321");
        book.add("Иванов", "+79219876543"); // второй номер Иванова

        // выводим найденные номера
        System.out.println("Номера Петрова: " + book.get("Петров"));
        System.out.println("Номера Иванова: " + book.get("Иванов")); // оба номера Иванова
    }
}