package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MakingAPurchase {

    WebDriver driver;

    public MakingAPurchase(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"block_top_menu\"]/ul/li[3]")
    private WebElement selectACategory;

    @FindBy(xpath = "//*[@id=\"center_column\"]/ul/li/div/div[1]/div/a[1]/img")
    private WebElement productSelection;

    @FindBy(id = "add_to_cart")
    private WebElement submit;

    @FindBy(xpath = "//*[@id=\"layer_cart\"]/div[1]/div[1]/span")
    private  WebElement closeWindow;

    @FindBy(xpath = "//*[@id=\"header\"]/div[3]/div/div/div[3]/div/a")
    private  WebElement shoppingCartSummary;


    public void selectACategory() {
        selectACategory.click();
    }
    public void productSelection() {
        productSelection.click();
    }
    public void submit() {
        submit.click();
    }
    public void closeWindow(){
        closeWindow.click();
    }
    public void shoppingCartSummary(){
        shoppingCartSummary.click();
    }

}
