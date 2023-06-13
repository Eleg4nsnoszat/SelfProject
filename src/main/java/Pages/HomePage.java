package Pages;
import Util.ReadFromConfig;
import Util.util;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HomePage {

    WebDriver driver;

    @FindBy(xpath = "//a[contains(text(), 'Login')]")
    WebElement loginAndSignUpBtn;

    @FindBy(xpath = "//a[@href='/products']")
    WebElement productsBtn;

    @FindBy(xpath = "//a[contains(text(), 'Cart')]")
    WebElement cartBtn;

    @FindBy(xpath = "//a[contains(text(), 'Contact us')]")
    WebElement contactUsBtn;

    @FindBy(xpath = "//a[contains(text(),'Delete Account')]")
    WebElement deleteBtn;

    @FindBy(xpath = "//a[contains(text(),'Logout')]")
    WebElement logOutBtn;

    @FindBy(xpath = "//a[contains(text(),'Test Cases')]")
    WebElement testCasesBtn;

    @FindBy(xpath = "//h2[contains(text(),'Subscription')]")
    WebElement subscriptionText;

    @FindBy(xpath = "//input[@id='susbscribe_email']")
    WebElement subscriptionEmail;

    @FindBy(xpath = "//button[@id='subscribe']")
    WebElement subscribeBtn;

    @FindBy(xpath = "//*[@id='success-subscribe']/div")
    WebElement accessAlert;

    @FindBy(xpath = "//h2[contains(text(),'Category')]")
    WebElement categoryText;

    @FindBy(xpath = "//a[@href='#Women']")
    WebElement womenSideBarBtn;

    @FindBy(xpath = "//a[@href='/category_products/1']")
    WebElement womenSidebarFirstCategoryBtn;

    @FindBy(xpath = "//h2[contains(text(),'Women - Dress Products')]")
    WebElement dressProductsText;

    @FindBy(xpath = "//a[@href='#Men']")
    WebElement MenSideBarBtn;

    @FindBy(xpath = "//a[@href='/category_products/3']")
    WebElement MenSidebarThirdCategoryBtn;

    @FindBy(xpath = "//h2[contains(text(),'Men - Tshirts Products')]")
    WebElement TshirtsProductsText;


    public HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickWomenSidebarFirstCategoryBtn(){
        util.WaitForTheElement(driver,womenSidebarFirstCategoryBtn).click();
    }

    public void clickMenSideBarBtn(){
        util.WaitForTheElement(driver,MenSideBarBtn).click();
    }

    public void clickMenSidebarThirdCategoryBtn(){
        util.WaitForTheElement(driver,MenSidebarThirdCategoryBtn).click();
    }

    public WebElement getDressProductsText() {
        return dressProductsText;
    }

    public WebElement getTshirtsProductsText() {
        return TshirtsProductsText;
    }
    public WebElement getCategoryText() {
        return categoryText;
    }

    public String getAccessAlert() {
        return accessAlert.getText();
    }

    public String getSubscriptionText() {
       return subscriptionText.getText();
    }

    public void clickLogInBtn() {
        util.WaitForTheElement(driver, loginAndSignUpBtn).click();
    }

    public void clickDeleteBtn(){
        util.WaitForTheElement(driver, deleteBtn).click();
    }

    public void clickLogOutBtn(){
        util.WaitForTheElement(driver,logOutBtn).click();
    }

    public void clickWomenSideBarBtn(){
        util.WaitForTheElement(driver,womenSideBarBtn).click();
    }

    public void clickContactUsBtn(){
        util.WaitForTheElement(driver,contactUsBtn).click();
    }

    public void clickTestCasesBtn(){
        util.WaitForTheElement(driver,testCasesBtn).click();
    }

    public void clickProductBtn() {
        util.WaitForTheElement(driver, productsBtn).click();
    }

    public void clickCartBtn() {
        util.WaitForTheElement(driver, cartBtn).click();
    }


    public void writeEmailIntoField(){
        util.WaitForTheElement(driver,subscriptionEmail).sendKeys("testsubemail@gmail.com");
    }


    public void fillOutSubscription(){
        util.scrollDown(driver, subscriptionEmail);
        writeEmailIntoField();
        util.clickOnElement(subscribeBtn);
    }

    public void viewProductCategory(){
        util.navigateToUrl(ReadFromConfig.readFromFile("url"));
        assertEquals(getCategoryText().getText(),"CATEGORY");
        clickWomenSideBarBtn();
        clickWomenSidebarFirstCategoryBtn();
        util.hideElements();
        clickWomenSidebarFirstCategoryBtn();
        assertEquals(getDressProductsText().getText(),"WOMEN - DRESS PRODUCTS");
        clickMenSideBarBtn();
        clickMenSidebarThirdCategoryBtn();
        assertEquals(getTshirtsProductsText().getText(),"MEN - TSHIRTS PRODUCTS");
    }




}
