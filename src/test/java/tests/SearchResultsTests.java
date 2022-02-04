package tests;

import pages.SearchResultsPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;


public class SearchResultsTests extends BaseTest {

    SearchResultsPage searchResultsPage = new SearchResultsPage(driver);

    private static final String PRODUCT_AVAILABLE_IN_THE_STORE = "T-SHIRTS";
    private static final String NEXT_PRODUCT_AVAILABLE_IN_THE_STORE = "Dressy";
    private static final String PRODUCT_THAT_IS_NOT_IN_THE_STORE = "women's pants";


    @Test
    void shouldSearchForTheItemCorrectly() {

        searchResultsPage.productSearch(PRODUCT_AVAILABLE_IN_THE_STORE);
        searchResultsPage.submitSearchButton();
        Assertions.assertTrue(driver.getCurrentUrl().contains("controller=search&orderby=position&orderway=desc&search_query=T-SHIRTS&submit_search="), "incorrect search");
        searchResultsPage.clearTheSearchField();
        searchResultsPage.productSearch(NEXT_PRODUCT_AVAILABLE_IN_THE_STORE);
        searchResultsPage.submitSearchButton();
        Assertions.assertTrue(driver.getCurrentUrl().contains("controller=search&orderby=position&orderway=desc&search_query=Dressy&submit_search="), "incorrect search");
    }

    @Test
    void shouldNotLookForAnItemThatIsNotInTheStore() {

        searchResultsPage.productSearch(PRODUCT_THAT_IS_NOT_IN_THE_STORE);
        searchResultsPage.submitSearchButton();
        Assertions.assertEquals("No results were found for your search \"women's pants\"", driver.findElement(By.xpath("//*[@id=\"center_column\"]/p")).getText(), "An identical item was not found");
        searchResultsPage.clearTheSearchField();
    }

}


