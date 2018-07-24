package com.hellofresh.challenge.pageObjects.order;

import com.hellofresh.challenge.pageObjects.PageWithTopMenu;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class BasketPage extends PageWithTopMenu {
    public static String URL = "controller=order";

    @FindBy(xpath = "//*[contains(@class,'cart_navigation')]/a[@title='Proceed to checkout']")
    private WebElement proceedToCheckoutButton;


    public BasketPage(WebDriver driver) {
        super(driver, URL);
    }

    public DeliveryAddressPage continueToAddressPage() {
        wait.until(visibilityOf(proceedToCheckoutButton)).click();
        return (DeliveryAddressPage) andReturn(DeliveryAddressPage.class);
    }
}
