package tests.brandgallery;

import org.junit.Test;
import pages.BrandPage;
import pages.HomePage;
import tests.MainTest;

public class VerifyBrandLogoPresenceTest extends MainTest{

    /**
     * Verify presence of the brand`s logo
     */
    @Test
    public void testVerifyBrandLogoPresenceTest(){
        HomePage homePage = new HomePage(driver);
        BrandPage brandPage = homePage.clickOnButton();
        brandPage.verifyPresenceOnPage("Shop All Brands | SoftMoc.com");
        brandPage.verifyPresenceOfBrandsLogo();
    }
}
