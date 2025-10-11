package Lesson_7_testng;

import org.example.Lesson_2_7.TriangleAreaCalculator;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TriangleAreaCalculatorTest {

    //----------------------------------------------------------
    @Test(description = "Проверка вычисления площади треугольника")
    public void testСalculateTriangleArea() {

        Assert.assertEquals(TriangleAreaCalculator.calculateTriangleArea(10, 4), 20);
    }

}
