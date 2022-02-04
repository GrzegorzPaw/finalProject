package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultsPage {

    WebDriver driver;

    public SearchResultsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "search_query_top")
    private WebElement searchForAProduct;

    @FindBy(name = "submit_search")
    private WebElement searchButton;

    @FindBy(id = "search_query_top")
    private WebElement clearTheField;


    public void productSearch(String product) {
        typecredentials1(product);

    }

    private void typecredentials1(String product) {
        searchForAProduct.sendKeys(product);
    }

    public void submitSearchButton() {
        System.out.println(driver.getCurrentUrl());
        searchButton.click();
    }

    public void clearTheSearchField() {
        clearTheField.clear();
    }


}
