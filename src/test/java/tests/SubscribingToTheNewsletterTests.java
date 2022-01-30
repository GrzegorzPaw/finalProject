package tests;

import base.BaseTest;
import com.github.javafaker.Faker;
import navigation.SubscribingToTheNewsletter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;


public class SubscribingToTheNewsletterTests extends BaseTest  {


    SubscribingToTheNewsletter subscribingToTheNewsletter = new SubscribingToTheNewsletter(driver);

    @Test
    void shouldSubscribeToTheNewsletterCorrectly() {
        Faker faker = new Faker();
        String uniqueEmail = faker.name().firstName() + faker.name().lastName() + faker.random().nextInt(1000) + "@gamil.com";
        driver.findElement(By.id("newsletter-input")).click();
        driver.findElement(By.id("newsletter-input")).sendKeys(uniqueEmail);
        driver.findElement(By.name("submitNewsletter")).click();
        Assertions.assertEquals("Newsletter : You have successfully subscribed to this newsletter.", driver.findElement(By.xpath("//*[@id=\"columns\"]/p")).getText(),"An identical item was not found");

    }

    @Test
    void shouldNotSubscribeToTheNewsletterByProvidingAnEmailAddressAlreadyRegistered() {

        driver.findElement(By.id("newsletter-input")).click();
        driver.findElement(By.id("newsletter-input")).sendKeys("maniek1@wp.pl");
        driver.findElement(By.name("submitNewsletter")).click();
        Assertions.assertEquals("Newsletter : This email address is already registered.", driver.findElement(By.xpath("//*[@id=\"columns\"]/p")).getText(),"An identical item was not found");

    }

    @Test
    void shouldNotSubscribeToTheNewsletterWithoutProvidingAnEmailAddress() {

        driver.findElement(By.name("submitNewsletter")).click();
        Assertions.assertEquals("Newsletter : Invalid email address.", driver.findElement(By.xpath("//*[@id=\"columns\"]/p")).getText(),"An identical item was not found");
    }

}
