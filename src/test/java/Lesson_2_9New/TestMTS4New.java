package Lesson_2_9New;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;


public class TestMTS4New extends Base {


    @Test
    public void test4() {
        WebElement phoneNumber = driver.findElement(By.xpath("//input [@placeholder='Номер телефона']"));
        phoneNumber.click();
        phoneNumber.sendKeys("297777777");

        WebElement sum = driver.findElement(By.xpath("//*[@id=\"connection-sum\"]"));
        sum.click();
        sum.sendKeys("499");

        WebElement resume = driver.findElement(By.xpath("//*[@id=\"pay-connection\"]/button"));
        resume.click();

        Assert.assertTrue(resume.isDisplayed());
        System.out.println("Кнопка работает! Платежное окно открылось");

    }
}

