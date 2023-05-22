package Pages;
import Util.util;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsAndDetailsPage {

    WebDriver driver;

    HomePage homePage;

    @FindBy(xpath = "//h2[@class='title text-center']")
    WebElement allProductsText;

    @FindBy(xpath = "//a[@href='/product_details/1']")
    WebElement viewProductBtn;

    @FindBy(xpath = "//h2[contains(text(),'Blue Top')]")
    WebElement productName;

    @FindBy(xpath = "//p[contains(text(),'Category: Women > Tops')]")
    WebElement productCategory;

    @FindBy(xpath = "//span[contains(text(),'Rs. 500')]")
    WebElement productPrice;

    @FindBy(xpath = "//b[contains(text(),'Availability:')]")
    WebElement productAvailability;

    @FindBy(xpath = "//b[contains(text(),'Condition:')]")
    WebElement productCondition;

    @FindBy(xpath = "//b[contains(text(),'Brand:')]")
    WebElement productBrand;


    public ProductsAndDetailsPage(WebDriver driver){
        this.driver = driver;
        this.homePage = new HomePage(driver);
        PageFactory.initElements(driver,this);
    }


    public String getAllProductsText() {
        return allProductsText.getText();
    }

    public String getProductName() {
        return productName.getText();
    }

    public String getProductCategory() {
        return productCategory.getText();
    }

    public String getProductPrice() {
         return productPrice.getText();
    }

    public String getProductAvailability() {
         return productAvailability.getText();
    }

    public String getProductCondition() {
        return productCondition.getText();
    }

    public String getProductBrand() {
         return productBrand.getText();
    }

    public void clickViewProductBtn(){
        util.WaitForTheElement(driver,viewProductBtn).click();
    }

}
