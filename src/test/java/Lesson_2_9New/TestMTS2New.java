package Lesson_2_9New;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;


public class TestMTS2New extends Base {
    @Test
    public void test2() {

        WebElement visaLogo = driver.findElement(By.xpath("//img[@alt='Visa']"));
        Assert.assertTrue(visaLogo.isDisplayed(), "Логотип Visa не отображается");
        System.out.println("Логотип Visa найден и отображается!");

        WebElement visaVerifiedByLogo = driver.findElement(By.xpath("//img[@alt='Verified By Visa']"));
        Assert.assertTrue(visaVerifiedByLogo.isDisplayed(), "Логотип 'Verified By Visa' не отображается");
        System.out.println("Логотип 'Verified By Visa' найден и отображается!");

        WebElement MasterCard = driver.findElement(By.xpath("//div[@class='pay__partners']//img[@alt='MasterCard']"));
        Assert.assertTrue(MasterCard.isDisplayed(), "Логотип MasterCard не отображается");
        System.out.println("Логотип MasterCard найден и отображается!");

        WebElement MasterCardSecureCode = driver.findElement(By.xpath("//img[@alt='MasterCard Secure Code']"));
        Assert.assertTrue(MasterCardSecureCode.isDisplayed(), "Логотип MasterCard Secure Code не отображается");
        System.out.println("Логотип MasterCard Secure Code найден и отображается!");

        WebElement belcard = driver.findElement(By.xpath("//div[@class='homepage']//img[@alt='Белкарт']"));
        Assert.assertTrue(belcard.isDisplayed(), "Логотип Белкартне отображается");
        System.out.println("Логотип Белкарт найден и отображается!");

    }
}




