package Util;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class util {

    public static WebDriver driver;


    public static WebElement WaitForTheElement(WebDriver driver, WebElement element){
        return new WebDriverWait(driver, Duration.ofMillis(3000)).until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void navigateToUrl(String url) {
        driver.get(url);
    }

    public static void setChromeDriver() {
        WebDriverManager.chromedriver().setup();
    }

    public static void getChromeDriver() {
        driver = new ChromeDriver();
    }

    public static void quitBrowser() {
        driver.quit();
    }

    public static void acceptAlert() {
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    public static void scrollDown(WebDriver driver, WebElement element){
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView;",element);
    }

    public static void maximizeWindow(){
        driver.manage().window().maximize();
    }

    public static void clickOnElement(WebElement element){
        util.WaitForTheElement(driver,element).click();
    }

    public static void switchToFrames(String firstFrame, String secondFrame, String element){
        driver.switchTo().frame(firstFrame);
        driver.switchTo().frame(secondFrame);
        util.WaitForTheElement(driver,driver.findElement(By.id(element)));
        driver.findElement(By.id(element)).click();
        driver.switchTo().defaultContent();
    }
}
