package Lesson_2_10;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

@Epic("MTS")
@Feature("Главная страница")
@Story("Отображение логотипов платёжных систем")
@Owner("qa")
@Severity(SeverityLevel.MINOR)
// слушатель Allure подключён в testng.xml; если нет — раскомментируй ниже
// @Listeners({io.qameta.allure.testng.AllureTestNg.class})
public class TestMTS2 {

    private WebDriver driver;
    private HomePage homePage;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
//        ChromeOptions opts = new ChromeOptions();           // если нужно в CI/headless
//        opts.addArguments("--headless=new","--window-size=1920,1080");
//        driver = new ChromeDriver(opts);
        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        Allure.step("Открыть https://www.mts.by/");
        driver.get("https://www.mts.by/");

        homePage = new HomePage(driver);

        Allure.step("Принять cookies (если баннер есть)");
        homePage.acceptCookies();

        Allure.step("Прокрутить к блоку оплаты");
        homePage.scrollToPaymentBlock();
    }

    @Test(description = "Все логотипы платёжных систем отображаются в блоке оплаты")
    public void testPaymentLogosDisplay() {
        SoftAssert softly = new SoftAssert();

        Allure.step("Проверить отображение логотипов");
        softly.assertTrue(homePage.isVisaDisplayed(), "Не отображается логотип Visa");
        softly.assertTrue(homePage.isVisaVerifiedDisplayed(), "Не отображается логотип Verified by Visa");
        softly.assertTrue(homePage.isMasterCardDisplayed(), "Не отображается логотип MasterCard");
        softly.assertTrue(homePage.isMasterCardSecureCodeDisplayed(), "Не отображается логотип MasterCard SecureCode");
        softly.assertTrue(homePage.isBelcardDisplayed(), "Не отображается логотип Белкарт");

        // для удобства в отчёте
        Allure.addAttachment("Текущий URL", "text/plain", homePage.getCurrentUrl());
        softly.assertAll();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(ITestResult result) {
        if (driver != null && !result.isSuccess()) {
            Allure.addAttachment("Скрин при падении", "image/png",
                    new java.io.ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)),
                    ".png");
            Allure.addAttachment("HTML страницы", "text/html", safePageSource(), ".html");
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