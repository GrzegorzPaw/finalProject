package navigation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class SubscribingToTheNewsletter {

    WebDriver driver;

    public SubscribingToTheNewsletter(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
