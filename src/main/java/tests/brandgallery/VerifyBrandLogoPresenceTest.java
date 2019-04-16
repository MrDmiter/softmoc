package tests.brandgallery;

import org.junit.Test;
import pages.BrandPage;
import pages.HomePage;
import tests.MainTest;

public class VerifyBrandLogoPresenceTest extends MainTest{

    @Test
    public void testVerifyBrandLogoPresenceTest(){
        HomePage homePage = new HomePage(driver);
        BrandPage brandPage = homePage.clickOnButton();
        brandPage.verifyPresenceOnPage("Shop All Brands | SoftMoc.com", "https://www.softmoc.com/ca/brands?osc=menu+brands");
        brandPage.verifyPresenceOfBrandsLogo();
    }
}
