import Pages.CartPage;
import Pages.HomePage;
import Util.ReadFromConfig;
import Util.util;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SubscriptionOnCartPageTest {
    HomePage homePage;

    CartPage cartPage;


    @BeforeAll
    public static void setUpDriver() {
        util.setChromeDriver();
    }

    @BeforeEach
    public void setUp() {
        util.getChromeDriver();
        util.maximizeWindow();
        homePage = new HomePage(util.driver);
        cartPage = new CartPage(util.driver);
    }

    @AfterEach
    public void quit() {
        util.quitBrowser();
    }


    @Test
    public void subscriptionOnCartPageTest(){
        util.navigateToUrl(ReadFromConfig.readFromFile("url"));
        homePage.clickCartBtn();
        assertEquals(cartPage.getSubscriptionTextCartPage(),"SUBSCRIPTION");
        cartPage.fillOutSubscriptionCartPage();
        assertEquals(cartPage.getAccessAlertCartPage(),"You have been successfully subscribed!");
    }

}
