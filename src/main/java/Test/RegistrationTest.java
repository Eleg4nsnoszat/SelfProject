package Test;

import Pages.HomePage;
import Pages.LogInPage;
import Util.util;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RegistrationTest {


    LogInPage logInPage;

    HomePage homePage;


    @BeforeAll
    public static void setUpDriver(){
        util.setChromeDriver();
    }

    @BeforeEach
    public void setUp(){
        util.getChromeDriver();
        logInPage = new LogInPage(util.driver);
    }

    @AfterEach
    public void quit(){
        util.quitBrowser();
    }



    @Test
    public void successfulRegistration(){
        logInPage.RegisterWithUser("url","correctUsername", "correctEmail");
    }

}
