package Test;

import Pages.HomePage;
import Pages.ProductsAndDetailsPage;
import Util.util;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ViewProductsAndDetailsTest {

    HomePage homePage;

    ProductsAndDetailsPage productsAndDetailsPage;

    @BeforeAll
    public static void setUpDriver(){
        util.setChromeDriver();
    }

    @BeforeEach
    public void setUp(){
        util.getChromeDriver();
        homePage = new HomePage(util.driver);
        productsAndDetailsPage = new ProductsAndDetailsPage(util.driver);
    }

    @AfterEach
    public void quit(){
        util.quitBrowser();
    }

    @Test
    public void viewProductsAndDetailsTest(){
        productsAndDetailsPage.goToProductsPage();
        util.hideElements();
        productsAndDetailsPage.clickViewProductBtn();
        assertEquals(productsAndDetailsPage.getProductAvailability(),"Availability:");
        assertEquals(productsAndDetailsPage.getProductBrand(),"Brand:");
        assertEquals(productsAndDetailsPage.getProductName(),"Blue Top");
        assertEquals(productsAndDetailsPage.getProductPrice(),"Rs. 500");
        assertEquals(productsAndDetailsPage.getProductCondition(),"Condition:");
        assertEquals(productsAndDetailsPage.getProductCategory(),"Category: Women > Tops");
    }



}
