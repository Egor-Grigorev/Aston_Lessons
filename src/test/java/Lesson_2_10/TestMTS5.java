package Lesson_2_10;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestMTS5 {
    private WebDriver driver;
    private HomePage homePage;
    private PaymentPage paymentPage;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.mts.by/");

        homePage = new HomePage(driver);
        paymentPage = new PaymentPage(driver);
        homePage.acceptCookies();

        // Переходим к блоку оплаты
        homePage.clickPaymentBlock();
    }

    @Test
    public void testAllServiceTypesPlaceholders() {


        // Проверка "Услуги связи. Поле: Номер телефона"
        String actualPlaceholder = paymentPage.getPhoneFieldPlaceholder();
        String expectedPlaceholder = "Номер телефона";
        Assert.assertEquals(actualPlaceholder, expectedPlaceholder,
                "Плейсхолдер поля не совпадает с ожидаемым");
        System.out.println("Услуги связи. Поле: Номер телефона ОР = ФР");

        // Проверка "Услуги связи. Поле: Сумма"
        actualPlaceholder = paymentPage.getSumFieldPlaceholder();
        expectedPlaceholder = "Сумма";
        Assert.assertEquals(actualPlaceholder, expectedPlaceholder,
                "Плейсхолдер поля не совпадает с ожидаемым");
        System.out.println("Услуги связи. Поле: Сумма ОР = ФР");

        // Проверка "Услуги связи. Поле: E-mail для отправки чека"
        actualPlaceholder = paymentPage.getEmailFieldPlaceholder();
        expectedPlaceholder = "E-mail для отправки чека";
        Assert.assertEquals(actualPlaceholder, expectedPlaceholder,
                "Плейсхолдер поля не совпадает с ожидаемым");
        System.out.println("Услуги связи. Поле: E-mail для отправки чека ОР = ФР");


        // Переключаемся на домашний интернет
        paymentPage.selectServiceType("домашний интернет");

        // Проверка "Домашний интернет. Поле: Номер абонента"
        actualPlaceholder = paymentPage.getSubscriberNumberPlaceholder();
        expectedPlaceholder = "Номер абонента";
        Assert.assertEquals(actualPlaceholder, expectedPlaceholder,
                "Плейсхолдер поля не совпадает с ожидаемым");
        System.out.println("Домашний интернет. Поле: Номер абонента ОР = ФР");

        // Проверка "Домашний интернет. Поле: Сумма"
        actualPlaceholder = paymentPage.getSumFieldPlaceholder();
        expectedPlaceholder = "Сумма";
        Assert.assertEquals(actualPlaceholder, expectedPlaceholder,
                "Плейсхолдер поля не совпадает с ожидаемым");
        System.out.println("Домашний интернет. Поле: Сумма ОР = ФР");

        // Проверка "Домашний интернет. Поле: E-mail для отправки чека"
        actualPlaceholder = paymentPage.getEmailFieldPlaceholder();
        expectedPlaceholder = "E-mail для отправки чека";
        Assert.assertEquals(actualPlaceholder, expectedPlaceholder,
                "Плейсхолдер поля не совпадает с ожидаемым");
        System.out.println("Домашний интернет. Поле: E-mail для отправки чека ОР = ФР");


        // Переключаемся на рассрочку
        paymentPage.selectServiceType("рассрочка");

        // Проверка "Рассрочка. Поле: Номер счета на 44"
        actualPlaceholder = paymentPage.getInstallmentAccountPlaceholder();
        expectedPlaceholder = "Номер счета на 44";
        Assert.assertEquals(actualPlaceholder, expectedPlaceholder,
                "Плейсхолдер поля не совпадает с ожидаемым");
        System.out.println("Рассрочка. Поле: Номер счета на 44 ОР = ФР");

        // Проверка "Рассрочка. Поле: Сумма"
        actualPlaceholder = paymentPage.getSumFieldPlaceholder();
        expectedPlaceholder = "Сумма";
        Assert.assertEquals(actualPlaceholder, expectedPlaceholder,
                "Плейсхолдер поля не совпадает с ожидаемым");
        System.out.println("Рассрочка. Поле: Сумма ОР = ФР");

        // Проверка "Рассрочка. Поле: E-mail для отправки чека"
        actualPlaceholder = paymentPage.getEmailFieldPlaceholder();
        expectedPlaceholder = "E-mail для отправки чека";
        Assert.assertEquals(actualPlaceholder, expectedPlaceholder,
                "Плейсхолдер поля не совпадает с ожидаемым");
        System.out.println("Рассрочка. Поле: E-mail для отправки чека ОР = ФР");


        // Переключаемся на задолженность
        paymentPage.selectServiceType("задолженность");

        // Проверка "Задолженность. Поле: Номер счета на 2073"
        actualPlaceholder = paymentPage.getDebtAccountPlaceholder();
        expectedPlaceholder = "Номер счета на 2073";
        Assert.assertEquals(actualPlaceholder, expectedPlaceholder,
                "Плейсхолдер поля не совпадает с ожидаемым");
        System.out.println("Задолженность. Поле: Номер счета на 2073 ОР = ФР");

        // Проверка "Задолженность. Поле: Сумма"
        actualPlaceholder = paymentPage.getSumFieldPlaceholder();
        expectedPlaceholder = "Сумма";
        Assert.assertEquals(actualPlaceholder, expectedPlaceholder,
                "Плейсхолдер поля не совпадает с ожидаемым");
        System.out.println("Задолженность. Поле: Сумма ОР = ФР");

        // Проверка "Задолженность. Поле: E-mail для отправки чека"
        actualPlaceholder = paymentPage.getEmailFieldPlaceholder();
        expectedPlaceholder = "E-mail для отправки чека";
        Assert.assertEquals(actualPlaceholder, expectedPlaceholder,
                "Плейсхолдер поля не совпадает с ожидаемым");
        System.out.println("Задолженность. Поле: E-mail для отправки чека ОР = ФР");

    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
