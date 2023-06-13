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

    @FindBy(xpath = "//td[@class='cart_price']")
    WebElement cartPrice;

    @FindBy(xpath = "//td//button[@class='disabled']")
    WebElement productQuantity;

    @FindBy(xpath = "//p[@class='cart_total_price']")
    WebElement totalPrice;

    @FindBy(xpath = "//a[contains(text(),'View Product')]")
    WebElement viewProductBtn;

    @FindBy(xpath = "//p[contains(text(),'Blue Top')]")
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

    @FindBy(xpath = "//a[@data-product-id='1']")
    WebElement firstProductAddCartBtn;

    @FindBy(xpath = "//a[@href='/product_details/1']")
    WebElement firstProductName;

    @FindBy(xpath = "//a[@data-product-id='2']")
    WebElement secondProductAddCartBtn;

    @FindBy(xpath = "//button[@class='btn btn-success close-modal btn-block']")
    WebElement continueShoppingBtn;

    @FindBy(xpath = "//*[@id='cartModal']/div/div/div[2]/p[2]/a/u")
    WebElement viewCartBtn;

    @FindBy(xpath = "//h2[contains(text(),'Brands')]")
    WebElement brandsText;

    @FindBy(xpath = "//a[@href='/brand_products/Polo']")
    WebElement poloProductBtn;

    @FindBy(xpath = "//a[@href='/brand_products/H&M']")
    WebElement HMProductBtn;

    @FindBy(xpath = "//p[contains(text(),'Men Tshirt')]")
    WebElement menTshirtText;

    public ProductsAndDetailsPage(WebDriver driver){
        this.driver = driver;
        this.homePage = new HomePage(driver);
        PageFactory.initElements(driver,this);
    }


    public String getProducts() {
        return products.getText();
    }


    public void clickAddCartBtn(WebElement element){
        util.WaitForTheElement(driver, element).click();

    }

    public WebElement getBrandsText() {
        return brandsText;
    }

    public WebElement getMenTshirtText() {
        return menTshirtText;
    }

    public void clickViewCartBtn(){
        util.WaitForTheElement(driver,viewCartBtn).click();
    }

    public void clickContinueShoppingBtn(){
        util.WaitForTheElement(driver,continueShoppingBtn).click();
    }

    public WebElement getProductName() {
        return productName;
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


    public void goToProductsPage(){
        util.navigateToUrl(ReadFromConfig.readFromFile("url"));
        homePage.clickProductBtn();
    }

    public void verifyProductProperties(){
        assertEquals(productQuantity.getText(),"1");
        assertEquals(totalPrice.getText(),"Rs. 500");
        assertEquals(cartPrice.getText(),"Rs. 500");
        assertEquals(firstProductName.getText(),"Blue Top");
    }

    public void addProductsToCart(){
        util.navigateToUrl(ReadFromConfig.readFromFile("url"));
        homePage.clickProductBtn();
        util.hideElements();
        clickAddCartBtn(firstProductAddCartBtn);
        clickContinueShoppingBtn();
        clickAddCartBtn(secondProductAddCartBtn);
        clickViewCartBtn();
        verifyProductProperties();
    }

    public void addAProductToCart(){
        util.hideElements();
        clickAddCartBtn(firstProductAddCartBtn);
        clickViewCartBtn();
    }

    public void viewBrandsAndProducts(){
        util.navigateToUrl(ReadFromConfig.readFromFile("url"));
        homePage.clickProductBtn();
        util.hideElements();
        assertEquals(getBrandsText().getText(),"BRANDS");
        util.clickOnElement(poloProductBtn);
        util.hideElements();
        assertEquals(getProductName().getText(),"Blue Top");
        util.clickOnElement(HMProductBtn);
        util.hideElements();
        assertEquals(getMenTshirtText().getText(),"Men Tshirt");
    }


}
