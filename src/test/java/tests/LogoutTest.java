package tests;

import base.BaseTest;
import navigation.LoginPage;
import navigation.MainPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class LogoutTest extends BaseTest {

    MainPage mainPage = new MainPage(driver);
    LoginPage loginPage = new LoginPage(driver);

    private static final String EXISTING_USERNAME_LOGIN = "maniek1@man.wp.pl";
    private static final String EXISTING_USERNAME_PASSWORD = "1234567";

    @Test
    void shouldLogOutCorrectly() {

        mainPage.clickSignInButton();
        loginPage.login(EXISTING_USERNAME_LOGIN, EXISTING_USERNAME_PASSWORD);
        Assertions.assertTrue(isOnMyAccountPage(), "login is correct: is On My Account Page");
        loginPage.clickSignOutButton();
        Assertions.assertTrue(isNotOnMyAccountPage(), "logout failed");
    }

    private boolean isOnMyAccountPage() {
        return driver.getCurrentUrl().contains("controller=my-account");
    }

    private boolean isNotOnMyAccountPage() {
        return driver.getCurrentUrl().contains("controller=authentication&back=my-account");
    }
}

