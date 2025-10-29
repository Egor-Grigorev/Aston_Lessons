package Lesson_2_9New;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class Base {
    protected WebDriver driver; // Объявляем driver как поле класса

    @BeforeMethod
    public void setUp() {
        // Загрузка подходящего драйвера Chrome
        WebDriverManager.chromedriver().setup();
        // Создание экземпляра WebDriver
        /*WebDriver*/ driver = new ChromeDriver();
        // Установка неявного ожидания
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        driver.get("https://www.mts.by/");

        WebElement input = driver.findElement(By.xpath("//button[@id='cookie-agree']"));
        input.click();
    }

        @AfterMethod
        public void tearDown() {
            if (driver != null) {
                driver.quit();

        }
    }
}


