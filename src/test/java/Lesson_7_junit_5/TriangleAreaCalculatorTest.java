package Lesson_7_junit_5;

import org.example.Lesson_2_7.TriangleAreaCalculator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TriangleAreaCalculatorTest {

    @Test
    public void testFormyla() {
        TriangleAreaCalculator triangleAreaCalculator = new TriangleAreaCalculator();
        double base = 8.0;
        double height = 8.0;
        double result = triangleAreaCalculator.calculateTriangleArea(base, height);
        assertEquals(32.0, result);
    }
}
