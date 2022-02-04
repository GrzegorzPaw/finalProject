package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(linkText = "Sign in")
    private WebElement signInButton;

    @FindBy(id = "newsletter-input")
    private WebElement clickOnTheTextField;

    @FindBy(id = "newsletter-input")
    private WebElement emailInput;

    @FindBy(name = "submitNewsletter")
    private WebElement submitNewsletterButton;


    public void clickSignInButton() {
        System.out.println(driver.getCurrentUrl());
        signInButton.click();
    }

    public void clickOnTheTextField() {
        clickOnTheTextField.click();
    }

    public void enterYourEmail(String username) {
        emailInput.sendKeys(username);
    }

    public void submitNewsletterButton() {
        System.out.println(driver.getCurrentUrl());
        submitNewsletterButton.click();
    }


}
