package com.hellofresh.challenge.pageObjects.order;

import com.hellofresh.challenge.pageObjects.PageWithTopMenu;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PaymentSelectionPage extends PageWithTopMenu {
    private static String URL = "controller=order";

    @FindBy(className = "bankwire")
    private WebElement bankwireButton;

    public PaymentSelectionPage(WebDriver driver) {
        super(driver, URL);
    }

    public OrderSummaryPage payByBankwire() {
        bankwireButton.click();
        return (OrderSummaryPage) andReturn(OrderSummaryPage.class);
    }
}
