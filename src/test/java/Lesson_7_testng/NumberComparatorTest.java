package Lesson_7_testng;

import org.example.Lesson_2_7.ArithmeticOperations;
import org.example.Lesson_2_7.NumberComparator;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NumberComparatorTest {

    //----------------------------------------------------------1
    @Test(description = "А больше")
    public void testNumberAMore() {
        //Arrange (подготовка)
        int a, b;
        a = 1000;
        b = 500;
        // Act (действие)
        String result = NumberComparator.numberComparator(a, b);
        // Assert (проверка)
        assertEquals(a + " больше, чем " + b, result);
    }


    //----------------------------------------------------------2
    @Test(description = "А меньше")
    public void testNumberBMore() {
        //Arrange (подготовка)
        int a, b;
        a = 1;
        b = 500;
        // Act (действие)
        String result = NumberComparator.numberComparator(a, b);
        // Assert (проверка)
        assertEquals(a + " меньше, чем " + b, result);
    }


    //----------------------------------------------------------3
    @Test(description = "А =")
    public void testNumberAEquallyB() {
        //Arrange (подготовка)
        int a, b;
        a = 1000;
        b = 1000;
        // Act (действие)
        String result = NumberComparator.numberComparator(a, b);
        // Assert (проверка)
        assertEquals(a + " равно " + b, result);
    }

}
