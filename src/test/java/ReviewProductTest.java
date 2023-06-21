import Pages.HomePage;
import Pages.ProductsAndDetailsPage;
import Pages.ReviewPage;
import Util.util;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ReviewProductTest {

    HomePage homePage;

    ProductsAndDetailsPage productsAndDetailsPage;

    ReviewPage reviewPage;

    @BeforeAll
    public static void setUpDriver(){
        util.setChromeDriver();
    }

    @BeforeEach
    public void setUp(){
        util.getChromeDriver();
        homePage = new HomePage(util.driver);
        productsAndDetailsPage = new ProductsAndDetailsPage(util.driver);
        reviewPage = new ReviewPage(util.driver);
        util.maximizeWindow();
    }

    @AfterEach
    public void quit(){
        util.quitBrowser();
    }


    @Test
    public void reviewProductTest(){
        reviewPage.addReview();
    }
}
