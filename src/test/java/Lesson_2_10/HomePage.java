package Lesson_2_10;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

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

    @FindBy(xpath = "//a[text()='Подробнее о сервисе']")
    private WebElement detailsLink;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void acceptCookies() {
        cookieAgreeButton.click();
    }

    public void clickPaymentBlock() {
        paymentBlock.click();
    }

    public boolean isPaymentBlockDisplayed() {
        return paymentBlock.isDisplayed();
    }

    public String getPaymentBlockTitle() {
        return paymentBlock.getText().replace("\n", " ").replace("\r", " ").trim();
    }

    public boolean areAllLogosDisplayed() {
        return visaLogo.isDisplayed() &&
                visaVerifiedLogo.isDisplayed() &&
                masterCardLogo.isDisplayed() &&
                masterCardSecureCodeLogo.isDisplayed() &&
                belcardLogo.isDisplayed();
    }

    public void clickDetailsLink() {
        detailsLink.click();
    }

    public boolean isDetailsLinkDisplayed() {
        return detailsLink.isDisplayed();
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
}
