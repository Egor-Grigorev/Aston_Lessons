package Lesson_7_junit_5;

import org.example.Lesson_2_7.TriangleAreaCalculator;
import org.junit.jupiter.api.Test;

import static org.example.Lesson_2_7.TriangleAreaCalculator.calculateTriangleArea;
import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TriangleAreaCalculatorTest {

    @Test
    public void testFormyla() {
        assertEquals(32.0, calculateTriangleArea(8.0, 8.0));
        assertEquals(3.0, calculateTriangleArea(6.0, 1.0));
    }

    @Test
    public void testBase() {
        assertThrows(IllegalArgumentException.class,
                () -> TriangleAreaCalculator.calculateTriangleArea(0, 4));
    }

    @Test
    public void testHeight() {
        assertThrows(IllegalArgumentException.class,
                () -> TriangleAreaCalculator.calculateTriangleArea(8, -6));
    }

    @Test
    public void testHeightBase() {
        assertThrows(Exception.class,
                () -> TriangleAreaCalculator.calculateTriangleArea(0, -6));
    }

}
