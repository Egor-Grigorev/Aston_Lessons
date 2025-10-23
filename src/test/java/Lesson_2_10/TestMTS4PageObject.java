package Lesson_2_10;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

/**
 * ТЕСТ 4: ПРОВЕРКА ФОРМЫ ОПЛАТЫ
 *
 * Этот тест проверяет:
 * 1. Заполнение полей номера телефона и суммы
 * 2. Нажатие кнопки "Продолжить"
 * 3. Что платежное окно открывается
 */
public class TestMTS4PageObject {

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
    public void testPaymentFormFunctionality() {
        System.out.println("=== ЗАПУСК ТЕСТА: Проверка формы оплаты ===");

        // Вызываем метод проверки формы оплаты из Page Object
        mtsHomePage.verifyPaymentForm();

        System.out.println("=== ТЕСТ УСПЕШНО ЗАВЕРШЕН ===");
    }

    @AfterMethod
    public void tearDown() {
        try {
            Thread.sleep(10000); // Ждем 10 секунд чтобы увидеть платежное окно
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        if (driver != null) {
            driver.quit();
            System.out.println("Браузер закрыт");
        }
    }
}
