package tests;

import base.BaseTest;
import navigation.SearchingForItems;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;


public class SearchingForItemsTests extends BaseTest {

    SearchingForItems searchingForItems = new SearchingForItems(driver);



    @Test
    void shouldSearchForTheItemCorrectly() {

        driver.findElement(By.id("search_query_top")).sendKeys("T-SHIRTS");
        driver.findElement(By.name("submit_search")).click();
        Assertions.assertTrue(driver.getCurrentUrl().contains("controller=search&orderby=position&orderway=desc&search_query=T-SHIRTS&submit_search="),"incorrect search");
        driver.findElement(By.id("search_query_top")).clear();
        driver.findElement(By.id("search_query_top")).sendKeys("Dressy");
        driver.findElement(By.name("submit_search")).click();
        Assertions.assertTrue(driver.getCurrentUrl().contains("controller=search&orderby=position&orderway=desc&search_query=Dressy&submit_search="),"incorrect search");
    }

    @Test
    void shouldNotLookForAnItemThatIsNotInTheStore() {

        driver.findElement(By.id("search_query_top")).sendKeys("women's pants");
        driver.findElement(By.name("submit_search")).click();
        Assertions.assertEquals("No results were found for your search \"women's pants\"", driver.findElement(By.xpath("//*[@id=\"center_column\"]/p")).getText(),"An identical item was not found");
    }

}


