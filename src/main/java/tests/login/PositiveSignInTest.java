package tests.login;

import org.junit.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;
import tests.MainTest;

public class PositiveSignInTest extends MainTest {

    /**
     * Sign in with valid creds
     */
    @Test
    public void testPositiveSignInTest(){
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = homePage.proceedToLoginPage();
        MyAccountPage myAccountPage = loginPage.signInWithRightCredentials();
        myAccountPage.verifyPresenceOnPage("SoftMoc - My Account Rewards");
    }
}
