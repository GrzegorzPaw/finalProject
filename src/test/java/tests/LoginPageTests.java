package tests;

import base.BaseTest;
import navigation.LoginPage;
import navigation.MainPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LoginPageTests extends BaseTest {


    LoginPage loginPage = new LoginPage(driver);
    MainPage mainPage = new MainPage(driver);

    private static final String EXISTING_USERNAME_LOGIN = "maniek1@man.wp.pl";
    private static final String EXISTING_USERNAME_PASSWORD = "1234567";
    private static final String NOT_EXISTING_USERNAME_LOGIN = "";
    private static final String NOT_EXISTING_USERNAME_PASSWORD = "";


    @Test
    void shouldLoginProperly() {
        mainPage.clickSignInButton();
        loginPage.login(EXISTING_USERNAME_LOGIN, EXISTING_USERNAME_PASSWORD);
        Assertions.assertTrue(isOnMyAccountPage(), "there was an invalid login: is not on my account page");
    }

    @Test
    void shouldNotLoginProperly() {
        mainPage.clickSignInButton();
        loginPage.login(NOT_EXISTING_USERNAME_LOGIN, NOT_EXISTING_USERNAME_PASSWORD);
        Assertions.assertFalse(isOnMyAccountPage(), "login is correct: is On My Account Page");

    }

    @Test
    void shouldNotLoginWithoutLoginValue() {
        mainPage.clickSignInButton();
        loginPage.login(NOT_EXISTING_USERNAME_LOGIN, EXISTING_USERNAME_PASSWORD);
        Assertions.assertFalse(isOnMyAccountPage(), "login is correct: is On My Account Page");

    }

    @Test
    void shouldNotLoginWithoutPassword() {
        mainPage.clickSignInButton();
        loginPage.login(EXISTING_USERNAME_LOGIN, NOT_EXISTING_USERNAME_PASSWORD);
        Assertions.assertFalse(isOnMyAccountPage(), "login is correct: is On My Account Page");

    }

    public boolean isOnMyAccountPage() {
        return driver.getCurrentUrl().contains("controller=my-account");
    }
}





