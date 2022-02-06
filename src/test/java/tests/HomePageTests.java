package tests;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.HomePage;
import pages.SearchResultsPage;

import java.util.List;

public class HomePageTests extends BaseTest {

    HomePage homePage = new HomePage(driver);
    SearchResultsPage searchResultsPage = new SearchResultsPage(driver);

    private static final String EXISTING_USERNAME_LOGIN = "maniek1@man.wp.pl";

    @AfterEach
    void clearCookies() {
        driver.manage().deleteAllCookies();
    }

    @Test
    void shouldSubscribeToTheNewsletterCorrectly() {
        Faker faker = new Faker();
        String uniqueEmail = faker.name().firstName() + faker.name().lastName() + faker.random().nextInt(1000) + "@gamil.com";
        homePage.clickOnTheTextField();
        homePage.enterYourEmail(uniqueEmail);
        homePage.submitNewsletterButton();
        Assertions.assertEquals("Newsletter : You have successfully subscribed to this newsletter.", driver.findElement(By.xpath("//*[@id=\"columns\"]/p")).getText(), "An identical item was not found");
    }

    @Test
    void shouldNotSubscribeToTheNewsletterByProvidingAnEmailAddressAlreadyRegistered() {

        homePage.clickOnTheTextField();
        homePage.enterYourEmail(EXISTING_USERNAME_LOGIN);
        homePage.submitNewsletterButton();
        Assertions.assertEquals("Newsletter : This email address is already registered.", driver.findElement(By.xpath("//*[@id=\"columns\"]/p")).getText(), "An identical item was not found");
    }

    @Test
    void shouldNotSubscribeToTheNewsletterWithoutProvidingAnEmailAddress() {

        homePage.clickOnTheTextField();
        homePage.submitNewsletterButton();
        Assertions.assertEquals("Newsletter : Invalid email address.", driver.findElement(By.xpath("//*[@id=\"columns\"]/p")).getText(), "An identical item was not found");
    }

    @Test
    void shouldFindLoginAndSearchBoxOnTheHomePageAndTheLoginPage() {

        Assertions.assertTrue(driver.findElement(By.xpath("//*[@id=\"header_logo\"]/a/img")).isDisplayed());
        searchResultsPage.submitSearchButton();
        Assertions.assertTrue(driver.getCurrentUrl().contains("controller=search&orderby=position&orderway=desc&search_query=&submit_search="), "operation failed");
        homePage.clickSignInButton();
        Assertions.assertTrue(driver.findElement(By.xpath("//*[@id=\"header_logo\"]/a/img")).isDisplayed());
        searchResultsPage.submitSearchButton();
        Assertions.assertTrue(driver.getCurrentUrl().contains("controller=search&orderby=position&orderway=desc&search_query=&submit_search="), "operation failed");

    }

    @Test
    void shouldGoToTheContactPage() {

        homePage.contactPageButton();
        Assertions.assertTrue(driver.getCurrentUrl().contains("controller=contact"), "operation failed");
    }

    @Test
    void shouldFindTheNewsletterTextField() {

        List<WebElement> newsletter = driver.findElements(By.id("newsletter-input"));
        Assertions.assertEquals(1, newsletter.size(), "An identical item was not found");
    }

    @Test
    void shouldGoFromTheLoginPageToTheHomePage() {

        homePage.clickSignInButton();
        Assertions.assertTrue(driver.getCurrentUrl().contains("controller=authentication&back=my-account"), "operation failed");
        homePage.pressBackToHomePage();
        Assertions.assertTrue(driver.getCurrentUrl().contains("index.php"), "operation failed");
    }

    @Test
    void shouldFindAllFieldsOnTheLoginPage(){


        homePage.clickSignInButton();
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


