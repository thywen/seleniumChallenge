package com.hellofresh.challenge.pageObjects.order;

import com.hellofresh.challenge.pageObjects.PageWithTopMenu;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShippingPageObject extends PageWithTopMenu{
    private static String URL = "controller=order";

    public ShippingPageObject(WebDriver driver) {
        super(driver, URL);
    }

    @FindBy(id = "uniform-cgv")
    private WebElement termsAndConditionBox;

    @FindBy(name = "processCarrier")
    private WebElement processToPaymentButton;

    public void acceptTermsAndConditions() {
        termsAndConditionBox.click();
    }

    public PaymentSelectionPage processToPayment() {
        processToPaymentButton.click();
        return (PaymentSelectionPage) andReturn(PaymentSelectionPage.class);
    }
}
