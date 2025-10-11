package Lesson_7_junit_5;

import org.example.Lesson_2_7.NumberComparator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class NumberComparatorTest {

    @Test
    public void testNumberAMore(){

        //Arrange (подготовка)

        //NumberComparator numberComparator = new NumberComparator();
        int a = 10;
        int b = 3;

        // Act (действие)

        String result = NumberComparator.numberComparator(a, b);

        // Assert (проверка)

        assertEquals(a + " больше, чем " + b, result);

    }
//---------------------------------------------------------------------------------------

    @Test
    public void testNumberBMore(){
        //NumberComparator numberComparator = new NumberComparator();
        int a = 10;
        int b = 30;
        String result = NumberComparator.numberComparator(a, b);
        assertEquals(a + " меньше, чем " + b, result, "----");

    }

    @Test
    public void testNumberAEquallyB(){
        //NumberComparator numberComparator = new NumberComparator();
        int a = 10;
        int b = 10;
        String result = NumberComparator.numberComparator(a, b);
        assertEquals(a + " равно " + b, result, "=======");

    }

}
