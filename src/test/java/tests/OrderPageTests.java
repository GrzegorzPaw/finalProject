package tests;

import org.junit.jupiter.api.AfterEach;
import pages.LoginPage;
import pages.OrderPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;


public class OrderPageTests extends BaseTest {

    OrderPage orderPage = new OrderPage(driver);
    LoginPage loginPage = new LoginPage(driver);
    private static final String EXISTING_USERNAME_LOGIN = "maniek1@man.wp.pl";
    private static final String EXISTING_USERNAME_PASSWORD = "1234567";

    @Test
    void shouldAddProductsToTheCart() {
        orderPage.selectACategory();
        orderPage.productSelection();
        orderPage.submit();
        orderPage.closeWindow();
        orderPage.shoppingCartSummary();
        Assertions.assertEquals("Your shopping cart contains: 1 Product", driver.findElement(By.xpath("//*[@id=\"cart_title\"]/span")).getText(), "An identical item was not found");

    }

    @AfterEach
    void clearCookies() {
        driver.manage().deleteAllCookies();
    }


    @Test
    void shouldNotContainTheQuantityWithoutAddingTheProduct() {
        orderPage.selectACategory();
        orderPage.shoppingCartSummary();
        Assertions.assertEquals("Your shopping cart is empty.", driver.findElement(By.xpath("//*[@id=\"center_column\"]/p")).getText(), "An identical item was not found");
    }

    @Test
    void shouldAddAndRemoveAProductFromTheCart() {
        orderPage.selectACategory();
        orderPage.productSelection();
        orderPage.submit();
        orderPage.closeWindow();
        orderPage.shoppingCartSummary();
        Assertions.assertEquals("Your shopping cart contains: 1 Product", driver.findElement(By.xpath("//*[@id=\"cart_title\"]/span")).getText(), "An identical item was not found");
        orderPage.delete();
        Assertions.assertTrue(driver.getCurrentUrl().contains("controller=order"), "The product could not be removed from the cart");
    }

    @Test
    void shouldMakeThePurchaseByBankTransfer() {

        orderPage.selectACategory();
        orderPage.productSelection();
        orderPage.submit();
        orderPage.closeWindow();
        orderPage.shoppingCartSummary();
        Assertions.assertEquals("Your shopping cart contains: 1 Product", driver.findElement(By.xpath("//*[@id=\"cart_title\"]/span")).getText(), "An identical item was not found");
        orderPage.proceedToCheckout();
        loginPage.login(EXISTING_USERNAME_LOGIN, EXISTING_USERNAME_PASSWORD);
        Assertions.assertTrue(driver.getCurrentUrl().contains("controller=order&step=1&multi-shipping=0"), "login incorrect");
        orderPage.goFuther();
        Assertions.assertTrue(driver.getCurrentUrl().contains("controller=order"), "operation failed");
        orderPage.ProceedToCheckoutButton();
        orderPage.pressTheCross();
        orderPage.clickConsent();
        orderPage.clickSpan();
        Assertions.assertTrue(driver.getCurrentUrl().contains("controller=order&multi-shipping="), "operation failed");
        orderPage.payByBankWire();
        orderPage.IConfirmMyOrder();
        Assertions.assertEquals("Your order on My Store is complete.", driver.findElement(By.xpath("//*[@id=\"center_column\"]/div/p/strong")).getText(), "An identical item was not found");
        loginPage.clickSignOutButton();
        Assertions.assertTrue(driver.getCurrentUrl().contains("controller=authentication&back=history"), "operation failed");


    }

    @Test
    void shouldMakeThePurchaseByCheck() {

        orderPage.selectACategory();
        orderPage.productSelection();
        orderPage.submit();
        orderPage.closeWindow();
        orderPage.shoppingCartSummary();
        Assertions.assertEquals("Your shopping cart contains: 1 Product", driver.findElement(By.xpath("//*[@id=\"cart_title\"]/span")).getText(), "An identical item was not found");
        orderPage.proceedToCheckout();
        loginPage.login(EXISTING_USERNAME_LOGIN, EXISTING_USERNAME_PASSWORD);
        Assertions.assertTrue(driver.getCurrentUrl().contains("controller=order&step=1&multi-shipping=0"), "login incorrect");
        orderPage.goFuther();
        Assertions.assertTrue(driver.getCurrentUrl().contains("controller=order"), "operation failed");
        orderPage.ProceedToCheckoutButton();
        orderPage.pressTheCross();
        orderPage.clickConsent();
        orderPage.clickSpan();
        Assertions.assertTrue(driver.getCurrentUrl().contains("controller=order&multi-shipping="), "operation failed");
        orderPage.payByCheck();
        orderPage.IConfirmMyOrder();
        Assertions.assertEquals("Your order on My Store is complete.", driver.findElement(By.xpath("//*[@id=\"center_column\"]/p[1]")).getText(), "An identical item was not found");
        loginPage.clickSignOutButton();
    }

}
