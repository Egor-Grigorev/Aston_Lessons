package Lesson_2_10;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * БАЗОВЫЙ КЛАСС ДЛЯ ВСЕХ СТРАНИЦ
 *
 * Этот класс содержит общую логику, которая будет использоваться
 * во всех Page Object классах
 */
public class BasePage {

    // Драйвер для управления браузером
    protected WebDriver driver;

    // Ожидание для стабильности тестов (ждем элементы до 15 секунд)
    protected WebDriverWait wait;

    // Конструктор - вызывается при создании каждого Page Object
    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        // Инициализируем элементы, помеченные аннотацией @FindBy
        PageFactory.initElements(driver, this);
    }
}
