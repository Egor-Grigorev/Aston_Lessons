package Lesson_7_junit_5;

import org.example.Lesson_2_7.ArithmeticOperations;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.example.Lesson_2_7.ArithmeticOperations.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ArithmeticOperationsTest {

    @Test
    public void testAadd() { //Сложение:
        assertEquals(5, aadd(2, 3), "2 + 3 должен быть равен 5");
    }

    @Test
    public void testSubtract() { // Вычитание:
        assertEquals(1, subtract(8, 7));
    }

    @Test
    public void testMultiply() {//Умножение:
        assertEquals(64, multiply(8, 8));
    }

    @Test
    public void testDivideException() { // Деление на 0:
        assertThrows(ArithmeticException.class, () -> new ArithmeticOperations().divide(10, 0));
    }

    @Test
    public void testDivide() { // Деление:
        Assertions.assertEquals(2, divide(10, 4));
    }
}
