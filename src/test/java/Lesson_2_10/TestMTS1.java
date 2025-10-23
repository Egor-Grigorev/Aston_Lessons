package Lesson_2_10;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.time.Duration;

public class TestMTS1 {
    private WebDriver driver;
    private HomePage homePage;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://www.mts.by/");

        homePage = new HomePage(driver);
        homePage.acceptCookies();
    }

    @Test
    public void testPaymentBlockDisplay() {
        homePage.clickPaymentBlock();

        //  Проверяем что блок отображается на странице
        Assert.assertTrue(homePage.isPaymentBlockDisplayed(),
                "Блок 'Онлайн пополнение без комиссии' не отображается на странице");

        //  Проверяем текст заголовка
        String actualTitle = homePage.getPaymentBlockTitle();
        String expectedTitle = "Онлайн пополнение без комиссии";
        Assert.assertEquals(actualTitle, expectedTitle, "Название блока не совпадает с ожидаемым");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
