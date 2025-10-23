package Lesson_2_10;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

/**
 * ТЕСТ 1: ПРОВЕРКА БЛОКА "ОНЛАЙН ПОПОЛНЕНИЕ БЕЗ КОМИССИИ"
 *
 * Этот тест проверяет:
 * 1. Что блок отображается на странице
 * 2. Что заголовок блока правильный
 *
 * Используем аннотации TestNG для организации тестов:
 * @BeforeMethod - выполняется ПЕРЕД каждым тестом
 * @Test - сам тестовый метод
 * @AfterMethod - выполняется ПОСЛЕ каждого теста
 */
public class TestMTS1PageObject {

    // Драйвер для управления браузером
    private WebDriver driver;

    // Наш Page Object для работы со страницей
    private MTSHomePage mtsHomePage;

    /**
     * МЕТОД НАСТРОЙКИ - выполняется перед каждым тестом
     * Здесь мы подготавливаем окружение для теста
     */
    @BeforeMethod
    public void setUp() {
        // Настраиваем ChromeDriver автоматически
        WebDriverManager.chromedriver().setup();

        // Создаем экземпляр ChromeDriver
        driver = new ChromeDriver();

        // Настраиваем неявное ожидание (ждем элементы до 15 секунд)
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // Разворачиваем окно браузера на весь экран
        driver.manage().window().maximize();

        // Переходим на сайт MTS
        driver.get("https://www.mts.by/");

        // Создаем экземпляр Page Object
        mtsHomePage = new MTSHomePage(driver);

        // Принимаем cookies
        mtsHomePage.acceptCookies();
    }

    /**
     * ТЕСТОВЫЙ МЕТОД - проверка блока оплаты
     * Этот метод соответствует исходному TestMTS1
     */
    @Test
    public void testPaymentBlockDisplay() {
        System.out.println("=== ЗАПУСК ТЕСТА: Проверка блока оплаты ===");

        // Вызываем метод проверки из Page Object
        mtsHomePage.verifyPaymentBlock();

        System.out.println("=== ТЕСТ УСПЕШНО ЗАВЕРШЕН ===");
    }

    /**
     * МЕТОД ЗАВЕРШЕНИЯ - выполняется после каждого теста
     * Здесь мы закрываем браузер и освобождаем ресурсы
     */
    @AfterMethod
    public void tearDown() {
        try {
            // Ждем 2 секунды чтобы увидеть результат
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // Закрываем браузер
        if (driver != null) {
            driver.quit();
            System.out.println("Браузер закрыт");
        }
    }
}
