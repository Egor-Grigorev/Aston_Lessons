package Lesson_2_10;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.time.Duration;

public class TestMTS2 {
    private WebDriver driver;
    private HomePage homePage;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        driver.get("https://www.mts.by/");

        homePage = new HomePage(driver);
        homePage.acceptCookies();
    }

    @Test
    public void testPaymentLogosDisplay() {
        Assert.assertTrue(homePage.areAllLogosDisplayed(), "Не все логотипы платежных систем отображаются");
        System.out.println("Все логотипы платежных систем найдены и отображаются");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
