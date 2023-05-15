package Pages;

import Util.ReadFromConfig;
import Util.util;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpPage {

    WebDriver driver;

    HomePage homePage;

    @FindBy(xpath = "//input[@type='text']")
    WebElement nameInputField;

    @FindBy(xpath = "//input[@data-qa='signup-email']")
    WebElement signUpEmailInput;

    @FindBy(xpath = "//button[@data-qa='signup-button']")
    WebElement signUpBtn;

    public SignUpPage(WebDriver driver){
        this.driver = driver;
        this.homePage = new HomePage(driver);
        PageFactory.initElements(driver,this);
    }

    private void setUsername(String username){
        util.WaitForTheElement(driver,nameInputField).sendKeys(username);
    }

    private void setEmail(String username){
        util.WaitForTheElement(driver,signUpEmailInput).sendKeys(username);
    }

    private void clickOnSignUpButton() {
        util.WaitForTheElement(driver, signUpBtn).click();
    }

    public void SignUpWithUser(String url, String username, String email){
        util.navigateToUrl(ReadFromConfig.readFromFile(url));
        homePage.clickLogInBtn();
        this.setUsername(ReadFromConfig.readFromFile(username));
        this.setEmail(ReadFromConfig.readFromFile(email));
        this.clickOnSignUpButton();
    }

}
