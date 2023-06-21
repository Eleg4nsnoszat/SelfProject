import Pages.HomePage;
import Pages.ProductsAndDetailsPage;
import Util.util;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SearchProductTest {

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
        util.maximizeWindow();
    }

    @AfterEach
    public void quit(){
        util.quitBrowser();
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/Product.csv", numLinesToSkip = 1)
    public void searchForProduct(String product){
        productsAndDetailsPage.searchForProduct(product);
    }


}
