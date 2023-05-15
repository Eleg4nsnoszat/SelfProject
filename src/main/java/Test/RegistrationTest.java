package Test;

import Pages.*;
import Util.util;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RegistrationTest {


    SignUpPage logInPage;

    RegistrationPage signUpPage;

    HomePage homePage;

    AccountCreatedPage accountCreatedPage;

    AccountDeletedPage accountDeletedPage;


    @BeforeAll
    public static void setUpDriver(){
        util.setChromeDriver();
    }

    @BeforeEach
    public void setUp(){
        util.getChromeDriver();
        logInPage = new SignUpPage(util.driver);
        homePage = new HomePage(util.driver);
        signUpPage = new RegistrationPage(util.driver);
        accountCreatedPage = new AccountCreatedPage(util.driver);
        accountDeletedPage = new AccountDeletedPage(util.driver);
    }

    @AfterEach
    public void quit(){
        util.quitBrowser();
    }



    @Test
    public void successfulRegistration(){
        logInPage.SignUpWithUser("url","correctUsername", "correctEmail");
        signUpPage.RegisterWithUser("correctPassword","firstName","lastName","city","zipCode",
                "mobileNumber","state","address1","address2");
        accountCreatedPage.clickContinueBtn();
        homePage.clickDeleteBtn();
        accountDeletedPage.clickContinueBtn();
    }

}
