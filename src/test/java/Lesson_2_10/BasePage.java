package Lesson_2_10;

import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

/**
 * Базовый класс для всех страниц (Page Object).
 * Содержит общие поля, ожидания и безопасные действия.
 */
public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected WebDriverWait waitShort;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.waitShort = new WebDriverWait(driver, Duration.ofSeconds(5));
        PageFactory.initElements(driver, this);
    }

    // ---------- Общие методы ----------

    @Step("Клик по элементу")
    protected void click(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    @Step("Ввести текст '{text}' в элемент")
    protected void type(WebElement element, String text) {
        wait.until(ExpectedConditions.visibilityOf(element)).clear();
        element.sendKeys(text);
    }

    @Step("Проверить, что элемент отображается")
    protected boolean isDisplayed(WebElement element) {
        try {
            return wait.until(ExpectedConditions.visibilityOf(element)).isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }

    @Step("Получить текст элемента")
    protected String getElementText(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element))
                .getText()
                .replace("\n", " ")
                .replace("\r", " ")
                .trim();
    }

    @Step("Безопасный клик (короткое ожидание)")
    protected void safeClick(WebElement element) {
        try {
            waitShort.until(ExpectedConditions.elementToBeClickable(element)).click();
        } catch (TimeoutException | NoSuchElementException ignored) {
            // элемент не обязателен — просто пропускаем
        }
    }

    @Step("Прокрутка до элемента")
    protected void scrollTo(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", element);
    }

    @Step("Получить текущий URL")
    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    @Step("Перейти по ссылке {url}")
    public void navigateTo(String url) {
        driver.navigate().to(url);
    }

    @Step("Обновить страницу")
    public void refresh() {
        driver.navigate().refresh();
    }

    @Step("Назад в браузере")
    public void goBack() {
        driver.navigate().back();
    }
}
