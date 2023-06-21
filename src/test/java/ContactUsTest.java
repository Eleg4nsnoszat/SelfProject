import Pages.*;
import Util.util;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ContactUsTest {


    SignUpPage signUpPage;

    RegistrationPage registrationPage;

    AccountCreatedPage accountCreatedPage;

    AccountDeletedPage accountDeletedPage;

    LogInPage logInPage;

    ContactUsPage contactUsPage;


    @BeforeAll
    public static void setUpDriver() {
        util.setChromeDriver();
    }

    @BeforeEach
    public void setUp() {
        util.getChromeDriver();
        signUpPage = new SignUpPage(util.driver);
        registrationPage = new RegistrationPage(util.driver);
        accountCreatedPage = new AccountCreatedPage(util.driver);
        accountDeletedPage = new AccountDeletedPage(util.driver);
        logInPage = new LogInPage(util.driver);
        contactUsPage = new ContactUsPage(util.driver);
        util.maximizeWindow();
    }

    @AfterEach
    public void quit() {
        util.quitBrowser();
    }


    @Test
    public void contactUsTest(){
        contactUsPage.fillOutContactUs("url", "loginCorrectEmail","firstName");
    }



}
