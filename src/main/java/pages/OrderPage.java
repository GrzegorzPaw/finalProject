package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderPage {

    WebDriver driver;

    public OrderPage(WebDriver driver) {
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

    @FindBy(id = "1_1_0_0")
    private WebElement delete;

    @FindBy(xpath = "//*[@id=\"center_column\"]/p[2]/a[1]/span")
    private WebElement checkout;

    @FindBy(css = "#center_column > form > p > button > span")
    private WebElement goFurther;

    @FindBy(xpath = "//*[@id=\"order\"]/div[2]/div/div/a")
    private WebElement cross;

    @FindBy(id = "uniform-cgv")
    private WebElement agreement;

    @FindBy(xpath = "//*[@id=\"form\"]/p/button/span")
    private  WebElement buttonClickSpan;

    @FindBy(xpath = "//*[@id=\"HOOK_PAYMENT\"]/div[1]/div/p/a")
    private WebElement payByBank;

    @FindBy(xpath = "//*[@id=\"cart_navigation\"]/button/span")
    private  WebElement myOrder;

    @FindBy(css = "#form > p > button > span")
    private WebElement checkoutButton;

    @FindBy(xpath = "//*[@id=\"HOOK_PAYMENT\"]/div[2]/div/p/a")
    private WebElement payByCheck;



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
    public void delete(){
        delete.click();
    }
    public void proceedToCheckout(){checkout.click();}
    public void goFuther(){goFurther.click();}
    public void pressTheCross(){cross.click();}
    public void clickConsent(){agreement.click();}
    public void clickSpan(){buttonClickSpan.click();}
    public void payByBankWire(){payByBank.click();}
    public void IConfirmMyOrder(){myOrder.click();}
    public void ProceedToCheckoutButton(){checkoutButton.click();}
    public void payByCheck(){payByCheck.click();}


}
