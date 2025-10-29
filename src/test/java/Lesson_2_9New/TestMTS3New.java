package Lesson_2_9New;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;


public class TestMTS3New extends Base {

    @Test
    public void test3() {

        WebElement detailsLink = driver.findElement(By.xpath("//a[text()='Подробнее о сервисе']"));
        Assert.assertTrue(detailsLink.isDisplayed());
        detailsLink.click();
        Assert.assertNotEquals(driver.getCurrentUrl(), "https://www.mts.by/");
        System.out.println("Ссылка работает!");


    }
}
