package Lesson_2_9;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;

public class TestMTS5 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //driver.manage().window().maximize();
        driver.get("https://www.mts.by/");

        WebElement input = driver.findElement(By.xpath("//button[@id='cookie-agree']"));
        input.click();
        //------------------------------
        WebElement visa = driver.findElement(By.xpath("//img[@alt='Visa']"));
        visa.click();

        //Проверка "Услуги связи. Поле: Номер телефона"
        WebElement phoneNumber = driver.findElement(By.xpath("//input[@type='text' and @placeholder='Номер телефона']"));
        String actualPlaceholder = phoneNumber.getAttribute("placeholder");
        String expectedPlaceholder = "Номер телефона";
        Assert.assertEquals(actualPlaceholder, expectedPlaceholder, "Плейсхолдер поля не совпадает с ожидаемым");
        System.out.println("Услуги связи. Поле: Номер телефона ОР = ФР ");

        //Проверка "Услуги связи. Поле: Сумма"
        WebElement sum = driver.findElement(By.xpath("//input[@id='connection-sum' and @type='text' and contains(@class, 'total_rub')]"));
        actualPlaceholder = sum.getAttribute("placeholder");
        expectedPlaceholder = "Сумма";
        Assert.assertEquals(actualPlaceholder, expectedPlaceholder, "Плейсхолдер поля не совпадает с ожидаемым");
        System.out.println("Услуги связи. Поле: Сумма ОР = ФР ");

        //Проверка "Услуги связи. Поле: E-mail для отправки чека"
        WebElement email = driver.findElement(By.xpath("//input[@id='connection-email' and @placeholder='E-mail для отправки чека']"));
        actualPlaceholder = email.getAttribute("placeholder");
        expectedPlaceholder = "E-mail для отправки чека";
        Assert.assertEquals(actualPlaceholder, expectedPlaceholder, "Плейсхолдер поля не совпадает с ожидаемым");
        System.out.println("Услуги связи. Поле: E-mail для отправки чека ОР = ФР ");


        WebElement selectArrow = driver.findElement(By.xpath("//span[@class='select__arrow']"));
        selectArrow.click();
        WebElement homeInternet = driver.findElement(By.xpath("//li[.//p[text()='Домашний интернет']]"));
        homeInternet.click();


        //Проверка "Домашний интернет. Поле: Номер абонента"
        WebElement phoneNumberHI = driver.findElement(By.xpath("//input[@type='text' and @placeholder='Номер абонента']"));
        actualPlaceholder = phoneNumberHI.getAttribute("placeholder");
        expectedPlaceholder = "Номер абонента";
        Assert.assertEquals(actualPlaceholder, expectedPlaceholder, "Плейсхолдер поля не совпадает с ожидаемым");
        System.out.println("Домашний интернет. Поле: Номер абонента ОР = ФР ");

        //Проверка "Домашний интернет. Поле: Сумма"
        WebElement sumHI = driver.findElement(By.xpath("//input[@id='internet-sum' and @placeholder='Сумма']"));
        actualPlaceholder = sumHI.getAttribute("placeholder");
        expectedPlaceholder = "Сумма";
        Assert.assertEquals(actualPlaceholder, expectedPlaceholder, "Плейсхолдер поля не совпадает с ожидаемым");
        System.out.println("Домашний интернет. Поле: Сумма ОР = ФР ");

        //Проверка "Домашний интернет. Поле: E-mail для отправки чека"
        WebElement emailHI = driver.findElement(By.xpath("//input[@id='internet-email' and @placeholder='E-mail для отправки чека']"));
        actualPlaceholder = emailHI.getAttribute("placeholder");
        expectedPlaceholder = "E-mail для отправки чека";
        Assert.assertEquals(actualPlaceholder, expectedPlaceholder, "Плейсхолдер поля не совпадает с ожидаемым");
        System.out.println("Домашний интернет. Поле: E-mail для отправки чека ОР = ФР ");
//----------------------------------------------------------------------------

        WebElement selectArrow2 = driver.findElement(By.xpath("//span[@class='select__arrow']"));
        selectArrow2.click();
        WebElement installment = driver.findElement(By.xpath("//p[text()='Рассрочка']"));
        installment.click();


        //Проверка "Рассрочка. Поле: Номер счета на 44"
        WebElement instalment = driver.findElement(By.xpath("//input[@placeholder='Номер счета на 44']"));
        actualPlaceholder = instalment.getAttribute("placeholder");
        expectedPlaceholder = "Номер счета на 44";
        Assert.assertEquals(actualPlaceholder, expectedPlaceholder, "Плейсхолдер поля не совпадает с ожидаемым");
        System.out.println("Рассрочка. Поле: Номер счета на 44 ОР = ФР ");

        //Проверка "Рассрочка. Поле: Сумма"
        WebElement sum3 = driver.findElement(By.xpath("//input[@id='instalment-sum' and @placeholder='Сумма']"));
        actualPlaceholder = sum3.getAttribute("placeholder");
        expectedPlaceholder = "Сумма";
        Assert.assertEquals(actualPlaceholder, expectedPlaceholder, "Плейсхолдер поля не совпадает с ожидаемым");
        System.out.println("Рассрочка. Поле: Сумма ОР = ФР ");

        //Проверка "Рассрочка. Поле: E-mail для отправки чека"
        WebElement email3 = driver.findElement(By.xpath("//input[@id='instalment-email' and @placeholder='E-mail для отправки чека']"));
        actualPlaceholder = email3.getAttribute("placeholder");
        expectedPlaceholder = "E-mail для отправки чека";
        Assert.assertEquals(actualPlaceholder, expectedPlaceholder, "Плейсхолдер поля не совпадает с ожидаемым");
        System.out.println("Рассрочка. Поле: E-mail для отправки чека ОР = ФР ");
//--------------------------------------------------------------------------------------------

        WebElement selectArrow3 = driver.findElement(By.xpath("//span[@class='select__arrow']"));
        selectArrow3.click();
        WebElement debt = driver.findElement(By.xpath("//p[@class='select__option' and contains(text(), 'Задолженность')]"));
        debt.click();

        //Проверка "Задолженность. Поле: Номер счета на 2073"
        WebElement accountNumber = driver.findElement(By.xpath("//input[@id='score-arrears']"));
        actualPlaceholder = accountNumber.getAttribute("placeholder");
        expectedPlaceholder = "Номер счета на 2073";
        Assert.assertEquals(actualPlaceholder, expectedPlaceholder, "Плейсхолдер поля не совпадает с ожидаемым");
        System.out.println("Задолженность. Поле: Номер счета на 2073 ОР = ФР ");

        //Проверка "Задолженность. Поле: Сумма"
        WebElement sum4 = driver.findElement(By.xpath("//input[@id='arrears-sum' and @placeholder='Сумма']"));
        actualPlaceholder = sum4.getAttribute("placeholder");
        expectedPlaceholder = "Сумма";
        Assert.assertEquals(actualPlaceholder, expectedPlaceholder, "Плейсхолдер поля не совпадает с ожидаемым");
        System.out.println("Задолженность. Поле: Сумма ОР = ФР ");

        //Проверка "Задолженность. Поле: E-mail для отправки чека"
        WebElement email4 = driver.findElement(By.xpath("//input[@id='arrears-email' and @placeholder='E-mail для отправки чека']"));
        actualPlaceholder = email4.getAttribute("placeholder");
        expectedPlaceholder = "E-mail для отправки чека";
        Assert.assertEquals(actualPlaceholder, expectedPlaceholder, "Плейсхолдер поля не совпадает с ожидаемым");
        System.out.println("Задолженность. Поле: E-mail для отправки чека ОР = ФР ");


//--------------------------------
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
    }
}
