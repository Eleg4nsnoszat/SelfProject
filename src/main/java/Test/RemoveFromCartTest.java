package Test;

import Pages.HomePage;
import Pages.ProductsAndDetailsPage;
import Pages.ViewCartPage;
import Util.util;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RemoveFromCartTest {

    HomePage homePage;

    ViewCartPage viewCartPage;

    @BeforeAll
    public static void setUpDriver() {
        util.setChromeDriver();
    }

    @BeforeEach
    public void setUp() {
        util.getChromeDriver();
        homePage = new HomePage(util.driver);
        viewCartPage = new ViewCartPage(util.driver);
        util.maximizeWindow();
    }

    @AfterEach
    public void quit() {
        util.quitBrowser();
    }

    @Test
    public void removeFromCartTest(){
        viewCartPage.removeFromCart();
    }
}
