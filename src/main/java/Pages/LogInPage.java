package Pages;

import Util.ReadFromConfig;
import Util.util;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogInPage {

    WebDriver driver;

    HomePage homePage;

    @FindBy(xpath = "//input[@data-qa='login-email']")
    WebElement emailAddressField;

    @FindBy(xpath = "//input[@type='password']")
    WebElement passwordField;

    @FindBy(xpath = "//button[@data-qa='login-button']")
    WebElement logInBtn;

    @FindBy(xpath = "//p[contains(text(),'Your email or password is incorrect!')]")
    WebElement failedLogInText;

    public LogInPage(WebDriver driver){
        this.driver = driver;
        this.homePage = new HomePage(driver);
        PageFactory.initElements(driver,this);
    }

    private void setEmail(String loginCorrectEmail){
        util.WaitForTheElement(driver, emailAddressField).sendKeys(loginCorrectEmail);
    }

    private void setPassword(String loginCorrectPassword){
        util.WaitForTheElement(driver, passwordField).sendKeys(loginCorrectPassword);
    }

    private void clickOnLogInButton() {
        util.WaitForTheElement(driver, logInBtn).click();
    }

    public void LogInWithUser(String url, String loginCorrectPassword, String loginCorrectEmail){
        util.navigateToUrl(ReadFromConfig.readFromFile(url));
        homePage.clickLogInBtn();
        this.setEmail(ReadFromConfig.readFromFile(loginCorrectEmail));
        this.setPassword(ReadFromConfig.readFromFile(loginCorrectPassword));
        this.clickOnLogInButton();
    }

    public void LogInWithIncorrectData(String url,String incorrectEmail,String incorrectPassword){
        util.navigateToUrl(ReadFromConfig.readFromFile(url));
        homePage.clickLogInBtn();
        this.setEmail(ReadFromConfig.readFromFile(incorrectEmail));
        this.setPassword(ReadFromConfig.readFromFile(incorrectPassword));
        this.clickOnLogInButton();
    }

    public String getFailedLogInText() {
        return failedLogInText.getText();
    }



}
