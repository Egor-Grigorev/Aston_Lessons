package Lesson_2_9;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.Set;

public class TestMTS6Proba {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        driver.get("https://www.mts.by/");

        // Запоминаем дескриптор основного окна
        String mainWindow = driver.getWindowHandle();
        System.out.println("=== ДЕСКРИПТОР ОСНОВНОГО ОКНА ===");
        System.out.println("Основное окно: " + mainWindow);
        printWindowInfo(driver, mainWindow);

        // Принимаем куки и заполняем форму
        driver.findElement(By.xpath("//button[@id='cookie-agree']")).click();
        driver.findElement(By.xpath("//input[@placeholder='Номер телефона']")).sendKeys("297777777");
        driver.findElement(By.xpath("//*[@id=\"connection-sum\"]")).sendKeys("499");
        driver.findElement(By.xpath("//*[@id=\"pay-connection\"]/button")).click();

        System.out.println("\n=== ПОИСК ДЕСКРИПТОРОВ ПОСЛЕ НАЖАТИЯ КНОПКИ ===");

        // Ждем появления нового окна
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));

        // Получаем все дескрипторы окон
        Set<String> allWindows = driver.getWindowHandles();
        System.out.println("Всего окон: " + allWindows.size());

        // Выводим информацию о каждом окне
        for (String windowHandle : allWindows) {
            System.out.println("\n--- Дескриптор окна: " + windowHandle + " ---");
            printWindowInfo(driver, windowHandle);
        }

        // Переключаемся на платежное окно (не основное)
        for (String windowHandle : allWindows) {
            if (!windowHandle.equals(mainWindow)) {
                driver.switchTo().window(windowHandle);
                System.out.println("\n✅ Переключились на платежное окно: " + windowHandle);

                // Проверяем сумму
                checkPaymentAmount(driver);

                // Закрываем платежное окно
                driver.close();
                break;
            }
        }

        // Возвращаемся в основное окно
        driver.switchTo().window(mainWindow);
        System.out.println("Вернулись в основное окно");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
    }

    /**
     * ВЫВОД ИНФОРМАЦИИ О ОКНЕ
     */
    public static void printWindowInfo(WebDriver driver, String windowHandle) {
        // Сохраняем текущее окно
        String currentWindow = driver.getWindowHandle();

        try {
            // Переключаемся на нужное окно
            driver.switchTo().window(windowHandle);

            System.out.println("URL: " + driver.getCurrentUrl());
            System.out.println("Заголовок: " + driver.getTitle());
            System.out.println("Размер окна: " + driver.manage().window().getSize());
            System.out.println("Позиция окна: " + driver.manage().window().getPosition());

        } catch (Exception e) {
            System.out.println("Не удалось получить информацию об окне: " + e.getMessage());
        } finally {
            // Возвращаемся к исходному окну
            try {
                driver.switchTo().window(currentWindow);
            } catch (Exception e) {
                // Игнорируем ошибки возврата
            }
        }
    }

    /**
     * ПРОВЕРКА СУММЫ В ПЛАТЕЖНОМ ОКНЕ
     */
    public static void checkPaymentAmount(WebDriver driver) {
        try {
            WebElement sumElement = driver.findElement(By.xpath("//*[contains(text(), '499') and contains(text(), 'BYN')]"));
            String actualAmount = sumElement.getText();
            Assert.assertTrue(actualAmount.contains("499") && actualAmount.contains("BYN"));
            System.out.println("✅ Сумма корректна: " + actualAmount);
        } catch (Exception e) {
            System.out.println("❌ Сумма не найдена: " + e.getMessage());
        }
    }
}
