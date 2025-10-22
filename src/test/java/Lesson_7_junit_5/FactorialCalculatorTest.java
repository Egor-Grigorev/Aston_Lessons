package Lesson_7_junit_5;

import org.junit.jupiter.api.Test;

import static org.example.Lesson_2_7.FactorialCalculator.factorial;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FactorialCalculatorTest {

    @Test
    public void testFactorial() {
        assertEquals(120, factorial(5));
        assertEquals(1, factorial(0));
    }

    @Test
    public void testFactorialOfNegativeNumber() {
        assertThrows(IllegalArgumentException.class, () -> {
            factorial(-3);
        });
    }
}
