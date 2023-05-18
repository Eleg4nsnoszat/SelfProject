package Util;

import Pages.HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.sound.midi.Soundbank;
import java.time.Duration;

public class util {

    public static WebDriver driver;

    public static HomePage homePage;


    public static WebElement WaitForTheElement(WebDriver driver, WebElement element){
        return new WebDriverWait(driver, Duration.ofMillis(3000)).until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void navigateToUrl(String url) {
        driver.get(url);
    }

    public static void refreshPage() {
        driver.navigate().refresh();
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

    public static void LogOut(){
        homePage.clickLogOutBtn();
    }

    public static void acceptAlert() {
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }
}
