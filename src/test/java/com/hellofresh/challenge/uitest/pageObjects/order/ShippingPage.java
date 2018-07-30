package com.hellofresh.challenge.uitest.pageObjects.order;

import com.hellofresh.challenge.uitest.pageObjects.PageWithTopMenu;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShippingPage extends PageWithTopMenu {
    private static String URL = "controller=order";

    public ShippingPage(WebDriver driver) {
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
        return andReturn(PaymentSelectionPage.class);
    }
}
