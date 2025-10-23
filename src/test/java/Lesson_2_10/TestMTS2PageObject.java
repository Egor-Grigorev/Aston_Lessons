package Lesson_2_10;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

/**
 * ТЕСТ 2: ПРОВЕРКА ЛОГОТИПОВ ПЛАТЕЖНЫХ СИСТЕМ
 *
 * Этот тест проверяет что все логотипы платежных систем отображаются:
 * - Visa
 * - Verified By Visa
 * - MasterCard
 * - MasterCard Secure Code
 * - Белкарт
 */
public class TestMTS2PageObject {

    private WebDriver driver;
    private MTSHomePage mtsHomePage;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        driver.get("https://www.mts.by/");

        mtsHomePage = new MTSHomePage(driver);
        mtsHomePage.acceptCookies();
    }

    @Test
    public void testPaymentSystemLogos() {
        System.out.println("=== ЗАПУСК ТЕСТА: Проверка логотипов платежных систем ===");

        // Вызываем метод проверки логотипов из Page Object
        mtsHomePage.verifyPaymentSystemLogos();

        System.out.println("=== ТЕСТ УСПЕШНО ЗАВЕРШЕН ===");
    }

    @AfterMethod
    public void tearDown() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        if (driver != null) {
            driver.quit();
            System.out.println("Браузер закрыт");
        }
    }
}
