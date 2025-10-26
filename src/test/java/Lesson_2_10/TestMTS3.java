package Lesson_2_10;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.testng.Assert;

import java.io.ByteArrayInputStream;
import java.time.Duration;

@Epic("MTS")
@Feature("Главная страница")
@Story("Ссылка 'Подробнее о сервисе'")
@Owner("qa")
@Severity(SeverityLevel.NORMAL)
// Если в testng.xml уже подключён Allure listener, этот @Listeners можно не использовать
// @Listeners({io.qameta.allure.testng.AllureTestNg.class})
public class TestMTS3 {

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

        Allure.step("Принять cookies (если баннер есть)");
        homePage.acceptCookies();
    }

    @Test(description = "Проверить, что ссылка 'Подробнее о сервисе' видна и кликабельна")
    public void testDetailsLink() {
        Allure.step("Проверить, что ссылка 'Подробнее о сервисе' отображается");
        Assert.assertTrue(
                homePage.isDetailsLinkDisplayed(),
                "Ссылка 'Подробнее о сервисе' не отображается на странице"
        );

        Allure.step("Кликнуть по ссылке 'Подробнее о сервисе'");
        homePage.clickDetailsLink();

        String currentUrl = homePage.getCurrentUrl();
        Allure.addAttachment("Текущий URL после клика", "text/plain", currentUrl);

        Allure.step("Проверить, что URL изменился после перехода");
        Assert.assertNotEquals(
                currentUrl,
                "https://www.mts.by/",
                "Переход по ссылке не произошёл (URL не изменился)"
        );

        Allure.addAttachment("Результат", "text/plain", "Ссылка работает корректно");
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(ITestResult result) {
        if (driver != null && !result.isSuccess()) {
            // Скриншот и HTML при падении
            Allure.addAttachment(
                    "Скриншот при падении",
                    "image/png",
                    new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)),
                    ".png"
            );
            Allure.addAttachment("HTML страницы", "text/html", safePageSource(), ".html");
            Allure.addAttachment("URL страницы", "text/plain", homePage.getCurrentUrl());
        }

        if (driver != null) {
            driver.quit();
        }
    }

    private String safePageSource() {
        try {
            return driver.getPageSource();
        } catch (Exception e) {
            return "Не удалось получить pageSource: " + e.getMessage();
        }
    }
}
