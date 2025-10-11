package ProbyemAutoTests;

import org.example.ProbyemAutoTests.Calculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;



public class CalculatorTest {

    @Test
    public void testAdd(){

       // private final Calculator calculator = new Calculator();

          //Arrange (подготовка)
        Calculator calculator = new Calculator();
        int a = 2;
        int b = 3;

        // Act (действие)
        int result = calculator.add(a, b);

        // Assert (проверка)
        assertEquals(5, result, "2 + 3 должен быть равен 5");

    }



    @Test
    public void testSubtract(){

        //Arrange (подготовка)
        Calculator calculator = new Calculator();
        int a = 10;
        int b = 3;

        // Act (действие)
        int result = calculator.subtract(a, b);

        // Assert (проверка)
        assertEquals(7, result, "10 - 3 должен быть равен 7");

    }
    @Test
    public void testDivideException() {

        //Arrange (подготовка)
        Calculator calculator = new Calculator();

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            calculator.divide(10,0);
        });
        Assertions.assertEquals("Деление на ноль недопустимо.", exception.getMessage());

        // Act (действие)


        // Assert (проверка)


    }

    @Test
    public void testDivide() {
        //Arrange (подготовка)
        Calculator calculator = new Calculator();
        // Act (действие)
        int result = calculator.divide(10, 4);
        // Assert (проверка)
        Assertions.assertEquals(2, result);
    }

    //--------------------------------------------------------------------------------------



}
