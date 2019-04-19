package tests.checkout;

import org.junit.Test;
import pages.HomePage;
import pages.LoginPage;
import tests.MainTest;

public class CheckoutTest extends MainTest{


    @Test
    public void testCheckoutTest(){
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = homePage.proceedToLoginPage();
        loginPage.signInWithRightCredentials();

    }
}
