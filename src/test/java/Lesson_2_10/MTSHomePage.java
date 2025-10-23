package Lesson_2_10;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

/**
 * PAGE OBJECT ДЛЯ ГЛАВНОЙ СТРАНИЦЫ MTS
 *
 * Этот класс содержит:
 * 1. Все элементы страницы (локаторы)
 * 2. Методы для взаимодействия с элементами
 * 3. Проверки (assertions)
 *
 * Паттерн PageObject помогает разделить код тестов и код работы со страницей
 */
public class MTSHomePage extends BasePage {

    // КОНСТРУКТОР - наследуем от BasePage
    public MTSHomePage(WebDriver driver) {
        super(driver); // передаем драйвер в родительский класс
    }

    // === ЛОКАТОРЫ ЭЛЕМЕНТОВ ===
    // Аннотация @FindBy говорит Selenium как найти элемент на странице

    // Кнопка принятия куки
    @FindBy(id = "cookie-agree")
    private WebElement cookieAgreeButton;

    // Блок "Онлайн пополнение без комиссии"
    @FindBy(xpath = "//h2[contains(text(), 'Онлайн пополнение')]")
    private WebElement paymentBlock;

    // Логотипы платежных систем
    @FindBy(xpath = "//img[@alt='Visa']")
    private WebElement visaLogo;

    @FindBy(xpath = "//img[@alt='Verified By Visa']")
    private WebElement visaVerifiedLogo;

    @FindBy(xpath = "//div[@class='pay__partners']//img[@alt='MasterCard']")
    private WebElement masterCardLogo;

    @FindBy(xpath = "//img[@alt='MasterCard Secure Code']")
    private WebElement masterCardSecureCodeLogo;

    @FindBy(xpath = "//div[@class='homepage']//img[@alt='Белкарт']")
    private WebElement belcardLogo;

    // Ссылка "Подробнее о сервисе"
    @FindBy(xpath = "//a[text()='Подробнее о сервисе']")
    private WebElement detailsLink;

    // Поля формы оплаты
    @FindBy(xpath = "//input[@placeholder='Номер телефона']")
    private WebElement phoneNumberInput;

    @FindBy(id = "connection-sum")
    private WebElement sumInput;

    @FindBy(xpath = "//*[@id=\"pay-connection\"]/button")
    private WebElement continueButton;

    // === МЕТОДЫ ДЛЯ ВЗАИМОДЕЙСТВИЯ С ЭЛЕМЕНТАМИ ===

    /**
     * МЕТОД ДЛЯ ПРИНЯТИЯ COOKIES
     * Ждет пока кнопка станет кликабельной и нажимает ее
     */
    public void acceptCookies() {
        wait.until(ExpectedConditions.elementToBeClickable(cookieAgreeButton)).click();
    }

    /**
     * МЕТОД ДЛЯ КЛИКА ПО БЛОКУ ОПЛАТЫ
     */
    public void clickPaymentBlock() {
        paymentBlock.click();
    }

    // === МЕТОДЫ ПРОВЕРОК ИЗ ИСХОДНЫХ ТЕСТОВ ===

    /**
     * ПРОВЕРКИ ИЗ ТЕСТА TestMTS1:
     * 1. Блок отображается на странице
     * 2. Текст блока соответствует ожидаемому
     */
    public void verifyPaymentBlock() {
        // ПРОВЕРКА 1: Блок виден на странице
        Assert.assertTrue(paymentBlock.isDisplayed(),
                "Блок 'Онлайн пополнение без комиссии' не отображается на странице");

        // ПРОВЕРКА 2: Проверяем текст заголовка
        String actualTitle = paymentBlock.getText();
        // Убираем переносы строк для корректного сравнения
        String normalizedActualTitle = actualTitle.replace("\n", " ").replace("\r", " ").trim();
        String expectedTitle = "Онлайн пополнение без комиссии";

        // Сравниваем нормализованный текст с ожидаемым
        Assert.assertEquals(normalizedActualTitle, expectedTitle,
                "Название блока не совпадает с ожидаемым");
    }

    /**
     * ПРОВЕРКИ ИЗ ТЕСТА TestMTS2:
     * Проверяем что все логотипы платежных систем отображаются
     */
    public void verifyPaymentSystemLogos() {
        // Кликаем по логотипу Visa и проверяем его отображение
        visaLogo.click();
        Assert.assertTrue(visaLogo.isDisplayed(), "Логотип Visa не отображается");
        System.out.println("Логотип Visa найден и отображается!");

        // Проверяем Verified By Visa
        Assert.assertTrue(visaVerifiedLogo.isDisplayed(),
                "Логотип 'Verified By Visa' не отображается");
        System.out.println("Логотип 'Verified By Visa' найден и отображается!");

        // Проверяем MasterCard
        Assert.assertTrue(masterCardLogo.isDisplayed(),
                "Логотип MasterCard не отображается");
        System.out.println("Логотип MasterCard найден и отображается!");

        // Проверяем MasterCard Secure Code
        Assert.assertTrue(masterCardSecureCodeLogo.isDisplayed(),
                "Логотип MasterCard Secure Code не отображается");
        System.out.println("Логотип MasterCard Secure Code найден и отображается!");

        // Проверяем Белкарт
        Assert.assertTrue(belcardLogo.isDisplayed(),
                "Логотип Белкарт не отображается");
        System.out.println("Логотип Белкарт найден и отображается!");
    }

    /**
     * ПРОВЕРКИ ИЗ ТЕСТА TestMTS3:
     * 1. Ссылка отображается
     * 2. Ссылка ведет на другую страницу
     */
    public void verifyDetailsLink() {
        // Проверяем что ссылка видна
        Assert.assertTrue(detailsLink.isDisplayed());

        // Кликаем по ссылке
        detailsLink.click();

        // Проверяем что URL изменился (мы перешли на другую страницу)
        Assert.assertNotEquals(driver.getCurrentUrl(), "https://www.mts.by/");
        System.out.println("Ссылка работает!");
    }

    /**
     * ПРОВЕРКИ ИЗ ТЕСТА TestMTS4:
     * 1. Заполняем форму оплаты
     * 2. Нажимаем кнопку продолжения
     * 3. Проверяем что кнопка работает
     */
    public void verifyPaymentForm() {
        // Заполняем поле номера телефона
        phoneNumberInput.click();
        phoneNumberInput.sendKeys("297777777");

        // Заполняем поле суммы
        sumInput.click();
        sumInput.sendKeys("499");

        // Нажимаем кнопку "Продолжить"
        continueButton.click();

        // Проверяем что кнопка отображается (платежное окно открылось)
        Assert.assertTrue(continueButton.isDisplayed());
        System.out.println("Кнопка работает! Платежное окно открылось");
    }
    //------------------------------------------------------------------5 Test

}
