import Pages.HomePage;
import Pages.LogInPage;
import Pages.ProductsAndDetailsPage;
import Util.ReadFromConfig;
import Util.util;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AddFromRecommendedItemsTest {

    HomePage homePage;

    ProductsAndDetailsPage productsAndDetailsPage;


    @BeforeAll
    public static void setUpDriver() {
        util.setChromeDriver();
    }

    @BeforeEach
    public void setUp() {
        util.getChromeDriver();
        homePage = new HomePage(util.driver);
        productsAndDetailsPage = new ProductsAndDetailsPage(util.driver);
        util.maximizeWindow();
    }

    @AfterEach
    public void quit() {
        util.quitBrowser();
    }


    @Test
    public void addFromRecommendedItemsTest(){
        util.navigateToUrl(ReadFromConfig.readFromFile("url"));
        homePage.scrollToRecommendedItem();
        productsAndDetailsPage.clickViewCartBtn();
        assertTrue(productsAndDetailsPage.getFirstProductName().isDisplayed());
    }


}
