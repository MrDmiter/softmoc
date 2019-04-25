package tests.checkout;

import org.junit.Test;
import pages.CategoryPage;
import pages.HomePage;
import pages.LoginPage;
import tests.MainTest;

public class CheckoutTest extends MainTest{

    /**
     * In progress
     */
    @Test
    public void testCheckoutTest(){
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = homePage.proceedToLoginPage();
        loginPage.signInWithRightCredentials();
        CategoryPage categoryPage = homePage.enterCategory("WOMENS", "Athletic Shoes");
        categoryPage.proceedToTheProductPage();

    }
}
