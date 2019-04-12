package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends MainPage{

    public HomePage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//nav[@id='main-menu']//ul[@role='menubar']/li/a[contains(text(),'BRANDS')]")
    private WebElement brandsTopMenuButton;


    public BrandPage clickOnButton(){
        waitElementToBeClickable(brandsTopMenuButton);
        brandsTopMenuButton.click();
        return new BrandPage(driver);
    }


}
