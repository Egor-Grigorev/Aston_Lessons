package Lesson_2_9;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class TestYandex {

    public static void main(String[] args) {
        // Загрузка подходящего драйвера Chrome
        WebDriverManager.chromedriver().setup();

        // Создание экземпляра WebDriver
        WebDriver driver = new ChromeDriver();

        // Установка неявного ожидания (новый синтаксис)
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        // Переход на сайт
        driver.get("https://ya.ru/");

        // Это локатор
        WebElement input = driver.findElement(By.xpath("//input[@ aria-label='Запрос']"));
        //input.click();
        input.sendKeys("погода в Москве");
        ///html/body/main/div[2]/form/div[4]/div[2]/button/svg/path
        WebElement toFind = driver.findElement(By.xpath("//button[@ aria-label='Найти']"));
        toFind.click();

    }
}
