package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class BrandPage extends MainPage {

    //Constructor
    public BrandPage(WebDriver driver) {
        super(driver);
    }

    //Web elements
    @FindBy(xpath = "//ul[@class='block-grid column brands']/li/a/img")
    public List<WebElement> brandsIcons;

    @FindBy(xpath = "//ul[@class='block-grid column brands']/li")
    public List<WebElement> brandContainer;

    @FindBy(xpath = "//div[@class='wrap float-right']/ul/li")
    public List<WebElement> filterByNameLetters;

    @FindBy(xpath = "//div[@class='container']//img")
    public List<WebElement> categoryIcons;

    @FindBy(id = "left-column")
    public WebElement filterBlock;

    @FindBy(xpath = "//ul[@class='block-grid column brands']/li/a/p")
    public List<WebElement> brandName;

    @FindBy(xpath = "//div[@class='container']")
    public List<WebElement> categoriesOnBrandPage;


    /**
     * Verify presence of the main logo of the brand on the Brands page by picture extension
     */
    public void verifyPresenceOfBrandsLogo() {
        ArrayList<WebElement> list = new ArrayList<>(brandsIcons);
        for (WebElement element : list) {
            String pathToImage = element.getAttribute("src");
            Assert.assertTrue(pathToImage.contains(".jpg") | pathToImage.contains(".gif"));
        }
    }

    /**
     * Verify amount of the brands on page
     */
    public void verifyTotalAmountOfBrandsOnPage() {
        Assert.assertEquals(94, brandContainer.size());
    }

    /**
     * Verify that "Filter by name" works correctly
     */
    public void brandAccordingToTheFilterByName() {
        ArrayList<WebElement> listOfLetters = new ArrayList<>(filterByNameLetters);
        for (WebElement element : listOfLetters) {
            String letter = element.getText();
            String lowerCAseLetter = element.getText().toLowerCase();
            if (!(element.getAttribute("class").equalsIgnoreCase("disable-toggle"))) {
                element.click();
                //Can`t find better approach
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                ArrayList<WebElement> brandsList = new ArrayList<>(brandContainer);
                for (WebElement webElement : brandsList) {
                    if (webElement.isDisplayed()) {
                        waitElementToBeVisible(webElement);
                        String brandName = webElement.getText();
                        System.out.println("Brand name-" + brandName + " " + "Letter-" + letter + " " + "LowerLetter-" + lowerCAseLetter);
                        Assert.assertTrue(brandName.startsWith(letter) | brandName.startsWith(lowerCAseLetter));
                    }
                }
            }
        }
    }

    /**
     * Enter each brand page and verify presence of the category logo
     */
    int count = 0;

    public void enterBrandPage() {
        ArrayList<WebElement> listOfBrands = new ArrayList<>(brandContainer);
        ArrayList<WebElement> nameOfBrands = new ArrayList<>(brandName);
        while (count != listOfBrands.size()) {
            waitElementToBeClickable(listOfBrands.get(count));
            String brandWithMistake = nameOfBrands.get(count).getText();
            listOfBrands.get(count).click();
            try {
                if (filterBlock.isDisplayed()) {
                    if (categoryIcons.size() != categoriesOnBrandPage.size()) {
                        System.out.println(brandWithMistake);
                    }
                }
            } catch (Exception e) {

            }
            driver.navigate().back();
            count++;
            enterBrandPage();
        }


    }

}
