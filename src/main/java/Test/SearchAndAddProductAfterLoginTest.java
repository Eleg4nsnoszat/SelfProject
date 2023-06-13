package Test;
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

public class SearchAndAddProductAfterLoginTest {


    HomePage homePage;

    ProductsAndDetailsPage productsAndDetailsPage;

    LogInPage logInPage;

    @BeforeAll
    public static void setUpDriver(){
        util.setChromeDriver();
    }

    @BeforeEach
    public void setUp(){
        util.getChromeDriver();
        homePage = new HomePage(util.driver);
        productsAndDetailsPage = new ProductsAndDetailsPage(util.driver);
        logInPage = new LogInPage(util.driver);
        util.maximizeWindow();
    }

    @AfterEach
    public void quit(){
        util.quitBrowser();
    }

    @Test
    public void searchAndAddProductAfterLoginTest(){
        util.navigateToUrl(ReadFromConfig.readFromFile("url"));
        productsAndDetailsPage.searchAndAddProduct();
        logInPage.LogInWithUser("url","loginCorrectPassword",
                "loginCorrectEmail");
        homePage.clickCartBtn();
        assertTrue(productsAndDetailsPage.getFirstProductName().isDisplayed());
        assertTrue(productsAndDetailsPage.getProduct43thAddCartBtn().isDisplayed());
    }

}
