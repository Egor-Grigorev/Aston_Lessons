package Lesson_2_9;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;


public class TestMTS2 {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        driver.get("https://www.mts.by/");

        WebElement input = driver.findElement(By.xpath("//button[@id='cookie-agree']"));
        input.click();

        WebElement visaLogo = driver.findElement(By.xpath("//img[@alt='Visa']"));
        visaLogo.click();
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

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
    }
}



