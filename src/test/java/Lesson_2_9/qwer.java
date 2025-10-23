package Lesson_2_9;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class qwer {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.mts.by/");

        // Принимаем куки
        driver.findElement(By.xpath("//button[@id='cookie-agree']")).click();

        System.out.println("=== ПРОВЕРКА ПОДСКАЗОК В ПОЛЯХ ДЛЯ ВСЕХ ВАРИАНТОВ ОПЛАТЫ ===\n");

        // Проверяем все варианты оплаты
        checkPaymentType(driver, "Услуги связи", "Номер телефона");
        checkPaymentType(driver, "Домашний интернет", "Номер абонента");
        checkPaymentType(driver, "Рассрочка", "Номер договора");
        checkPaymentType(driver, "Задолженность", "ID");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
    }

    /**
     * ПРОВЕРКА ПОДСКАЗОК ДЛЯ КОНКРЕТНОГО ВАРИАНТА ОПЛАТЫ
     */
    public static void checkPaymentType(WebDriver driver, String paymentType, String mainFieldPlaceholder) {
        System.out.println("--- " + paymentType + " ---");

        // Переключаемся на нужный вариант оплаты
        switchToPaymentType(driver, paymentType);

        // Проверяем основное поле (уникальное для каждого варианта)
        boolean mainFieldFound = checkFieldPlaceholder(driver, mainFieldPlaceholder, "Основное поле");

        // Проверяем общие поля (которые есть у всех вариантов)
        boolean sumFieldFound = checkFieldPlaceholder(driver, "Сумма", "Поле суммы");
        boolean emailFieldFound = checkFieldPlaceholder(driver, "E-mail для отправки чека", "Поле email");

        // Выводим итог
        if (mainFieldFound && sumFieldFound && emailFieldFound) {
            System.out.println("✓ Все подсказки корректны\n");
        } else {
            System.out.println("⚠ Некоторые поля не найдены, но тест продолжается\n");
        }
    }

    /**
     * ПЕРЕКЛЮЧЕНИЕ МЕЖДУ ВАРИАНТАМИ ОПЛАТЫ
     */
    public static void switchToPaymentType(WebDriver driver, String paymentType) {
        try {
            // Открываем выпадающий список
            WebElement dropdown = driver.findElement(By.xpath("//button[contains(@class, 'select__header')]"));
            dropdown.click();

            // Ждем появления опций
            Thread.sleep(1000);

            // Выбираем нужный вариант
            WebElement option = driver.findElement(By.xpath("//li[.//p[text()='" + paymentType + "']]"));
            option.click();

            // Ждем применения изменений
            Thread.sleep(1000);

        } catch (Exception e) {
            System.out.println("❌ Ошибка при переключении на: " + paymentType);
        }
    }

    /**
     * ПРОВЕРКА ПОДСКАЗКИ В КОНКРЕТНОМ ПОЛЕ (возвращает true если поле найдено)
     */
    public static boolean checkFieldPlaceholder(WebDriver driver, String expectedPlaceholder, String fieldDescription) {
        try {
            // Ищем поле по плейсхолдеру
            WebElement field = driver.findElement(By.xpath("//input[@placeholder='" + expectedPlaceholder + "']"));
            String actualPlaceholder = field.getAttribute("placeholder");

            // Проверяем что подсказка правильная
            Assert.assertEquals(actualPlaceholder, expectedPlaceholder,
                    "Неверная подсказка в поле: " + fieldDescription);

            System.out.println("  ✓ " + fieldDescription + ": '" + actualPlaceholder + "'");
            return true;

        } catch (Exception e) {
            System.out.println("  ⚠ Поле '" + fieldDescription + "' не найдено (ожидалось: '" + expectedPlaceholder + "')");

            // Дополнительная диагностика: выводим какие поля вообще есть на странице
            if (fieldDescription.equals("Основное поле")) {
                printAvailableFields(driver);
            }
            return false;
        }
    }

    /**
     * ДИАГНОСТИКА: ВЫВОД ВСЕХ ДОСТУПНЫХ ПОЛЕЙ НА СТРАНИЦЕ
     */
    public static void printAvailableFields(WebDriver driver) {
        try {
            List<WebElement> allInputs = driver.findElements(By.xpath("//input[@placeholder]"));
            System.out.println("    Доступные поля на странице:");
            for (WebElement input : allInputs) {
                String placeholder = input.getAttribute("placeholder");
                String id = input.getAttribute("id");
                System.out.println("      - '" + placeholder + "' (id: " + (id != null ? id : "нет") + ")");
            }
        } catch (Exception e) {
            System.out.println("    Не удалось получить список полей");
        }
    }
}