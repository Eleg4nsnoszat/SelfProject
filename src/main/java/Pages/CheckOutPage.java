package Pages;

import Util.util;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutPage {

    WebDriver driver;


    @FindBy(xpath = "//a[@href='/payment']")
    WebElement placeOrderBtn;

    @FindBy(xpath = "//li[contains(text(),'userTest street, 12')]")
    WebElement firstAddressText;


    public CheckOutPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public WebElement getFirstAddressText() {
        return firstAddressText;
    }

    public void clickPlaceOrderBtn() {
        placeOrderBtn.click();
    }

    public void scrollToPlaceOrder(){
        util.scrollDown(driver,7000);
        clickPlaceOrderBtn();
    }
}
