package Lesson_2_9;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;

public class TestMTS1 {

    public static void main(String[] args) {
        // Загрузка подходящего драйвера Chrome
        WebDriverManager.chromedriver().setup();
        // Создание экземпляра WebDriver
        WebDriver driver = new ChromeDriver();
        // Установка неявного ожидания
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        driver.get("https://www.mts.by/");

        WebElement input = driver.findElement(By.xpath("//button[@id='cookie-agree']"));
        input.click();

        WebElement paymentBlock = driver.findElement(By.xpath("//h2[contains(text(), 'Онлайн пополнение')]"));
        paymentBlock.click();

        // ПРОВЕРКА 1: Проверяем что блок отображается на странице
        Assert.assertTrue(paymentBlock.isDisplayed(), "Блок 'Онлайн пополнение без комиссии' не отображается на странице");


        // ПРОВЕРКА 2: Получаем фактический текст и нормализуем его (убираем переносы строк)
        String actualTitle = paymentBlock.getText();
        String normalizedActualTitle = actualTitle.replace("\n", " ").replace("\r", " ").trim();
        String expectedTitle = "Онлайн пополнение без комиссии";

        // Сравниваем нормализованный текст
        Assert.assertEquals(normalizedActualTitle, expectedTitle, "Название блока не совпадает с ожидаемым");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();


    }
}
