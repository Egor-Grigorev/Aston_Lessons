package Lesson_7_junit_5;

import org.junit.jupiter.api.Test;

import static org.example.Lesson_2_7.NumberComparator.numberComparator;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class NumberComparatorTest {

    @Test
    public void testNumberAMore() {
        assertEquals(10 + " больше, чем " + 3, numberComparator(10, 3));
    }

    @Test
    public void testNumberBMore() {
        assertEquals(10 + " меньше, чем " + 30, numberComparator(10, 30));
    }

    @Test
    public void testNumberAEquallyB() {
        assertEquals(10 + " равно " + 10, numberComparator(10, 10));
    }
}
