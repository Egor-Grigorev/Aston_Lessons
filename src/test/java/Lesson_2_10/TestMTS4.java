package Lesson_2_10;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.time.Duration;


@Epic("4")
@Feature("4")
@Story("4")
@Owner("qa")
@Severity(SeverityLevel.NORMAL)
public class TestMTS4 {
    private WebDriver driver;
    private HomePage homePage;
    private PaymentPage paymentPage;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        driver.get("https://www.mts.by/");

        homePage = new HomePage(driver);
        paymentPage = new PaymentPage(driver);
        homePage.acceptCookies();
    }

    @Test
    public void testPaymentFormSubmission() {
        // Переходим к блоку оплаты
        homePage.clickPaymentBlock();

        // Заполняем форму
        paymentPage.fillConnectionForm("297777777", "499");

        // Нажимаем продолжить
        paymentPage.clickContinue();

        // Проверяем что кнопка отображается (платежное окно открылось)
        Assert.assertTrue(paymentPage.isContinueButtonDisplayed());
        System.out.println("Кнопка работает! Платежное окно открылось");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
