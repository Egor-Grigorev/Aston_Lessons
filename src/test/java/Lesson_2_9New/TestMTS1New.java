package Lesson_2_9New;

import Lesson_2_9New.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestMTS1New extends Base { // Наследуем от Base класса

    @Test
    public void test1() {
        // Все настройки драйвера уже выполнены в Base.setUp()

        WebElement paymentBlock = driver.findElement(By.xpath("//h2[contains(text(), 'Онлайн пополнение')]"));

        // ПРОВЕРКА 1: Проверяем что блок отображается на странице
        Assert.assertTrue(paymentBlock.isDisplayed(), "Блок 'Онлайн пополнение без комиссии' не отображается на странице");

        // ПРОВЕРКА 2: Получаем фактический текст и нормализуем его (убираем переносы строк)
        String actualTitle = paymentBlock.getText();
        String normalizedActualTitle = actualTitle.replace("\n", " ").replace("\r", " ").trim();
        String expectedTitle = "Онлайн пополнение без комиссии";

        // Сравниваем нормализованный текст
        Assert.assertEquals(normalizedActualTitle, expectedTitle, "Название блока не совпадает с ожидаемым");

        // Thread.sleep не нужен, так как закрытие драйвера выполнится в Base.tearDown()
    }
}
