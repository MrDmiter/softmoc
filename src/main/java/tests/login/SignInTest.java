package tests.login;

import org.junit.Test;
import pages.HomePage;
import pages.LoginPage;
import tests.MainTest;

public class SignInTest extends MainTest {

    @Test
    public void testSignInTest(){
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = homePage.proceedToLoginPage();
        loginPage.signInWithWrongCredentials();
    }
}
