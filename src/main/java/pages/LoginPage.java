package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.YamlParser;

public class LoginPage extends MainPage {

    //Construtor
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    //Web elements
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

    /**
     * Sign in with wrong creds
     */
    public void signInWithWrongCredentials(){
        waitElementToBeVisible(email);
        email.sendKeys(YamlParser.getFile().getWrongEmail());
        password.sendKeys(YamlParser.getFile().getWrongPassword());
        submit.click();
        Assert.assertTrue(invalidLoginError.isDisplayed());
    }

    /**
     * Sign in with right creds
     * @return My account page entity
     */
    public MyAccountPage signInWithRightCredentials(){
        waitElementToBeVisible(email);
        email.sendKeys(YamlParser.getFile().getEmail());
        password.sendKeys(YamlParser.getFile().getPassword());
        submit.click();
        return new MyAccountPage(driver);
    }
}
