package tests.brandgallery;

import org.junit.Test;
import pages.BrandPage;
import pages.HomePage;
import tests.MainTest;

public class TotalAmountOfBrandsOnPageTest extends MainTest{

    /**
     * Verify changes of brands quantity
     */
    @Test
    public void testTotalAmountOfBrandsOnPage(){
        HomePage homePage = new HomePage(driver);
        BrandPage brandPage = homePage.clickOnButton();
        brandPage.verifyPresenceOnPage("Shop All Brands | SoftMoc.com");
        brandPage.verifyTotalAmountOfBrandsOnPage();
    }
}
