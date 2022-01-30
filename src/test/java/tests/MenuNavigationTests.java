package tests;

import base.BaseTest;
import navigation.MenuNavigation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MenuNavigationTests extends BaseTest {

    MenuNavigation menuNavigation = new MenuNavigation(driver);

    @Test
    void shouldFindLoginAndSearchBoxOnTheHomePageAndTheLoginPage() {

        Assertions.assertTrue(driver.findElement(By.xpath("//*[@id=\"header_logo\"]/a/img")).isDisplayed());
        driver.findElement(By.name("submit_search")).click();
        Assertions.assertTrue(driver.getCurrentUrl().contains("controller=search&orderby=position&orderway=desc&search_query=&submit_search="), "operation failed");
        driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")).click();
        Assertions.assertTrue(driver.findElement(By.xpath("//*[@id=\"header_logo\"]/a/img")).isDisplayed());
        driver.findElement(By.name("submit_search")).click();
        Assertions.assertTrue(driver.getCurrentUrl().contains("controller=search&orderby=position&orderway=desc&search_query=&submit_search="), "operation failed");

    }

    @Test
    void shouldGoToTheContactPage() {

        menuNavigation.contactPage();
        Assertions.assertTrue(driver.getCurrentUrl().contains("controller=contact"), "operation failed");
    }

    @Test
    void shouldFindTheNewsletterTextField() {

        List<WebElement> newsletter = driver.findElements(By.id("newsletter-input"));
        Assertions.assertEquals(1, newsletter.size(), "An identical item was not found");
    }

    @Test
    void shouldGoFromTheLoginPageToTheHomePage() {

        driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")).click();
        Assertions.assertTrue(driver.getCurrentUrl().contains("controller=authentication&back=my-account"), "operation failed");
        driver.findElement(By.xpath("//*[@id=\"columns\"]/div[1]/a/i")).click();
        Assertions.assertTrue(driver.getCurrentUrl().contains("index.php"), "operation failed");
    }

    @Test
    void shouldFindTheFollowingFieldsOnTheLoginPageWomenDressesTshirtsReturnToHomeEmailAddressCreateAnAccoundEmailAddressPasswordForgotYourPasswordSignIn() {

        driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")).click();
        Assertions.assertTrue(driver.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[1]/a")).isDisplayed());
        Assertions.assertTrue(driver.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[2]/a")).isDisplayed());
        Assertions.assertTrue(driver.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[3]/a")).isDisplayed());
        Assertions.assertTrue(driver.findElement(By.xpath("//*[@id=\"columns\"]/div[1]/a")).isDisplayed());
        Assertions.assertTrue(driver.findElement(By.id("email_create")).isDisplayed());
        Assertions.assertTrue(driver.findElement(By.xpath("//*[@id=\"SubmitCreate\"]/span")).isDisplayed());
        Assertions.assertTrue(driver.findElement(By.id("email")).isDisplayed());
        Assertions.assertTrue(driver.findElement(By.id("passwd")).isDisplayed());
        Assertions.assertTrue(driver.findElement(By.xpath("//*[@id=\"login_form\"]/div/p[1]/a")).isDisplayed());
        Assertions.assertTrue(driver.findElement(By.xpath("//*[@id=\"SubmitLogin\"]/span")).isDisplayed());
    }

}


