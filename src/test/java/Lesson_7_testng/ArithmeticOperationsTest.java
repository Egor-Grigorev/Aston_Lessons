package Lesson_7_testng;

import org.example.Lesson_2_7.ArithmeticOperations;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ArithmeticOperationsTest {

    @Test(description = "Проверка операции сложения")
    public void testAadd() {
        Assert.assertEquals(ArithmeticOperations.aadd(10, 3), 13);
    }

    @Test(description = "Проверка операции вычитания")
    public void testSubtract() {

        Assert.assertEquals(ArithmeticOperations.subtract(1000, 900), 100);
    }

    @Test(description = "Проверка операции умножения")
    public void testMultiply() {

        Assert.assertEquals(ArithmeticOperations.multiply(10, 900), 9000);
    }

    @Test(description = "Проверка операции деления")
    public void testDivide() {

        Assert.assertEquals(ArithmeticOperations.divide(10, 5), 2);
    }

    @Test(expectedExceptions = ArithmeticException.class,
            description = "Тестирование деления на ноль")
    public void testDivideByZero() {
        // Деление на ноль должно вызвать исключение
        ArithmeticOperations.divide(5, 0);
    }
}
