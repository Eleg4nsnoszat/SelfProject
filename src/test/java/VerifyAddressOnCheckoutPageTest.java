import Pages.*;
import Util.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class VerifyAddressOnCheckoutPageTest {

    SignUpPage signUpPage;

    RegistrationPage registrationPage;

    HomePage homePage;

    AccountCreatedPage accountCreatedPage;

    AccountDeletedPage accountDeletedPage;

    PaymentPage paymentPage;

    CheckOutPage checkOutPage;

    ProductsAndDetailsPage productsAndDetailsPage;

    ViewCartPage viewCartPage;

    @BeforeEach
    public void setUp(){
        util.getChromeDriver();
        homePage = new HomePage(util.driver);
        signUpPage = new SignUpPage(util.driver);
        accountCreatedPage = new AccountCreatedPage(util.driver);
        accountDeletedPage = new AccountDeletedPage(util.driver);
        registrationPage = new RegistrationPage(util.driver);
        paymentPage = new PaymentPage(util.driver);
        checkOutPage = new CheckOutPage(util.driver);
        productsAndDetailsPage = new ProductsAndDetailsPage(util.driver);
        viewCartPage = new ViewCartPage(util.driver);
        util.maximizeWindow();
    }

    @AfterEach
    public void quit(){
        util.quitBrowser();
    }


    @Test
    public void verifyAddressOnCheckoutPageTest(){
        signUpPage.SignUpWithUser("url","correctUsername","correctEmail");
        registrationPage.RegisterWithUser("correctPassword","firstName",
                "lastName",
                "city","zipCode","mobileNumber",
                "state","address1","address2");
        accountCreatedPage.clickContinueBtn();
        util.hideElements();
        accountCreatedPage.clickContinueBtn();
        productsAndDetailsPage.addAProductToCart();
        util.clickOnElement(viewCartPage.getProceedToCheckOutBtn());
        util.hideElements();
        assertEquals(checkOutPage.getFirstAddressText().getText(), ReadFromConfig.readFromFile("address1"));
        homePage.clickDeleteBtn();
        accountDeletedPage.clickContinueBtn();
    }
}
