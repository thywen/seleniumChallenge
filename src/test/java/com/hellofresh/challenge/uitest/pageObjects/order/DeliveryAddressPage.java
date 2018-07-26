package com.hellofresh.challenge.uitest.pageObjects.order;

import com.hellofresh.challenge.uitest.pageObjects.PageWithTopMenu;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class DeliveryAddressPage extends PageWithTopMenu {
    public static String URL = "controller=order&step=1";

    @FindBy(name = "processAddress")
    private WebElement proceedToCheckoutButton;

    public DeliveryAddressPage(WebDriver driver) {
        super(driver, URL);
    }

    public ShippingPage goToShippingPage() {
        wait.until(visibilityOf(proceedToCheckoutButton)).click();
        return andReturn(ShippingPage.class);
    }

}
