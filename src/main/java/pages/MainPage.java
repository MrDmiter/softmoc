package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {

    //Web driver field
    protected WebDriver driver;
    //Web driver wait field
    private WebDriverWait wait;

    //Constructor
    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 10);
    }

    //Web elements
    @FindBy(xpath = "//nav[@id='main-menu']//ul[@role='menubar']/li/a[text()='WOMENS']")
    public WebElement womensTopBarTab;

    @FindBy(xpath = "//nav[@id='main-menu']//ul[@role='menubar']/li/a[text()='MENS']")
    public WebElement mensTopBarTab;

    @FindBy(xpath = "//nav[@id='main-menu']//ul[@role='menubar']/li/a[text()='KIDS']")
    public WebElement kidsTopBarTab;


    //Wait till element is clickable
    public void waitElementToBeClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    //Wait till element is visible
    public void waitElementToBeVisible(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    //Check presence on the page
    public void verifyPresenceOnPage(String expectedPageTitle) {
        String actualTitle = driver.getTitle();
        Assert.assertEquals(expectedPageTitle, actualTitle);
    }

    /**
     * Hover over passed tabName (DEPRECATED)
     * @param tabName
     */
    public void hoverOverTopBarTab(String tabName){
        Actions action = new Actions(driver);
        switch (tabName.toUpperCase()){
            case "MENS":
                action.moveToElement(mensTopBarTab).perform();
                break;
            case "WOMENS":
                action.moveToElement(womensTopBarTab).perform();
                break;
            case "KIDS":
                action.moveToElement(kidsTopBarTab).perform();
                break;
            default:
                System.out.println("There is no such tab");
        }



    }




}
