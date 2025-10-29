package Lesson_2_10;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.time.Duration;

@Epic("MTS")
@Feature("Главная страница")
@Owner("qa")
@Severity(SeverityLevel.NORMAL)

public class TestMTS1 {

    private WebDriver driver;
    private HomePage homePage;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        Allure.step("Открыть https://www.mts.by/");
        driver.get("https://www.mts.by/");

        homePage = new HomePage(driver);

        Allure.step("Принять cookies");
        homePage.acceptCookies();
    }

    @Test(description = "Онлайн пополнение — блок отображается и заголовок корректен")
    @Story("Отображение блока оплаты")
    public void testPaymentBlockDisplay() {
        Allure.step("Кликнуть по блоку оплаты");
        homePage.clickPaymentBlock();

        Allure.step("Проверить, что блок отображается");
        Assert.assertTrue(
                homePage.isPaymentBlockDisplayed(),
                "Блок 'Онлайн пополнение без комиссии' не отображается на странице"
        );

        Allure.step("Проверить текст заголовка блока");
        String actualTitle = homePage.getPaymentBlockTitle();
        String expectedTitle = "Онлайн пополнение без комиссии";
        Allure.addAttachment("Фактический заголовок", "text/plain", actualTitle);
        Assert.assertEquals(actualTitle, expectedTitle, "Название блока не совпадает с ожидаемым");
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(ITestResult result) {
        // Если тест упал — прикладываем скрин и HTML
        if (driver != null && !result.isSuccess()) {
            attachScreenshot("Скриншот при падении");
            attachPageSource();
            attachConsoleIfAvailable();
            Allure.addAttachment("URL", "text/plain", safeGetCurrentUrl());
        }
        if (driver != null) {
            driver.quit();
        }
    }

    private String safeGetCurrentUrl() {
        try {
            return driver.getCurrentUrl();
        } catch (Exception e) {
            return "Не удалось получить URL: " + e.getMessage();
        }
    }

    @Attachment(value = "{name}", type = "image/png")
    private byte[] attachScreenshot(String name) {
        try {
            return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        } catch (Exception e) {
            Allure.addAttachment("Ошибка при снятии скрина", "text/plain", e.toString());
            return new byte[0];
        }
    }

    @Attachment(value = "HTML страницы", type = "text/html")
    private byte[] attachPageSource() {
        try {
            return driver.getPageSource().getBytes();
        } catch (Exception e) {
            Allure.addAttachment("Ошибка при получении HTML", "text/plain", e.toString());
            return new byte[0];
        }
    }

    // На всякий случай — если используешь перехват console logs (в Chrome)
    @Attachment(value = "Консоль браузера", type = "text/plain")
    private String attachConsoleIfAvailable() {
        try {
            // Можно расширить: получение логов через DevTools или LogEntries
            return "Добавь чтение логов DevTools/LogEntries при необходимости";
        } catch (Exception e) {
            return "Не удалось получить логи: " + e.getMessage();
        }
    }
}
