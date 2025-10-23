package Lesson_2_10;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.time.Duration;

public class TestMTS6 {
    private WebDriver driver;
    private HomePage homePage;
    private PaymentPage paymentPage;
    private PaymentFramePage paymentFramePage;
    private String mainWindow;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        driver.get("https://www.mts.by/");

        // Запоминаем идентификатор текущего окна
        mainWindow = driver.getWindowHandle();
        System.out.println("Основное окно: " + mainWindow);

        homePage = new HomePage(driver);
        paymentPage = new PaymentPage(driver);
        paymentFramePage = new PaymentFramePage(driver);
        homePage.acceptCookies();

        // Переходим к блоку оплаты и заполняем форму
        homePage.clickPaymentBlock();
        paymentPage.fillConnectionForm("297777777", "499");
        paymentPage.clickContinue();
    }

    @Test
    public void testPaymentFrameContent() {
        // Переключаемся на фрейм платежного окна
        paymentFramePage.switchToPaymentFrame();

        // Проверка отображения суммы в шапке платежного окна
        String actualAmount = paymentFramePage.getAmountText();
        String expectedAmount = "499.00 BYN";
        Assert.assertEquals(actualAmount, expectedAmount,
                "Отображаемая сумма в шапке не совпадает с ожидаемой");
        System.out.println("Отображение суммы в шапке платежного окна ОР = ФР");

        // Проверка на соответствие номера телефона в шапке модального окна
        String actualPhoneText = paymentFramePage.getPhoneNumberText();
        String expectedPhoneText = "Оплата: Услуги связи Номер:375297777777";
        Assert.assertEquals(actualPhoneText, expectedPhoneText,
                "Отображаемый номер телефона не совпадает с ожидаемым");
        System.out.println("Отображение номера в шапке платежного окна ОР = ФР");

        // Проверка полей формы
        Assert.assertEquals(paymentFramePage.getCardNumberLabelText(), "Номер карты",
                "Надпись поля 'Номер карты' не совпадает");
        System.out.println("Отображение надписи в поле 'Номер карты' ОР = ФР");

        Assert.assertEquals(paymentFramePage.getExpiryDateLabelText(), "Срок действия",
                "Надпись поля 'Срок действия' не совпадает");
        System.out.println("Отображение надписи в поле 'Срок действия' ОР = ФР");

        Assert.assertEquals(paymentFramePage.getCvcLabelText(), "CVC",
                "Надпись поля 'CVC' не совпадает");
        System.out.println("Отображение надписи в поле 'CVC' ОР = ФР");

        Assert.assertEquals(paymentFramePage.getCardNameLabelText(), "Имя и фамилия на карте",
                "Надпись поля 'Имя и фамилия на карте' не совпадает");
        System.out.println("Отображение надписи в поле 'Имя и фамилия на карте' ОР = ФР");

        // Проверка логотипов платежных систем
        Assert.assertTrue(paymentFramePage.arePaymentLogosDisplayed(),
                "Не все логотипы платежных систем отображаются");
        System.out.println("Все логотипы платежных систем найдены и отображаются");

        // Возвращаемся к основно...
        paymentFramePage.switchToDefaultContent();
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
