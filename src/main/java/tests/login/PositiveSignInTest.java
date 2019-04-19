package tests.login;

import org.junit.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;
import tests.MainTest;

public class PositiveSignInTest extends MainTest {

    @Test
    public void testPositiveSignInTest(){
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = homePage.proceedToLoginPage();
        MyAccountPage myAccountPage = loginPage.signInWithRightCredentials();
        myAccountPage.verifyPresenceOnPage("SoftMoc - My Account Rewards","https://www.softmoc.com/ca/memberarea.aspx");
    }
}
