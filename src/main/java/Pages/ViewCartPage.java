package Pages;
import Util.ReadFromConfig;
import Util.util;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.webauthn.model.AuthenticatorId;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ViewCartPage {

    WebDriver driver;

    HomePage homePage;

    ProductsAndDetailsPage productsAndDetailsPage;

    @FindBy(xpath = "//a[@href='/product_details/1']")
    WebElement firstProductName;

    @FindBy(xpath = "//a[@class='btn btn-default check_out']")
    WebElement proceedToCheckOutBtn;

    @FindBy(xpath = "//u[contains(text(),'Register / Login')]")
    WebElement registerAndLoginBtn;

    @FindBy(xpath = "//b[contains(text(),'Cart is empty!')]")
    WebElement cartEmptyText;

    @FindBy(xpath = "//a[@class='cart_quantity_delete']")
    WebElement deleteQuantity;

    public ViewCartPage(WebDriver driver){
        this.driver = driver;
        this.homePage = new HomePage(driver);
        this.productsAndDetailsPage = new ProductsAndDetailsPage(driver);
        PageFactory.initElements(driver,this);
    }

    public WebElement getCartEmptyText() {
        return cartEmptyText;
    }

    public WebElement getProceedToCheckOutBtn() {
        return proceedToCheckOutBtn;
    }

    public WebElement getRegisterAndLoginBtn() {
        return registerAndLoginBtn;
    }

    public void removeFromCart(){
        util.navigateToUrl(ReadFromConfig.readFromFile("url"));
        homePage.clickProductBtn();
        util.hideElements();
        productsAndDetailsPage.addAProductToCart();
        assertEquals(firstProductName.getText(),"Blue Top");
        util.clickOnElement(deleteQuantity);
        util.WaitForTheElement(driver,getCartEmptyText());
        assertEquals(getCartEmptyText().getText(),"Cart is empty!");
    }
}
