package navigation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
    WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(linkText = "Sign in")
    private WebElement signInButton;

    public void clickSignInButton() {
        System.out.println(driver.getCurrentUrl());
        signInButton.click();
    }
}
