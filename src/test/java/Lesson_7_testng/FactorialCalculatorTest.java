package Lesson_7_testng;

import org.example.Lesson_2_7.FactorialCalculator;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FactorialCalculatorTest {

    @Test(description = "Факториал")
    public void testFactorial() {
        Assert.assertEquals(FactorialCalculator.factorial(0), 1);
        Assert.assertEquals(FactorialCalculator.factorial(1), 1);
        Assert.assertEquals(FactorialCalculator.factorial(2), 2);
        Assert.assertEquals(FactorialCalculator.factorial(3), 6);
        Assert.assertEquals(FactorialCalculator.factorial(4), 24);
    }

    @Test(expectedExceptions = IllegalArgumentException.class,
            description = "Исключение")
    public void testFactorialException() {
        FactorialCalculator.factorial(-4);
    }

}
