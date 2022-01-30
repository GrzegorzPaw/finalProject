package tests;

import base.BaseTest;
import com.github.javafaker.Faker;
import navigation.MainPage;
import navigation.Registration;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class RegistrationTests extends BaseTest {

    Registration registration = new Registration(driver);
    MainPage mainPage = new MainPage(driver);

    @Test
    void shouldRegisterCorrectly() {

        Faker faker = new Faker();
        String uniqueEmail = faker.name().firstName() + faker.name().lastName() + faker.random().nextInt(1000) + "@gamil.com";

        mainPage.clickSignInButton();
        driver.findElement(By.id("email_create")).sendKeys(uniqueEmail);
        driver.findElement(By.id("SubmitCreate")).click();
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

        mainPage.clickSignInButton();
        driver.findElement(By.id("email_create")).sendKeys("maniek1@man.wp.pl");
        driver.findElement(By.id("SubmitCreate")).click();
        Assertions.assertFalse(driver.getCurrentUrl().contains("controller=my-account"), "You have been logged in with the same login value");


    }

    @Test
    void shouldNotRegisterWithoutFillingInTheReguiredFields() {
        Faker faker = new Faker();
        String uniqueEmail = faker.name().firstName() + faker.name().lastName() + faker.random().nextInt(1000) + "@gamil.com";
        mainPage.clickSignInButton();
        driver.findElement(By.id("email_create")).sendKeys(uniqueEmail);
        driver.findElement(By.id("SubmitCreate")).click();
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

        mainPage.clickSignInButton();
        driver.findElement(By.id("email_create")).sendKeys("nmj;34567hd@.pl");
        driver.findElement(By.id("SubmitCreate")).click();
        Assertions.assertEquals("Invalid email address.", driver.findElement(By.xpath("//*[@id=\"create_account_error\"]/ol/li")).getText(), "An identical item was not found");
    }


}
