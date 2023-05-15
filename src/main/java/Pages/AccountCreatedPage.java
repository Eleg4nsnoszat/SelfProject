package Pages;

import Util.util;
import com.beust.ah.A;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountCreatedPage {

    WebDriver driver;

    HomePage homePage;

    @FindBy(xpath = "//b[contains(text(),'Account Created!')]")
    WebElement accountCreatedHeader;

    @FindBy(xpath = "//a[@data-qa='continue-button']")
    WebElement continueBtn;

    public AccountCreatedPage(WebDriver driver){
        this.driver = driver;
        this.homePage = new HomePage(driver);
        PageFactory.initElements(driver, this);
    }

    public void clickContinueBtn(){
        util.WaitForTheElement(driver, continueBtn).click();
    }


    public String getAccountCreatedHeader() {
        return accountCreatedHeader.getText();
    }



}
