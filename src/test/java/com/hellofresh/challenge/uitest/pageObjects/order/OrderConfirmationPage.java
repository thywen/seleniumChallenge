package com.hellofresh.challenge.uitest.pageObjects.order;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderConfirmationPage extends OrderPage {
    private static String URL = "controller=order-confirmation";

    @FindBy(css = "h1")
    private WebElement heading;

    @FindBy(xpath = "//li[@id='step_end' and @class='step_current last']")
    private WebElement paymentTabActive;

    @FindBy(xpath = "//*[@class='cheque-indent']/strong")
    private WebElement orderConfirmationText;


    public OrderConfirmationPage(WebDriver driver) {
        super(driver, URL);
    }

    public String getHeading() {
        return heading.getText();
    }

    public String getConfirmationText() {
        return orderConfirmationText.getText();
    }

    public boolean isPaymentStepActive() {
        return paymentTabActive.isDisplayed();
    }
}
