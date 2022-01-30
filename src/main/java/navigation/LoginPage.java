package navigation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "email")
    private WebElement usernameInput;
    @FindBy(id = "passwd")
    private WebElement passwordInput;
    @FindBy(id = "SubmitLogin")
    private WebElement loginButton;
    @FindBy(className = "logout")
    private WebElement signOutButton;


    public void login(String username, String password) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5, 1));
        wait.until(ExpectedConditions.visibilityOf(loginButton));
        typeCredentials(username, password);
        clickLoginButton();
    }

    private void clickLoginButton() {
        loginButton.click();
    }

    private void typeCredentials(String username, String password) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
    }

    public void clickSignOutButton() {
        System.out.println(driver.getCurrentUrl());
        signOutButton.click();
    }


}




