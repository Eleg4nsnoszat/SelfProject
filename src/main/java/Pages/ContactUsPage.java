package Pages;

import Util.ReadFromConfig;
import Util.util;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactUsPage {

    WebDriver driver;

    HomePage homePage;

    public ContactUsPage(WebDriver driver){
        this.driver = driver;
        this.homePage = new HomePage(driver);
        PageFactory.initElements(driver,this);
    }


    @FindBy(xpath = "//input[@data-qa='name']")
    WebElement nameField;

    @FindBy(xpath = "//input[@data-qa='email']")
    WebElement emailField;

    @FindBy(xpath = "//input[@data-qa='subject']")
    WebElement subjectField;

    @FindBy(xpath = "//textarea[@id='message']")
    WebElement messageField;

    @FindBy(xpath = "//input[@data-qa='submit-button']")
    WebElement submitBtn;

    @FindBy(xpath = "//span[contains(text(),'Home')]")
    WebElement greenHomeBtn;

    @FindBy(xpath = "//input[@type='file']")
    WebElement choseFileBtn;

    private void setEmailField(String loginCorrectEmail){
        util.WaitForTheElement(driver,emailField).sendKeys(loginCorrectEmail);
    }

    private void setSubjectField(){
        util.WaitForTheElement(driver,subjectField).sendKeys("Subject");
    }

    private void setMessageField(){
        util.WaitForTheElement(driver,messageField).sendKeys("message");
    }

    private void setNameField(String firstName){
        util.WaitForTheElement(driver,nameField).sendKeys(firstName);
    }

    private void clickSubmitBtn(){
        util.WaitForTheElement(driver,submitBtn).click();
    }

    private void clickHomeBtn(){
        util.WaitForTheElement(driver,greenHomeBtn).click();
    }

    public void fillOutContactUs(String url,String loginCorrectEmail,String firstName){
        util.navigateToUrl(ReadFromConfig.readFromFile(url));
        homePage.clickContactUsBtn();
        this.setNameField(ReadFromConfig.readFromFile(firstName));
        this.setEmailField(ReadFromConfig.readFromFile(loginCorrectEmail));
        setSubjectField();
        setMessageField();
        choseFileBtn.sendKeys("C:\\Users\\user\\Desktop\\hello_word.txt");
        clickSubmitBtn();
        util.acceptAlert();
        clickHomeBtn();
    }
}
