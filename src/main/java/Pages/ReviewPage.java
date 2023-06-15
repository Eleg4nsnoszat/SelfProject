package Pages;

import Util.util;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ReviewPage {

    WebDriver driver;

    HomePage homePage;

    ProductsAndDetailsPage productsAndDetailsPage;

    @FindBy(xpath = "//input[@id='name']")
    WebElement reviewNameField;

    @FindBy(xpath = "//input[@id='email']")
    WebElement reviewEmail;

    @FindBy(xpath = "//textarea[@id='review']")
    WebElement reviewTextarea;

    @FindBy(xpath = "//button[@id='button-review']")
    WebElement reviewBtn;

    @FindBy(xpath = "//div[@class='alert-success alert']")
    WebElement successAlert;

    public ReviewPage(WebDriver driver){
        this.driver = driver;
        this.homePage = new HomePage(driver);
        this.productsAndDetailsPage = new ProductsAndDetailsPage(driver);
        PageFactory.initElements(driver,this);
    }


    public void sendName(){
        util.WaitForTheElement(driver,reviewNameField).sendKeys("Name");
    }
    public void sendEmail(){
        util.WaitForTheElement(driver,reviewEmail).sendKeys("dontdelete@gmail.com");
    }
    public void sendReview(){
        util.WaitForTheElement(driver,reviewTextarea).sendKeys("TestReview");
    }

    public void clickReviewBtn(){
        util.WaitForTheElement(driver,reviewBtn).click();
    }

    public void addReview(){
        productsAndDetailsPage.goToProductsPage();
        productsAndDetailsPage.clickViewProductBtn();
        sendName();
        sendEmail();
        sendReview();
        util.scrollDown(driver,7000);
        clickReviewBtn();
        assertTrue(successAlert.isDisplayed());
    }


}
