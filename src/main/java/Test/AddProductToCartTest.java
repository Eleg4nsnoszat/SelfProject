package Test;

import Pages.HomePage;
import Pages.LogInPage;
import Pages.ProductsAndDetailsPage;
import Util.util;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AddProductToCartTest {

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
    }

    @AfterEach
    public void quit() {
        util.quitBrowser();
    }

    @Test
    public void addProductToCart(){
        productsAndDetailsPage.addProductToCart();

    }
}
