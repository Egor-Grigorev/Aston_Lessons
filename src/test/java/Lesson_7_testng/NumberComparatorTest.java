package Lesson_7_testng;

import org.testng.annotations.Test;

import static org.example.Lesson_2_7.NumberComparator.numberComparator;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class NumberComparatorTest {

    @Test(description = "А больше")
    public void testNumberAMore() {
        assertEquals(1000 + " больше, чем " + 500, numberComparator(1000, 500));
    }

    @Test(description = "А меньше")
    public void testNumberBMore() {
        assertEquals(1 + " меньше, чем " + 500, numberComparator(1, 500));
    }

    @Test(description = "А =")
    public void testNumberAEquallyB() {
        assertEquals(1000 + " равно " + 1000, numberComparator(1000, 1000));
    }
}
