package navigation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class SearchingForItems {

    WebDriver driver;

    public SearchingForItems(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


}
