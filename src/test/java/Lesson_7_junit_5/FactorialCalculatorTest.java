package Lesson_7_junit_5;

import org.example.Lesson_2_7.ArithmeticOperations;
import org.example.Lesson_2_7.FactorialCalculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FactorialCalculatorTest {
//------------------------------------------------------------------------------------------
    @Test
    public void testFactorial(){

        //FactorialCalculator factorialCalculator = new FactorialCalculator();

        int resultForFive = FactorialCalculator.factorial(5);

        assertEquals(120, resultForFive);
    }

    @Test
    public void testFactorialOfNegativeNumber() {
        //FactorialCalculator factorialCalculator = new FactorialCalculator();
        /*Exception exception = */assertThrows(IllegalArgumentException.class, () -> {
            FactorialCalculator.factorial(-100);
        });
       // Assertions.assertEquals("Факториал отрицательного числа невозможен", exception.getMessage());
    }

}
