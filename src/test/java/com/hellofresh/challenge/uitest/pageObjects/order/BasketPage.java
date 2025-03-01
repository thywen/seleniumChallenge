package com.hellofresh.challenge.uitest.pageObjects.order;

import com.hellofresh.challenge.uitest.pageObjects.PageWithTopMenu;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BasketPage extends PageWithTopMenu {
    public static String URL = "controller=order";

    @FindBy(xpath = "//*[contains(@class,'cart_navigation')]/a[@title='Proceed to checkout']")
    private WebElement proceedToCheckoutButton;


    public BasketPage(WebDriver driver) {
        super(driver, URL);
    }

    public DeliveryAddressPage continueToAddressPage() {
        saveClick(proceedToCheckoutButton);
        return andReturn(DeliveryAddressPage.class);
    }
}
