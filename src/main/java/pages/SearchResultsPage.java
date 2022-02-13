package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Objects;

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

    public boolean theProductHasBeenAddedT_SHIRTS() {
        return driver.getCurrentUrl().contains("controller=search&orderby=position&orderway=desc&search_query=T-SHIRTS&submit_search=");
    }

    public boolean theProductHasBeenAdded_Dressy() {
        return driver.getCurrentUrl().contains("controller=search&orderby=position&orderway=desc&search_query=Dressy&submit_search=");
    }

   public String authenticationAlert() {
        return  driver.findElement(By.xpath("//*[@id=\"center_column\"]/p")).getText();
   }

}
