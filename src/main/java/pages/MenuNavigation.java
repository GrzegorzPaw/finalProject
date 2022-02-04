package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MenuNavigation {

    WebDriver driver;

    public MenuNavigation(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "contact-link")
    private WebElement contactPageButton;

    public void contactPageButton() { contactPageButton.click(); }
}
