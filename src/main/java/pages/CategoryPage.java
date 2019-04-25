package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class CategoryPage extends MainPage {

    //Constructor
    public CategoryPage(WebDriver driver) {
        super(driver);
    }


    //Web elements
    @FindBy(xpath = "//div[@class='column text-center grid-item']")
    private List<WebElement> products;

    /**
     * Choose random product in the department and open its product page
     * @return entity of the the productPage
     */
    public ProductPage proceedToTheProductPage(){
        //List of all visible products on the page
        ArrayList<WebElement> listOfProducts = new ArrayList<>(products);

        //Wait till last visible product is loaded
        waitElementToBeClickable(listOfProducts.get(19));

        //Click on any product app chooses
        listOfProducts.get((int)(Math.random()*listOfProducts.size())).click();
        return new ProductPage(driver);
    }


}
