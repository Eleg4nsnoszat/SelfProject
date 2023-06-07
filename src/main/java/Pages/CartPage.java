package Pages;

import Util.util;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {

    WebDriver driver;

    HomePage homePage;


    @FindBy(xpath = "//*[@id='footer']/div[1]/div/div/div[2]/div/h2")
    WebElement subscriptionText;

    @FindBy(xpath = "//input[@id='susbscribe_email']")
    WebElement subscriptionEmail;

    @FindBy(xpath = "//button[@id='subscribe']")
    WebElement subscribeBtn;

    @FindBy(xpath = "//*[@id='success-subscribe']/div")
    WebElement accessAlert;

    public CartPage(WebDriver driver){
        this.driver = driver;
        this.homePage = new HomePage(driver);
        PageFactory.initElements(driver,this);
    }


    public String getAccessAlertCartPage() {
        return accessAlert.getText();
    }

    public String getSubscriptionTextCartPage() {
        return subscriptionText.getText();
    }

    public void writeEmailIntoField(){
        util.WaitForTheElement(driver,subscriptionEmail).sendKeys("testsubemail@gmail.com");
    }


    public void fillOutSubscriptionCartPage(){
        util.scrollDown(driver, subscriptionEmail);
        writeEmailIntoField();
        util.clickOnElement(subscribeBtn);
    }



}
