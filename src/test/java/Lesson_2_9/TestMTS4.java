package Lesson_2_9;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;

public class TestMTS4 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        driver.get("https://www.mts.by/");

        WebElement input = driver.findElement(By.xpath("//button[@id='cookie-agree']"));
        input.click();

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


        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
    }
}
