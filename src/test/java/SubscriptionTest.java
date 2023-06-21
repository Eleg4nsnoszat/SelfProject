import Pages.HomePage;
import Util.ReadFromConfig;
import Util.util;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SubscriptionTest {

    HomePage homePage;


    @BeforeAll
    public static void setUpDriver() {
        util.setChromeDriver();
    }

    @BeforeEach
    public void setUp() {
        util.getChromeDriver();
        util.maximizeWindow();
        homePage = new HomePage(util.driver);
    }

    @AfterEach
    public void quit() {
        util.quitBrowser();
    }


    @Test
    public void subscriptionTest(){
        util.navigateToUrl(ReadFromConfig.readFromFile("url"));
        assertEquals(homePage.getSubscriptionText(),"SUBSCRIPTION");
        homePage.fillOutSubscription();
        assertEquals(homePage.getAccessAlert(),"You have been successfully subscribed!");
    }
}
