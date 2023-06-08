package Test;

import Pages.*;
import Util.util;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestCasesPageVisibleTest {


    HomePage homePage;

    TestCasesPage testCasesPage;


    @BeforeAll
    public static void setUpDriver() {
        util.setChromeDriver();
    }

    @BeforeEach
    public void setUp() {
        util.getChromeDriver();
        util.maximizeWindow();
        homePage = new HomePage(util.driver);
        testCasesPage = new TestCasesPage(util.driver);
    }

    @AfterEach
    public void quit() {
        util.quitBrowser();
    }


    @Test
    public void testCasesVisibleTest(){
        testCasesPage.VerifyTestCasesPage("url");
        assertEquals(testCasesPage.getTestCasesTitle(),"TEST CASES");
    }



}