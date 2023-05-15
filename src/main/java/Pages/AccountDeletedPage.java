package Pages;

import Util.util;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountDeletedPage {
    WebDriver driver;

    HomePage homePage;

    @FindBy(xpath = "//a[@data-qa='continue-button']")
    WebElement continueBtn;

    public AccountDeletedPage(WebDriver driver){
        this.driver = driver;
        this.homePage = new HomePage(driver);
        PageFactory.initElements(driver, this);
    }

    public void clickContinueBtn(){
        util.WaitForTheElement(driver, continueBtn).click();
    }
}
