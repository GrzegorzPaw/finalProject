package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

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

    @FindBy(id = "id_gender2")
    private WebElement gender;

    @FindBy(id = "customer_firstname")
    private WebElement firstNameInput;

    @FindBy(id = "customer_lastname")
    private WebElement lastNameInput;

    @FindBy(id = "passwd")
    private WebElement yourPasswordInput;

    @FindBy(id = "days")
    private WebElement daysOfBirth;

    @FindBy(id = "months")
    private WebElement monthOfBirthInput;

    @FindBy(id = "years")
    private WebElement yearOfBirthInput;

    @FindBy(id = "newsletter")
    private WebElement newsletterButton;

    @FindBy(id = "company")
    private WebElement companyInput;

    @FindBy(id = "address1")
    private WebElement addressInput;

    @FindBy(id = "city")
    private WebElement cityInput;

    @FindBy(id = "postcode")
    private WebElement postcodeInput;

    @FindBy(id = "phone_mobile")
    private WebElement phoneInput;

    @FindBy(id = "id_state")
    private WebElement stateValue;

    @FindBy(id = "alias")
    private WebElement addressAlias;

    @FindBy(id = "submitAccount")
    private WebElement accountButton;


    public void fillCreateAccountField(String username) {

        yourEmail.sendKeys(username);
    }

    public void submitCreateButton() {
        System.out.println(driver.getCurrentUrl());
        submitCreateButton.click();
    }

    public void chooseGender() {
        gender.click();
    }

    public void enterYourFirstAndLastName(String firstName, String lastName) {
        enterYourDetails(firstName, lastName);
    }

    private void enterYourDetails(String firstName, String lastName) {
        lastNameInput.sendKeys(lastName);
        firstNameInput.sendKeys(firstName);
    }

    public void enterYourPassword(String yourPassword) {
        yourPasswordInput.sendKeys(yourPassword);
    }

    public void newsletterButtonClick() {
        newsletterButton.click();
    }

    public void giveYourAddress(String company, String address, String city) {
        yourAddress(company, address, city);
    }

    private void yourAddress(String company, String address, String city) {
        companyInput.sendKeys(company);
        addressInput.sendKeys(address);
        cityInput.sendKeys(city);
    }

    public void yourPostcodeAndMobilePhone(String postcode, String phone) {
        yourPostcode(postcode, phone);
    }

    private void yourPostcode(String postcode, String phone) {
        postcodeInput.sendKeys(postcode);
        phoneInput.sendKeys(phone);
    }

    public void assignAnAddressAlias(String alias) {
        yourAddressAlias(alias);
    }

    public void yourAddressAlias(String alias) {
        System.out.println(driver.getCurrentUrl());
        addressAlias.clear();
        addressAlias.sendKeys(alias);
    }

    public void submitAccountButton() {
        accountButton.click();
    }

    public void state() {
        Select state = new Select(stateValue);
        state.selectByValue("1");
    }

    public void dateOfBirth() {
        Select day = new Select(daysOfBirth);
        day.selectByValue("2");
        Select month = new Select(monthOfBirthInput);
        month.selectByValue("4");
        Select year = new Select(yearOfBirthInput);
        year.selectByValue("1982");

    }

    public String authenticationAlertRegistration() {
        return driver.findElement(By.xpath("//*[@id=\"center_column\"]/div/ol/li[1]")).getText();
    }
    public String authentationAlertEmailAddress(){
        return driver.findElement(By.xpath("//*[@id=\"create_account_error\"]/ol/li")).getText();
    }
}

