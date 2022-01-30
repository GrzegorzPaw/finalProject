package navigation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Registration {

    WebDriver driver;
    public Registration(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

}
