package tests.login;

import org.junit.Test;
import pages.HomePage;
import pages.LoginPage;
import tests.MainTest;

public class NegativeSignInTest extends MainTest {

    /**
     * Sign in with negative creds
     */
    @Test
    public void testNegativeSignInTest(){
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = homePage.proceedToLoginPage();
        loginPage.signInWithWrongCredentials();
        }
}
