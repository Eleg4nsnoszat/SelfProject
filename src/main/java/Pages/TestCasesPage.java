package Pages;

import Util.ReadFromConfig;
import Util.util;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TestCasesPage {

    WebDriver driver;

    HomePage homePage;


    @FindBy(xpath = "//b[contains(text(),'Test Cases')]")
    WebElement testCasesTitle;


    public TestCasesPage(WebDriver driver) {
        this.driver = driver;
        this.homePage = new HomePage(driver);
        PageFactory.initElements(driver,this);
    }

    public void VerifyTestCasesPage(String url){
        util.navigateToUrl(ReadFromConfig.readFromFile(url));
        homePage.clickTestCasesBtn();
        switchToFrame();
        getTestCasesTitle();
    }


    public void switchToFrame(){
        driver.switchTo().frame("aswift_4");
        driver.switchTo().frame("ad_iframe");
        driver.findElement(By.id("dismiss-button")).click();
        driver.switchTo().defaultContent();
    }

    public String getTestCasesTitle() {
        return testCasesTitle.getText();
    }
}
