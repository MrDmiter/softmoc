package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.YamlParser;

public class LoginPage extends MainPage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@placeholder='Email']")
    private WebElement email;

    @FindBy(xpath = "//input[@placeholder='Password']")
    private WebElement password;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement submit;

    @FindBy(xpath = "//div/a[contains(text(),'Create a New Account')]")
    private WebElement createNewAccount;

    @FindBy(xpath = "//p[@class='form-error small-12 columns']")
    private WebElement invalidLoginError;

    public void signInWithWrongCredentials(){
        waitElementToBeVisible(email);
        email.sendKeys(YamlParser.getFile().getEmail());
        password.sendKeys(YamlParser.getFile().getPassword());
        submit.click();
        Assert.assertTrue(invalidLoginError.isDisplayed());
    }
}
