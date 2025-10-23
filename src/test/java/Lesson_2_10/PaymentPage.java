package Lesson_2_10;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PaymentPage extends BasePage {

    // Поля для услуг связи
    @FindBy(xpath = "//input[@placeholder='Номер телефона']")
    private WebElement phoneNumberField;

    @FindBy(id = "connection-sum")
    private WebElement sumField;

    @FindBy(id = "connection-email")
    private WebElement emailField;

    @FindBy(xpath = "//*[@id=\"pay-connection\"]/button")
    private WebElement continueButton;

    // Селектор для выбора типа услуги
    @FindBy(xpath = "//span[@class='select__arrow']")
    private WebElement serviceTypeSelector;

    // Опции селектора
    @FindBy(xpath = "//li[.//p[text()='Домашний интернет']]")
    private WebElement homeInternetOption;

    @FindBy(xpath = "//p[text()='Рассрочка']")
    private WebElement installmentOption;

    @FindBy(xpath = "//p[@class='select__option' and contains(text(), 'Задолженность')]")
    private WebElement debtOption;

    // Поля для домашнего интернета
    @FindBy(xpath = "//input[@placeholder='Номер абонента']")
    private WebElement subscriberNumberField;

    @FindBy(id = "internet-sum")
    private WebElement internetSumField;

    @FindBy(id = "internet-email")
    private WebElement internetEmailField;

    // Поля для рассрочки
    @FindBy(xpath = "//input[@placeholder='Номер счета на 44']")
    private WebElement installmentAccountField;

    @FindBy(id = "instalment-sum")
    private WebElement installmentSumField;

    @FindBy(id = "instalment-email")
    private WebElement installmentEmailField;

    // Поля для задолженности
    @FindBy(id = "score-arrears")
    private WebElement debtAccountField;

    @FindBy(id = "arrears-sum")
    private WebElement debtSumField;

    @FindBy(id = "arrears-email")
    private WebElement debtEmailField;

    public PaymentPage(WebDriver driver) {
        super(driver);
    }

    public void fillConnectionForm(String phone, String sum) {
        phoneNumberField.clear();
        phoneNumberField.sendKeys(phone);
        sumField.clear();
        sumField.sendKeys(sum);
    }

    public void clickContinue() {
        continueButton.click();
    }

    public boolean isContinueButtonDisplayed() {
        return continueButton.isDisplayed();
    }

    public void selectServiceType(String serviceType) {
        serviceTypeSelector.click();
        switch (serviceType.toLowerCase()) {
            case "домашний интернет":
                homeInternetOption.click();
                break;
            case "рассрочка":
                installmentOption.click();
                break;
            case "задолженность":
                debtOption.click();
                break;
            default:
                throw new IllegalArgumentException("Unknown service type: " + serviceType);
        }
    }

    public String getPhoneFieldPlaceholder() {
        return phoneNumberField.getAttribute("placeholder");
    }

    public String getSumFieldPlaceholder() {
        return sumField.getAttribute("placeholder");
    }

    public String getEmailFieldPlaceholder() {
        return emailField.getAttribute("placeholder");
    }

    public String getSubscriberNumberPlaceholder() {
        return subscriberNumberField.getAttribute("placeholder");
    }

    public String getInstallmentAccountPlaceholder() {
        return installmentAccountField.getAttribute("placeholder");
    }

    public String getDebtAccountPlaceholder() {
        return debtAccountField.getAttribute("placeholder");
    }
}
