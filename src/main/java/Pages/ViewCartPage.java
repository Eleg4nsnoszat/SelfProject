package Pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ViewCartPage {

    WebDriver driver;

    HomePage homePage;

    @FindBy(xpath = "//a[contains(text(),'Blue Top')]")
    WebElement firstProductName;

    @FindBy(xpath = "//td[@class='cart_price']")
    WebElement cartPrice;

    @FindBy(xpath = "//td//button[@class='disabled']")
    WebElement productQuantity;

    @FindBy(xpath = "//p[@class='cart_total_price']")
    WebElement totalPrice;

    @FindBy(xpath = "//a[@class='btn btn-default check_out']")
    WebElement proceedToCheckOutBtn;

    @FindBy(xpath = "//u[contains(text(),'Register / Login')]")
    WebElement registerAndLoginBtn;

    public ViewCartPage(WebDriver driver){
        this.driver = driver;
        homePage = new HomePage(driver);
        PageFactory.initElements(driver,this);
    }

    public WebElement getProceedToCheckOutBtn() {
        return proceedToCheckOutBtn;
    }

    public WebElement getRegisterAndLoginBtn() {
        return registerAndLoginBtn;
    }

    public void verifyProductProperties(){
        assertEquals(productQuantity.getText(),"1");
        assertEquals(totalPrice.getText(),"Rs. 500");
        assertEquals(cartPrice.getText(),"Rs. 500");
        assertEquals(firstProductName.getText(),"Blue Top");
    }
}
