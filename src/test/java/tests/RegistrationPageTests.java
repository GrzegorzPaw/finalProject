package tests;

import com.github.javafaker.Faker;
import pages.HomePage;
import pages.LoginPage;
import pages.RegistrationPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class RegistrationPageTests extends BaseTest {

    RegistrationPage registrationPage = new RegistrationPage(driver);
    HomePage homePage = new HomePage(driver);
    LoginPage loginPage = new LoginPage(driver);


    private static final String EXISTING_USERNAME_LOGIN = "maniek1@man.wp.pl";
    private static final String INVALID_LOGIN_FORMAT = "nmj;34567hd@.pl";
    private static final String EXISTING_PASSWORD = "1234567";
    private static final String POSTCODE = "00000";
    private static final String ADDRESS_ALIAS = "ASdasda 1231";

    @Test
    void shouldRegisterCorrectly() {

        Faker faker = new Faker();
        String uniqueEmail = faker.name().firstName() + faker.name().lastName() + faker.random().nextInt(1000) + "@gamil.com";

        homePage.clickSignInButton();
        registrationPage.fillCreateAccountField(uniqueEmail);
        registrationPage.submitCreateButton();
        registrationPage.chooseGender();
        registrationPage.enterYourFirstAndLastName(faker.name().firstName(), faker.name().lastName());
        registrationPage.enterYourPassword(EXISTING_PASSWORD);
        registrationPage.dateOfBirth();
        registrationPage.newsletterButtonClick();
        registrationPage.giveYourAddress(faker.company().name(), faker.address().streetAddress() + " 12", faker.address().city());
        registrationPage.state();
        registrationPage.yourPostcodeAndMobilePhone(POSTCODE, String.valueOf((faker.number().randomNumber())));
        registrationPage.assignAnAddressAlias(ADDRESS_ALIAS);
        registrationPage.submitAccountButton();
        Assertions.assertTrue(loginPage.isOnMyAccountPage(), "Registration failed");
        loginPage.clickSignOutButton();

    }

    @Test
    void shouldNotRegisterWithTheSameLoginValue() {

        homePage.clickSignInButton();
        registrationPage.fillCreateAccountField(EXISTING_USERNAME_LOGIN);
        registrationPage.submitCreateButton();
        Assertions.assertFalse(loginPage.isOnMyAccountPage(), "You have been logged in with the same login value");


    }

    @Test
    void shouldNotRegisterWithoutFillingInTheReguiredFields() {

        Faker faker = new Faker();
        String uniqueEmail = faker.name().firstName() + faker.name().lastName() + faker.random().nextInt(1000) + "@gamil.com";

        homePage.clickSignInButton();
        registrationPage.fillCreateAccountField(uniqueEmail);
        registrationPage.submitCreateButton();
        registrationPage.chooseGender();
        registrationPage.enterYourFirstAndLastName(faker.name().firstName(), faker.name().lastName());
        registrationPage.dateOfBirth();
        registrationPage.newsletterButtonClick();
        registrationPage.giveYourAddress(faker.company().name(), faker.address().streetAddress() + " 12", faker.address().city());
        registrationPage.state();
        registrationPage.yourPostcodeAndMobilePhone(POSTCODE, String.valueOf((faker.number().randomNumber())));
        registrationPage.assignAnAddressAlias(ADDRESS_ALIAS);
        registrationPage.submitAccountButton();
        Assertions.assertEquals("passwd is required.", registrationPage.authenticationAlertRegistration(), "An identical item was not found");

    }

    @Test
    void shouldNotRegisterByTypingIncorrectEmailAddressFormat() {

        homePage.clickSignInButton();
        registrationPage.fillCreateAccountField(INVALID_LOGIN_FORMAT);
        registrationPage.submitCreateButton();
        Assertions.assertEquals("Invalid email address.", registrationPage.authentationAlertEmailAddress(), "An identical item was not found");
    }

}
