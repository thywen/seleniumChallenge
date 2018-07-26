package com.hellofresh.challenge.uitest.pageObjects.order;

import com.hellofresh.challenge.uitest.pageObjects.PageWithTopMenu;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderSummaryPage extends PageWithTopMenu {
    private static String URL = "controller=payment";

    @FindBy(xpath = "//*[@id='cart_navigation']/button")
    private WebElement confirmOrderButton;

    public OrderSummaryPage(WebDriver driver) {
        super(driver, URL);
    }

    public OrderConfirmationPage confirmOrder() {
        confirmOrderButton.click();
        return andReturn(OrderConfirmationPage.class);
    }
}
