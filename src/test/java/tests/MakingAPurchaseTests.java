package tests;

import base.BaseTest;
import navigation.AddingToCart;
import navigation.LoginPage;
import navigation.MakingAPurchase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;


public class MakingAPurchaseTests extends BaseTest {

    MakingAPurchase makingAPurchase = new MakingAPurchase(driver);
    LoginPage loginPage = new LoginPage(driver);
    private static final String EXISTING_USERNAME_LOGIN = "maniek1@man.wp.pl";
    private static final String EXISTING_USERNAME_PASSWORD = "1234567";

    @Test
    void shouldMakeThePurchaseByBankTransfer() {

        makingAPurchase.selectACategory();
        makingAPurchase.productSelection();
        makingAPurchase.submit();
        makingAPurchase.closeWindow();
        makingAPurchase.shoppingCartSummary();
        Assertions.assertEquals("Your shopping cart contains: 1 Product", driver.findElement(By.xpath("//*[@id=\"cart_title\"]/span")).getText(), "An identical item was not found");
        driver.findElement(By.xpath("//*[@id=\"center_column\"]/p[2]/a[1]/span")).click();
        loginPage.login(EXISTING_USERNAME_LOGIN, EXISTING_USERNAME_PASSWORD);

        driver.findElement(By.id("SubmitLogin")).click();
        Assertions.assertTrue(driver.getCurrentUrl().contains("controller=order&step=1&multi-shipping=0"), "login incorrect");
        driver.findElement(By.cssSelector("#center_column > form > p > button > span")).click();
        Assertions.assertTrue(driver.getCurrentUrl().contains("controller=order"), "operation failed");
        driver.findElement(By.cssSelector("#form > p > button > span")).click();
        driver.findElement(By.xpath("//*[@id=\"order\"]/div[2]/div/div/a")).click();
        driver.findElement(By.id("uniform-cgv")).click();
        driver.findElement(By.xpath("//*[@id=\"form\"]/p/button/span")).click();
        Assertions.assertTrue(driver.getCurrentUrl().contains("controller=order&multi-shipping="), "operation failed");
        driver.findElement(By.xpath("//*[@id=\"HOOK_PAYMENT\"]/div[1]/div/p/a")).click();
        driver.findElement(By.xpath("//*[@id=\"cart_navigation\"]/button/span")).click();
        Assertions.assertEquals("Your order on My Store is complete.", driver.findElement(By.xpath("//*[@id=\"center_column\"]/div/p/strong")).getText(), "An identical item was not found");
        driver.findElement(By.className("logout")).click();
        Assertions.assertTrue(driver.getCurrentUrl().contains("controller=authentication&back=history"), "operation failed");


    }

    @Test
    void shouldMakeThePurchaseByCheck() {

        makingAPurchase.selectACategory();
        makingAPurchase.productSelection();
        makingAPurchase.submit();
        makingAPurchase.closeWindow();
        makingAPurchase.shoppingCartSummary();
        Assertions.assertEquals("Your shopping cart contains: 1 Product", driver.findElement(By.xpath("//*[@id=\"cart_title\"]/span")).getText(), "An identical item was not found");
        driver.findElement(By.xpath("//*[@id=\"center_column\"]/p[2]/a[1]/span")).click();
        driver.findElement(By.id("email")).sendKeys("maniek1@man.wp.pl");
        driver.findElement(By.id("passwd")).sendKeys("1234567");
        driver.findElement(By.id("SubmitLogin")).click();
        Assertions.assertTrue(driver.getCurrentUrl().contains("controller=order&step=1&multi-shipping=0"), "login incorrect");
        driver.findElement(By.cssSelector("#center_column > form > p > button > span")).click();
        Assertions.assertTrue(driver.getCurrentUrl().contains("controller=order"), "operation failed");
        driver.findElement(By.cssSelector("#form > p > button > span")).click();
        driver.findElement(By.xpath("//*[@id=\"order\"]/div[2]/div/div/a")).click();
        driver.findElement(By.id("uniform-cgv")).click();
        driver.findElement(By.xpath("//*[@id=\"form\"]/p/button/span")).click();
        Assertions.assertTrue(driver.getCurrentUrl().contains("controller=order&multi-shipping="), "operation failed");
        driver.findElement(By.xpath("//*[@id=\"HOOK_PAYMENT\"]/div[2]/div/p/a")).click();
        driver.findElement(By.xpath("//*[@id=\"cart_navigation\"]/button/span")).click();
        Assertions.assertEquals("Your order on My Store is complete.", driver.findElement(By.xpath("//*[@id=\"center_column\"]/p[1]")).getText(), "An identical item was not found");
    }

}
