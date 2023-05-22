package Pages;
import Util.ReadFromConfig;
import Util.util;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static org.junit.jupiter.api.Assertions.assertEquals;

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

    @FindBy(xpath = "//input[@id='search_product']")
    WebElement searchInputField;

    @FindBy(xpath = "/html/body/section[2]/div/div/div[2]/div/div[2]/div/div[1]/div[1]/p")
    WebElement products;

    @FindBy(xpath = "//button[@id='submit_search']")
    WebElement searchBtn;

    public ProductsAndDetailsPage(WebDriver driver){
        this.driver = driver;
        this.homePage = new HomePage(driver);
        PageFactory.initElements(driver,this);
    }


    public String getProducts() {
        return products.getText();
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

    public void sendProductName(String product) {
         searchInputField.sendKeys(product);
    }

    public void waitForProduct(){
        util.WaitForTheElement(driver,products);
    }

    public void clickSearchBtn(){
        util.WaitForTheElement(driver,searchBtn).click();
    }

    //public void validateProducts(){
      //  assertEquals();
    //}

    public void goToProductsPage(){
        util.navigateToUrl(ReadFromConfig.readFromFile("url"));
        homePage.clickProductBtn();
        util.switchToFrames("aswift_5","ad_iframe","dismiss-button");
    }



}
