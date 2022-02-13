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


    @FindBy(css = "#block_top_menu > ul > li:nth-child(3)")
    private WebElement selectACategory;

    @FindBy(xpath = "//a[@class='product_img_link']")
    private WebElement productSelection;

    @FindBy(id = "add_to_cart")
    private WebElement submit;

    @FindBy(xpath = "//span[@class='cross']")
    private  WebElement closeWindow;

    @FindBy(xpath = "//a[@title='View my shopping cart']")
    private  WebElement shoppingCartSummary;

    @FindBy(id = "1_1_0_0")
    private WebElement delete;

    @FindBy(xpath = "//*[@id=\"center_column\"]/p[2]/a[1]/span")
    private WebElement checkout;

    @FindBy(css = "#center_column > form > p > button > span")
    private WebElement goFurther;

    @FindBy(xpath = "//a[@Title='Close']")
    private WebElement cross;

    @FindBy(id = "uniform-cgv")
    private WebElement agreement;

    @FindBy(name = "processCarrier")
    private  WebElement buttonClickSpan;

    @FindBy(xpath = "//a[@class='bankwire']")
    private WebElement payByBank;

    @FindBy(xpath = "//button[@class='button btn btn-default button-medium']")
    private  WebElement myOrder;

    @FindBy(css = "#form > p > button > span")
    private WebElement checkoutButton;

    @FindBy(xpath = "//a[@class='cheque']")
    private WebElement payByCheck;



    public void selectACategory() {selectACategory.click();}
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
