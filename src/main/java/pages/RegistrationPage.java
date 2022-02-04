package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage {

    WebDriver driver;

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "email_create")
    private WebElement yourEmail;

    @FindBy(id = "SubmitCreate")
    private WebElement submitCreateButton;


    public void fillCreateAccountField(String username) {
        yourEmail.sendKeys(username);
    }

    public void submitCreateButton() {
        System.out.println(driver.getCurrentUrl());
        submitCreateButton.click();
    }

}


