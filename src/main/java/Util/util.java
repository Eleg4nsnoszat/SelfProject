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

    public static void scrollDown(WebDriver driver,int pixel){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,"+ pixel +")");
    }

    public static void scrollUp(WebDriver driver){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,-10000)");
    }

    public static void maximizeWindow(){
        driver.manage().window().maximize();
    }

    public static void clickOnElement(WebElement element){
        util.WaitForTheElement(driver,element).click();
    }


    public static void hideElements() {
        String jsCode1 = "document.querySelectorAll('[id^=aswift]').forEach(iframe => iframe.remove());";
        String jsCode2 = "document.querySelectorAll('[class^=adsbygoogle]').forEach(iframe => iframe.remove());";
        ((JavascriptExecutor) driver).executeScript(jsCode1);
        ((JavascriptExecutor) driver).executeScript(jsCode2);
    }
}
