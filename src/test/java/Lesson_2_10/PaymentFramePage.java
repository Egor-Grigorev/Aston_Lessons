package Lesson_2_10;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PaymentFramePage extends BasePage {

    @FindBy(xpath = "//iframe[@class='bepaid-iframe' and contains(@src, 'bepaid.by')]")
    private WebElement paymentFrame;

    @FindBy(xpath = "//span[@class='ng-star-inserted' and text()='499.00 BYN']")
    private WebElement amountHeader;

    @FindBy(xpath = "//span[contains(text(), '375297777777')]")
    private WebElement phoneNumberHeader;

    @FindBy(xpath = "//label[contains(@class, 'ng-star-inserted') and text()='Номер карты']")
    private WebElement cardNumberLabel;

    @FindBy(xpath = "//label[contains(text(), 'Срок действия')]")
    private WebElement expiryDateLabel;

    @FindBy(xpath = "//label[text()='CVC']")
    private WebElement cvcLabel;

    @FindBy(xpath = "//label[text()='Имя и фамилия на карте']")
    private WebElement cardNameLabel;

    @FindBy(xpath = "//img[contains(@src, 'visa-system.svg')]")
    private WebElement visaLogo;

    @FindBy(xpath = "//img[contains(@src, 'mastercard-system.svg')]")
    private WebElement masterCardLogo;

    @FindBy(xpath = "//img[contains(@src, 'belkart-system.svg')]")
    private WebElement belkartLogo;

    public PaymentFramePage(WebDriver driver) {
        super(driver);
    }

    public void switchToPaymentFrame() {
        wait.until(ExpectedConditions.visibilityOf(paymentFrame));
        driver.switchTo().frame(paymentFrame);
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                org.openqa.selenium.By.xpath("//span[contains(@class, 'ng-star-inserted')]")));
    }

    public void switchToDefaultContent() {
        driver.switchTo().defaultContent();
    }

    public String getAmountText() {
        return amountHeader.getText().trim();
    }

    public String getPhoneNumberText() {
        return phoneNumberHeader.getText();
    }

    public String getCardNumberLabelText() {
        return cardNumberLabel.getText();
    }

    public String getExpiryDateLabelText() {
        return expiryDateLabel.getText();
    }

    public String getCvcLabelText() {
        return cvcLabel.getText();
    }

    public String getCardNameLabelText() {
        return cardNameLabel.getText();
    }

    public boolean arePaymentLogosDisplayed() {
        return visaLogo.isDisplayed() &&
                masterCardLogo.isDisplayed() &&
                belkartLogo.isDisplayed();
    }
}
