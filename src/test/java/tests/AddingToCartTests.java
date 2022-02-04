package tests;

import pages.AddingToCart;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class AddingToCartTests extends BaseTest {

    AddingToCart addingToCart = new AddingToCart(driver);

    @Test
    void shouldAddProductsToTheCart() {
        addingToCart.selectACategory();
        addingToCart.productSelection();
        addingToCart.submit();
        addingToCart.closeWindow();
        addingToCart.shoppingCartSummary();
        Assertions.assertEquals("Your shopping cart contains: 1 Product", driver.findElement(By.xpath("//*[@id=\"cart_title\"]/span")).getText(), "An identical item was not found");

    }

    @AfterEach
    void clearCookies() {
        driver.manage().deleteAllCookies();
    }


    @Test
    void shouldNotContainTheQuantityWithoutAddingTheProduct() {
        addingToCart.selectACategory();
        addingToCart.shoppingCartSummary();
        Assertions.assertEquals("Your shopping cart is empty.", driver.findElement(By.xpath("//*[@id=\"center_column\"]/p")).getText(), "An identical item was not found");
    }

    @Test
    void shouldAddAndRemoveAProductFromTheCart() {
        addingToCart.selectACategory();
        addingToCart.productSelection();
        addingToCart.submit();
        addingToCart.closeWindow();
        addingToCart.shoppingCartSummary();
        Assertions.assertEquals("Your shopping cart contains: 1 Product", driver.findElement(By.xpath("//*[@id=\"cart_title\"]/span")).getText(), "An identical item was not found");
        addingToCart.delete();
        Assertions.assertTrue(driver.getCurrentUrl().contains("controller=order"), "The product could not be removed from the cart");
    }
}



