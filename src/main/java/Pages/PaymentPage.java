package Pages;
import Util.util;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentPage {

    WebDriver driver;


    @FindBy(xpath = "//input[@data-qa='name-on-card']")
    WebElement nameOnCardField;

    @FindBy(xpath = "//input[@data-qa='card-number']")
    WebElement cardNumberField;

    @FindBy(xpath = "//input[@data-qa='cvc']")
    WebElement CVCField;

    @FindBy(xpath = "//input[@data-qa='expiry-month']")
    WebElement expirationMonthField;

    @FindBy(xpath = "//input[@data-qa='expiry-year']")
    WebElement expirationYearField;

    @FindBy(xpath = "//button[@data-qa='pay-button']")
    WebElement payBtnField;


    public PaymentPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public void sendNameOnCard(String nameOnCard){
        util.WaitForTheElement(driver,nameOnCardField).sendKeys(nameOnCard);
    }

    public void sendCardNumber(String cardNumber){
        util.WaitForTheElement(driver, cardNumberField).sendKeys(cardNumber);
    }

    public void sendCVC(String CVC){
        util.WaitForTheElement(driver, CVCField).sendKeys(CVC);
    }

    public void sendExpMonth(String expMonth){
        util.WaitForTheElement(driver, expirationMonthField).sendKeys(expMonth);
    }

    public void sendExpYear(String expYear){
        util.WaitForTheElement(driver, expirationYearField).sendKeys(expYear);
    }

    public void clickPayBtn(){
        util.WaitForTheElement(driver,payBtnField).click();
    }

    public void payAndConfirm(String nameOnCard, String cardNumber, String expirationMonth,
                                String expirationYear, String CVC){
        sendNameOnCard(nameOnCard);
        sendCardNumber(cardNumber);
        sendCVC(CVC);
        sendExpMonth(expirationMonth);
        sendExpYear(expirationYear);
        clickPayBtn();
        util.hideElements();
    }





}
