package tests;

import pages.LoginPage;
import pages.HomePage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LoginPageTests extends BaseTest {


    LoginPage loginPage = new LoginPage(driver);
    HomePage homePage = new HomePage(driver);

    private static final String EXISTING_USERNAME_LOGIN = "maniek1@man.wp.pl";
    private static final String EXISTING_USERNAME_PASSWORD = "1234567";
    private static final String NOT_EXISTING_USERNAME_LOGIN = "";
    private static final String NOT_EXISTING_USERNAME_PASSWORD = "";


    @Test
    void shouldLoginProperly() {
        homePage.clickSignInButton();
        loginPage.login(EXISTING_USERNAME_LOGIN, EXISTING_USERNAME_PASSWORD);
        Assertions.assertTrue(loginPage.isOnMyAccountPage(), "there was an invalid login: is not on my account page");
    }

    @Test
    void shouldNotLoginProperly() {
        homePage.clickSignInButton();
        loginPage.login(NOT_EXISTING_USERNAME_LOGIN, NOT_EXISTING_USERNAME_PASSWORD);
        Assertions.assertFalse(loginPage.isOnMyAccountPage(), "login is correct: is On My Account Page");

    }

    @Test
    void shouldNotLoginWithoutLoginValue() {
        homePage.clickSignInButton();
        loginPage.login(NOT_EXISTING_USERNAME_LOGIN, EXISTING_USERNAME_PASSWORD);
        Assertions.assertFalse(loginPage.isOnMyAccountPage(), "login is correct: is On My Account Page");

    }

    @Test
    void shouldNotLoginWithoutPassword() {
        homePage.clickSignInButton();
        loginPage.login(EXISTING_USERNAME_LOGIN, NOT_EXISTING_USERNAME_PASSWORD);
        Assertions.assertFalse(loginPage.isOnMyAccountPage(), "login is correct: is On My Account Page");

    }

    @Test
    void shouldLogOutCorrectly() {

        homePage.clickSignInButton();
        loginPage.login(EXISTING_USERNAME_LOGIN, EXISTING_USERNAME_PASSWORD);
        Assertions.assertTrue(loginPage.isOnMyAccountPage(), "login is correct: is On My Account Page");
        loginPage.clickSignOutButton();
        Assertions.assertFalse(loginPage.isOnMyAccountPage(), "logout failed");
    }
}





