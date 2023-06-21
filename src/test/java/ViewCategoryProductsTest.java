import Pages.HomePage;
import Pages.ProductsAndDetailsPage;
import Util.util;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ViewCategoryProductsTest {

    HomePage homePage;


    @BeforeAll
    public static void setUpDriver() {
        util.setChromeDriver();
    }

    @BeforeEach
    public void setUp() {
        util.getChromeDriver();
        homePage = new HomePage(util.driver);
        util.maximizeWindow();
    }

    @AfterEach
    public void quit() {
        util.quitBrowser();
    }

    @Test
    public void viewCategoryProductsTest(){
        homePage.viewProductCategory();
    }

}
