package com.hellofresh.challenge.pageObjects.order;

import com.hellofresh.challenge.pageObjects.PageWithTopMenu;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class DeliveryAddressPageObject extends PageWithTopMenu {
    public static String URL = "controller=order&step=1";

    @FindBy(name = "processAddress")
    private WebElement proceedToCheckoutButton;

    public DeliveryAddressPageObject(WebDriver driver) {
        super(driver, URL);
    }

    public ShippingPageObject goToShippingPage() {
        wait.until(visibilityOf(proceedToCheckoutButton)).click();
        return (ShippingPageObject) andReturn(ShippingPageObject.class);
    }

}
