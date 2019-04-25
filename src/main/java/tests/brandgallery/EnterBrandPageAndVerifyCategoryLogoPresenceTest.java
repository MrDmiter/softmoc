package tests.brandgallery;

import org.junit.Test;
import pages.BrandPage;
import pages.HomePage;
import tests.MainTest;

public class EnterBrandPageAndVerifyCategoryLogoPresenceTest extends MainTest {


    /**
     * Check presence of the brand logo on the brand page
     */
    @Test
    public void testEnterBrandPageAndVerifyCategoryLogoPresenceTest(){
        HomePage homePage = new HomePage(driver);
        BrandPage brandPage = homePage.clickOnButton();
        brandPage.enterBrandPage();
    }
}
