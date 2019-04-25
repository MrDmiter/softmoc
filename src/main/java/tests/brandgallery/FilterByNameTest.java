package tests.brandgallery;

import org.junit.Test;
import pages.BrandPage;
import pages.HomePage;
import tests.MainTest;

public class FilterByNameTest extends MainTest {

    /**
     * Verify that brand filter works correct
     */
    @Test
    public void testFilterByNameTest(){
        HomePage homePage = new HomePage(driver);
        BrandPage brandPage = homePage.clickOnButton();
        brandPage.verifyPresenceOnPage("Shop All Brands | SoftMoc.com");
        brandPage.brandAccordingToTheFilterByName();
    }

}
