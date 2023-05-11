package Pages;

import Util.util;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    WebDriver driver;

    @FindBy(xpath = "//a[contains(text(), 'Login')]")
    WebElement loginAndSignUpBtn;

    @FindBy(xpath = "//i[contains(@class, 'material-icons card_travel')]")
    WebElement productsBtn;

    @FindBy(xpath = "//a[contains(text(), 'Cart')]")
    WebElement cartBtn;

    @FindBy(xpath = "//i[contains(@class, 'fa fa-envelope')]")
    WebElement contactUsBtn;



    public HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickLogInBtn() {
        util.WaitForTheElement(driver, loginAndSignUpBtn).click();
    }

}
