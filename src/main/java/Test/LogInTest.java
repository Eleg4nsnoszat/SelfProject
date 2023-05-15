package Test;

import Pages.*;
import Util.util;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LogInTest {


    SignUpPage signUpPage;

    RegistrationPage registrationPage;

    HomePage homePage;

    AccountCreatedPage accountCreatedPage;

    AccountDeletedPage accountDeletedPage;

    LogInPage logInPage;


    @BeforeAll
    public static void setUpDriver() {
        util.setChromeDriver();
    }

    @BeforeEach
    public void setUp() {
        util.getChromeDriver();
        signUpPage = new SignUpPage(util.driver);
        homePage = new HomePage(util.driver);
        registrationPage = new RegistrationPage(util.driver);
        accountCreatedPage = new AccountCreatedPage(util.driver);
        accountDeletedPage = new AccountDeletedPage(util.driver);
        logInPage = new LogInPage(util.driver);
    }

    @AfterEach
    public void quit() {
        util.quitBrowser();
    }


    @Test
    public void successLogIn(){
        logInPage.LogInWithUser("url","loginCorrectPassword", "loginCorrectEmail");
        homePage.clickLogOutBtn();
    }

    @Test
    public void LogInWithIncorrectEmailAndPassword(){
        logInPage.LogInWithIncorrectData("url","incorrectEmail","incorrectPassword");
        assertEquals(logInPage.getFailedLogInText(),"Your email or password is incorrect!");
    }



}