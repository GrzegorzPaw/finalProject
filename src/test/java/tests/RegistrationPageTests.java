package tests;

import com.github.javafaker.Faker;
import pages.HomePage;
import pages.RegistrationPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class RegistrationPageTests extends BaseTest {

    RegistrationPage registrationPage = new RegistrationPage(driver);
    HomePage homePage = new HomePage(driver);

    private static final String EXISTING_USERNAME_LOGIN = "maniek1@man.wp.pl";
    private static final String INVALID_LOGIN_FORMAT = "nmj;34567hd@.pl";

    @Test
    void shouldRegisterCorrectly() {

        Faker faker = new Faker();
        String uniqueEmail = faker.name().firstName() + faker.name().lastName() + faker.random().nextInt(1000) + "@gamil.com";

        homePage.clickSignInButton();
        registrationPage.fillCreateAccountField(uniqueEmail);
        registrationPage.submitCreateButton();

        driver.findElement(By.id("id_gender2")).click();
        driver.findElement(By.id("customer_firstname")).sendKeys(faker.name().firstName());
        driver.findElement(By.id("customer_lastname")).sendKeys(faker.name().lastName());
        driver.findElement(By.id("passwd")).sendKeys("1234567");
        Select day = new Select(driver.findElement(By.id("days")));
        day.selectByValue("2");
        Select month = new Select(driver.findElement(By.id("months")));
        month.selectByValue("4");
        Select years = new Select(driver.findElement(By.id("years")));
        years.selectByValue("1982");
        driver.findElement(By.id("newsletter")).click();
        driver.findElement(By.id("company")).sendKeys(faker.company().name());
        driver.findElement(By.id("address1")).sendKeys(faker.address().streetAddress() + " 12");
        driver.findElement(By.id("city")).sendKeys(faker.address().city());
        Select state = new Select(driver.findElement(By.id("id_state")));
        state.selectByValue("1");
        driver.findElement(By.id("postcode")).sendKeys("00000");
        driver.findElement(By.id("phone_mobile")).sendKeys(String.valueOf(faker.number().randomNumber()));
        driver.findElement(By.id("alias")).clear();
        driver.findElement(By.id("alias")).sendKeys("ASdasda 1231");
        driver.findElement(By.id("submitAccount")).click();
        Assertions.assertTrue(driver.getCurrentUrl().contains("controller=my-account"), "Registration failed");
        driver.findElement(By.className("logout")).click();

    }

    @Test
    void shouldNotRegisterWithTheSameLoginValue() {

        homePage.clickSignInButton();
        registrationPage.fillCreateAccountField(EXISTING_USERNAME_LOGIN);
        registrationPage.submitCreateButton();
        Assertions.assertFalse(driver.getCurrentUrl().contains("controller=my-account"), "You have been logged in with the same login value");


    }

    @Test
    void shouldNotRegisterWithoutFillingInTheReguiredFields() {

        Faker faker = new Faker();
        String uniqueEmail = faker.name().firstName() + faker.name().lastName() + faker.random().nextInt(1000) + "@gamil.com";

        homePage.clickSignInButton();
        registrationPage.fillCreateAccountField(uniqueEmail);
        registrationPage.submitCreateButton();


        driver.findElement(By.id("id_gender2")).click();
        driver.findElement(By.id("customer_lastname")).sendKeys(faker.name().lastName());
        driver.findElement(By.id("passwd")).sendKeys("1234567");
        Select day = new Select(driver.findElement(By.id("days")));
        day.selectByValue("2");
        Select month = new Select(driver.findElement(By.id("months")));
        month.selectByValue("4");
        Select years = new Select(driver.findElement(By.id("years")));
        years.selectByValue("1982");
        driver.findElement(By.id("newsletter")).click();
        driver.findElement(By.id("company")).sendKeys(faker.company().name());
        driver.findElement(By.id("address1")).sendKeys(faker.address().streetAddress() + " 12");
        driver.findElement(By.id("city")).sendKeys(faker.address().city());
        Select state = new Select(driver.findElement(By.id("id_state")));
        state.selectByValue("1");
        driver.findElement(By.id("postcode")).sendKeys("00000");
        driver.findElement(By.id("phone_mobile")).sendKeys(String.valueOf(faker.number().randomNumber()));
        driver.findElement(By.id("alias")).clear();
        driver.findElement(By.id("alias")).sendKeys("ASdasda 1231");
        driver.findElement(By.id("submitAccount")).click();
        Assertions.assertEquals("firstname is required.", driver.findElement(By.xpath("//*[@id=\"center_column\"]/div/ol/li[1]")).getText(), "An identical item was not found");

    }

    @Test
    void shouldNotRegisterByTypingIncorrectEmailAddressFormat() {

        homePage.clickSignInButton();
        registrationPage.fillCreateAccountField(INVALID_LOGIN_FORMAT);
        registrationPage.submitCreateButton();
        Assertions.assertEquals("Invalid email address.", driver.findElement(By.xpath("//*[@id=\"create_account_error\"]/ol/li")).getText(), "An identical item was not found");
    }


}
