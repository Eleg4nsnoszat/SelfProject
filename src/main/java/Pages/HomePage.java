package Pages;

import Util.ReadFromConfig;
import Util.util;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    WebDriver driver;

    @FindBy(xpath = "//a[contains(text(), 'Login')]")
    WebElement loginAndSignUpBtn;

    @FindBy(xpath = "//a[@href='/products']")
    WebElement productsBtn;

    @FindBy(xpath = "//a[contains(text(), 'Cart')]")
    WebElement cartBtn;

    @FindBy(xpath = "//a[contains(text(), 'Contact us')]")
    WebElement contactUsBtn;

    @FindBy(xpath = "//a[contains(text(),'Delete Account')]")
    WebElement deleteBtn;

    @FindBy(xpath = "//a[contains(text(),'Logout')]")
    WebElement logOutBtn;

    @FindBy(xpath = "//a[contains(text(),'Test Cases')]")
    WebElement testCasesBtn;

    @FindBy(xpath = "//*[@id='footer']/div[1]/div/div/div[2]/div/h2")
    WebElement subscriptionText;

    @FindBy(xpath = "//input[@id='susbscribe_email']")
    WebElement subscriptionEmail;

    @FindBy(xpath = "//button[@id='subscribe']")
    WebElement subscribeBtn;

    @FindBy(xpath = "//*[@id='success-subscribe']/div")
    WebElement accessAlert;



    public HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getAccessAlert() {
        return accessAlert.getText();
    }

    public String getSubscriptionText() {
        return subscriptionText.getText();
    }

    public void clickLogInBtn() {
        util.WaitForTheElement(driver, loginAndSignUpBtn).click();
    }

    public void clickDeleteBtn(){
        util.WaitForTheElement(driver, deleteBtn).click();
    }

    public void clickLogOutBtn(){
        util.WaitForTheElement(driver,logOutBtn).click();
    }

    public void clickContactUsBtn(){
        util.WaitForTheElement(driver,contactUsBtn).click();
    }

    public void clickTestCasesBtn(){
        util.WaitForTheElement(driver,testCasesBtn).click();
    }

    public void clickProductBtn() {
        util.WaitForTheElement(driver, productsBtn).click();
    }

    public void clickCartBtn() {
        util.WaitForTheElement(driver, cartBtn).click();
    }

    public void clickSubscriptionBtn() {
        util.WaitForTheElement(driver, subscribeBtn).click();
    }

    public void writeEmailIntoField(){
        util.WaitForTheElement(driver,subscriptionEmail).sendKeys("testsubemail@gmail.com");
    }


    public void fillOutSubscription(){
        util.scrollDown(driver, subscriptionEmail);
        writeEmailIntoField();
        clickSubscriptionBtn();
    }

}
