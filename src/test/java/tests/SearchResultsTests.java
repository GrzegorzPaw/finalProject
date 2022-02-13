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
        Assertions.assertTrue(searchResultsPage.theProductHasBeenAddedT_SHIRTS(), "incorrect search");
        searchResultsPage.clearTheSearchField();
        searchResultsPage.productSearch(NEXT_PRODUCT_AVAILABLE_IN_THE_STORE);
        searchResultsPage.submitSearchButton();
        Assertions.assertTrue(searchResultsPage.theProductHasBeenAdded_Dressy(), "incorrect search");
    }

    @Test
    void shouldNotLookForAnItemThatIsNotInTheStore() {

        searchResultsPage.productSearch(PRODUCT_THAT_IS_NOT_IN_THE_STORE);
        searchResultsPage.submitSearchButton();
        Assertions.assertEquals("No results were found for your search \"women's pants\"", searchResultsPage.authenticationAlert(), "An identical item was not found");
        searchResultsPage.clearTheSearchField();
    }

}


