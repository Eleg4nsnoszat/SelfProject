import Pages.*;
import Util.util;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RegistrationTest {


    SignUpPage signUpPage;

    RegistrationPage registrationPage;

    HomePage homePage;

    AccountCreatedPage accountCreatedPage;

    AccountDeletedPage accountDeletedPage;

    LogInPage logInPage;


    @BeforeAll
    public static void setUpDriver(){
        util.setChromeDriver();
    }

    @BeforeEach
    public void setUp(){
        util.getChromeDriver();
        logInPage = new LogInPage(util.driver);
        homePage = new HomePage(util.driver);
        signUpPage = new SignUpPage(util.driver);
        accountCreatedPage = new AccountCreatedPage(util.driver);
        accountDeletedPage = new AccountDeletedPage(util.driver);
        registrationPage = new RegistrationPage(util.driver);
        util.maximizeWindow();
    }

    @AfterEach
    public void quit(){
        util.quitBrowser();
    }



    @Test
    public void successfulRegistration(){
        signUpPage.SignUpWithUser("url","correctUsername", "correctEmail");
        registrationPage.RegisterWithUser("correctPassword","firstName","lastName","city","zipCode",
                "mobileNumber","state","address1","address2");
        accountCreatedPage.clickContinueBtn();
        util.hideElements();
        homePage.clickHomeBtn();
        homePage.clickDeleteBtn();
        accountDeletedPage.clickContinueBtn();
    }

}
