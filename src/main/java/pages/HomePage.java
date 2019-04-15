package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class HomePage extends MainPage{

    public HomePage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//nav[@id='main-menu']//ul[@role='menubar']/li/a[contains(text(),'BRANDS')]")
    private WebElement brandsTopMenuButton;

    @FindBy(xpath = "//ul[@class='dropdown menu']/li[@role='menuitem']/a[contains(.,'My Account')]")
    private WebElement myAccount;

    @FindBy(xpath = "//ul[@class='dropdown-list']/li[@role='menuitem']/a[contains(text(),'Sign In')]")
    private WebElement signIn;


    public BrandPage clickOnButton(){
        waitElementToBeClickable(brandsTopMenuButton);
        brandsTopMenuButton.click();
        return new BrandPage(driver);
    }

    public LoginPage proceedToLoginPage(){
        waitElementToBeVisible(myAccount);
        myAccount.click();
        waitElementToBeClickable(signIn);
        signIn.click();
        return new LoginPage(driver);
    }


}
