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

    protected WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//nav[@id='main-menu']//ul[@role='menubar']/li/a[text()='WOMENS']")
    public WebElement womensTopBarTab;

    @FindBy(xpath = "//nav[@id='main-menu']//ul[@role='menubar']/li/a[text()='MENS']")
    public WebElement mensTopBarTab;

    @FindBy(xpath = "//nav[@id='main-menu']//ul[@role='menubar']/li/a[text()='KIDS']")
    public WebElement kidsTopBarTab;



    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 10);
    }

    public void waitElementToBeClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitElementToBeVisible(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void verifyPresenceOnPage(String expectedPageTitle, String url) {
        wait.until(ExpectedConditions.urlMatches(url));
        String actualTitle = driver.getTitle();
        Assert.assertEquals(expectedPageTitle, actualTitle);
    }

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
