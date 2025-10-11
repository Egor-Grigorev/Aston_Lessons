package Lesson_7_junit_5;

import org.example.Lesson_2_7.ArithmeticOperations;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ArithmeticOperationsTest {
//----------------------------------Сложение:
    @Test
    public void testAadd(){

        //Arrange (подготовка)

        ArithmeticOperations arithmeticOperations = new ArithmeticOperations();
        int x = 2;
        int y = 3;

        // Act (действие)

        int result = arithmeticOperations.aadd(x, y);

        // Assert (проверка)

        assertEquals(5, result, "2 + 3 должен быть равен 5");

    }
//--------------------------Вычитание:
    @Test
    public void testSubtract(){
        ArithmeticOperations arithmeticOperations = new ArithmeticOperations();
        int x = 8;
        int y = 7;
        int result = arithmeticOperations.subtract(x, y);
        assertEquals(1, result);

    }
//------------------------------Умножение:
    @Test
    public void testMultiply() {
        ArithmeticOperations arithmeticOperations = new ArithmeticOperations();
        int x = 8;
        int y = 8;
        int result = arithmeticOperations.multiply(x, y);
        assertEquals(64, result);
    }
    //-------------------------------------Деление:

    @Test
    public void testDivideException() {
        ArithmeticOperations arithmeticOperations = new ArithmeticOperations();
        Exception exception = assertThrows(ArithmeticException.class, () -> {
            arithmeticOperations.divide(10,0);
        });
        Assertions.assertEquals("Деление на ноль недопустимо.", exception.getMessage());



    }

    @Test
    public void testDivide() {
        ArithmeticOperations arithmeticOperations = new ArithmeticOperations();
        int result = arithmeticOperations.divide(10, 4);
        Assertions.assertEquals(2, result);
    }
}
