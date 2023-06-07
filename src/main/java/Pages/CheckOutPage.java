package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutPage {

    WebDriver driver;


    @FindBy(xpath = "//a[@href='/payment']")
    WebElement placeOrderBtn;


    public CheckOutPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public WebElement getPlaceOrderBtn() {
        return placeOrderBtn;
    }

}
