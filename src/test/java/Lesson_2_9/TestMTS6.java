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

public class TestMTS6 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        driver.get("https://www.mts.by/");

        // Запоминаем идентификатор текущего окна
        String mainWindow = driver.getWindowHandle();
        System.out.println("Основное окно: " + mainWindow);

        WebElement input = driver.findElement(By.xpath("//button[@id='cookie-agree']"));
        input.click();

        WebElement phoneNumber = driver.findElement(By.xpath("//input [@placeholder='Номер телефона']"));
        phoneNumber.click();
        phoneNumber.sendKeys("297777777");

        WebElement sum = driver.findElement(By.xpath("//*[@id=\"connection-sum\"]"));
        sum.click();
        sum.sendKeys("499");

        WebElement resume = driver.findElement(By.xpath("//*[@id=\"pay-connection\"]/button"));
        resume.click();

//-------------------------------------------------------
        //переход на фрейм
        //WebElement paymentFrame = driver.findElement(By.xpath("//iframe[@class='bepaid-iframe' and contains(@src, 'bepaid.by')]"));
        //driver.switchTo().frame(paymentFrame);
//----
        // Ожидание появления iframe и переключение на него
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement paymentFrame = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//iframe[@class='bepaid-iframe' and contains(@src, 'bepaid.by')]")));
        driver.switchTo().frame(paymentFrame);

        // Ожидание загрузки элементов внутри iframe
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//span[contains(@class, 'ng-star-inserted')]")));
//----

        //Проверка "отображение суммы в шапке платежного окна"
        WebElement correcSumHeader = driver.findElement(
                By.xpath("//span[@class='ng-star-inserted' and text()='499.00 BYN']"));
        String actualText = correcSumHeader.getText().trim();
        String expectedText = "499.00 BYN";
        Assert.assertEquals(actualText, expectedText, "Отображаемая сумма в шапке не совпадает с ожидаемой");
        System.out.println("Отображение суммы в шапке платежного окна ОР = ФР ");

        //В том числе на кнопке
        WebElement buttonSum
                = driver.findElement(By.xpath("//span[@class='ng-star-inserted' and text()='499.00 BYN']"));
        actualText = buttonSum.getText();
        expectedText = "499.00 BYN";
        Assert.assertEquals(actualText, expectedText, "Отображаемая сумма в кнопке не совпадает с ожидаемой");
        System.out.println("Отображение суммы в кнопке платежного окна ОР = ФР ");

        //Проверка на соответствие номера телефона в шапке модального окна
        WebElement phoneNumber2
                = driver.findElement(By.xpath("//span[contains(text(), '375297777777')]"));
        actualText = phoneNumber2.getText();
        expectedText = "Оплата: Услуги связи Номер:375297777777";
        Assert.assertEquals(actualText, expectedText, "Отображаемый номер телефона не совпадает с ожидаемым");
        System.out.println("Отображение номера в шапке платежного окна ОР = ФР ");


        //Проверка на соответствие поля: "Номер карты"
        WebElement cardNumber = driver.findElement(
                By.xpath("//label[contains(@class, 'ng-star-inserted') and text()='Номер карты']"));
        actualText = cardNumber.getText();
        expectedText = "Номер карты";
        Assert.assertEquals(actualText, expectedText, "Отображение  надписи в незаполненном поле для ввода Номера карты не совпадает с ожидаемым");
        System.out.println("Отображение  надписи в незаполненном поле для ввода 'Номера карты' ОР = ФР ");

        //Проверка на соответствие поля: "Срок действия"
        WebElement date = driver.findElement(
                By.xpath("//label[contains(text(), 'Срок действия')]"));
        actualText = date.getText();
        expectedText = "Срок действия";
        Assert.assertEquals(actualText, expectedText, "Отображение  надписи в незаполненном поле для ввода Срокa действия не совпадает с ожидаемым");
        System.out.println("Отображение  надписи в незаполненном поле для ввода 'Срока действия' ОР = ФР ");

        //Проверка на соответствие поля: "CVC"
        WebElement cvc = driver.findElement(
                By.xpath("//label[text()='CVC']"));
        actualText = cvc.getText();
        expectedText = "CVC";
        Assert.assertEquals(actualText, expectedText, "Отображение  надписи в незаполненном поле для ввода CVC не совпадает с ожидаемым");
        System.out.println("Отображение  надписи в незаполненном поле для ввода 'CVC' ОР = ФР ");

        //Проверка на соответствие поля: "Имя и фамилия на карте"
        WebElement name = driver.findElement(
                By.xpath("//label[text()='Имя и фамилия на карте']"));
        actualText = name.getText();
        expectedText = "Имя и фамилия на карте";
        Assert.assertEquals(actualText, expectedText, "Отображение  надписи в незаполненном поле для ввода Имя и фамилия на карте не совпадает с ожидаемым");
        System.out.println("Отображение  надписи в незаполненном поле для ввода 'Имя и фамилия на карте' ОР = ФР ");
//--------------------------------------------------------------------------------

        WebElement visa = driver.findElement(By.xpath("//img[contains(@src, 'visa-system.svg')]"));
        Assert.assertTrue(visa.isDisplayed(), "Логотип Visa не отображается");
        System.out.println("Логотип Карты Visa найден и отображается!");

        WebElement masterCard = driver.findElement(By.xpath("//img[contains(@src, 'mastercard-system.svg')]"));
        Assert.assertTrue(masterCard.isDisplayed(), "Логотип Mastercard не отображается");
        System.out.println("Логотип Карты Mastercard найден и отображается!");

        WebElement belkart = driver.findElement(By.xpath("//img[contains(@src, 'belkart-system.svg')]"));
        Assert.assertTrue(belkart.isDisplayed(), "Логотип belkart не отображается");
        System.out.println("Логотип Карты belkart найден и отображается!");


        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
    }
}
