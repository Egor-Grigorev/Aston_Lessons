package Lesson_2_10;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    // --- Элементы ---
    @FindBy(id = "cookie-agree")
    private WebElement cookieAgreeButton;

    @FindBy(xpath = "//h2[contains(text(), 'Онлайн пополнение')]")
    private WebElement paymentBlock;

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

    @FindBy(xpath = "//a[normalize-space()='Подробнее о сервисе']")
    private WebElement detailsLink;

    // --- Конструктор ---
    public HomePage(WebDriver driver) {
        super(driver);
    }

    // --- Действия/проверки с шагами Allure ---

    @Step("Принять cookies (если баннер есть)")
    public void acceptCookies() {
        // безопасный клик: если баннер отсутствует — тест не упадёт
        safeClick(cookieAgreeButton);
    }

    @Step("Прокрутить к блоку оплаты")
    public void scrollToPaymentBlock() {
        scrollTo(paymentBlock);
    }

    @Step("Кликнуть по блоку 'Онлайн пополнение без комиссии'")
    public void clickPaymentBlock() {
        click(paymentBlock);
    }

    @Step("Проверить, что блок оплаты отображается")
    public boolean isPaymentBlockDisplayed() {
        return isDisplayed(paymentBlock);
    }

    @Step("Получить заголовок блока оплаты")
    public String getPaymentBlockTitle() {
        return getElementText(paymentBlock);
    }

    // --- Логотипы платёжных систем ---

    @Step("Проверить, что логотип Visa отображается")
    public boolean isVisaDisplayed() { return isDisplayed(visaLogo); }

    @Step("Проверить, что логотип Verified by Visa отображается")
    public boolean isVisaVerifiedDisplayed() { return isDisplayed(visaVerifiedLogo); }

    @Step("Проверить, что логотип MasterCard отображается")
    public boolean isMasterCardDisplayed() { return isDisplayed(masterCardLogo); }

    @Step("Проверить, что логотип MasterCard SecureCode отображается")
    public boolean isMasterCardSecureCodeDisplayed() { return isDisplayed(masterCardSecureCodeLogo); }

    @Step("Проверить, что логотип Белкарт отображается")
    public boolean isBelcardDisplayed() { return isDisplayed(belcardLogo); }

    @Step("Проверить, что все логотипы платёжных систем отображаются")
    public boolean areAllLogosDisplayed() {
        return isVisaDisplayed()
                && isVisaVerifiedDisplayed()
                && isMasterCardDisplayed()
                && isMasterCardSecureCodeDisplayed()
                && isBelcardDisplayed();
    }

    // --- Ссылка "Подробнее о сервисе" ---

    @Step("Кликнуть ссылку 'Подробнее о сервисе'")
    public void clickDetailsLink() {
        click(detailsLink);
    }

    @Step("Проверить, что ссылка 'Подробнее о сервисе' отображается")
    public boolean isDetailsLinkDisplayed() {
        return isDisplayed(detailsLink);
    }

    @Step("Получить текущий URL")
    public String getCurrentUrl() {
        return super.getCurrentUrl();
    }
}