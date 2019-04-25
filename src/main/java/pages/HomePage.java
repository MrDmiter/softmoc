package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class HomePage extends MainPage{

    //Constructor
    public HomePage(WebDriver driver) {
        super(driver);
    }

    //Web elements
    @FindBy(xpath = "//nav[@id='main-menu']//ul[@role='menubar']/li/a[text()='BRANDS']")
    private WebElement brandsTopBarTab;

    @FindBy(xpath = "//nav[@id='main-menu']//ul[@role='menubar']/li/a[text()='WOMENS']")
    private WebElement womensTopBarTab;

    @FindBy(xpath = "//nav[@id='main-menu']//ul[@role='menubar']/li/a[text()='KIDS']")
    private WebElement kidsTopBarTab;

    @FindBy(xpath = "//nav[@id='main-menu']//ul[@role='menubar']/li/a[text()='MENS']")
    private WebElement mensTopBarTab;

    @FindBy(xpath = "//ul[@class='dropdown menu']/li[@role='menuitem']/a[contains(.,'My Account')]")
    private WebElement myAccount;

    @FindBy(xpath = "//ul[@class='dropdown-list']/li[@role='menuitem']/a[contains(text(),'Sign In')]")
    private WebElement signIn;

    //Strings to allow user find element by name
    final String departmentNamePath = "//div[@id='main-womens-dropdown']//td[@class='menu-category']/a[text()='%s']";
    final String tabNamePath = "//nav[@id='main-menu']//ul[@role='menubar']/li/a[text()='%s']";


    /**
     * Enter page with the list of brands
     * @return BrandPage entity
     */
    public BrandPage clickOnButton(){
        waitElementToBeClickable(brandsTopBarTab);
        brandsTopBarTab.click();
        return new BrandPage(driver);
    }

    /**
     * Enter login page
     * @return LoginPage entity
     */
    public LoginPage proceedToLoginPage(){
        waitElementToBeVisible(myAccount);
        myAccount.click();
        signIn.click();
        return new LoginPage(driver);
    }

    /**
     * Enter any category passed by its name
     * @param tabName name of the department(tab in the top menu)
     * @param categoryName name of the category we want to enter
     * @return
     */
    public CategoryPage enterCategory(String tabName, String categoryName){
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.xpath(String.format(tabNamePath, tabName)))).perform();
        waitElementToBeClickable(driver.findElement(By.xpath(String.format(departmentNamePath, categoryName))));
        driver.findElement(By.xpath(String.format(departmentNamePath, categoryName))).click();
        return new CategoryPage(driver);
    }


}
