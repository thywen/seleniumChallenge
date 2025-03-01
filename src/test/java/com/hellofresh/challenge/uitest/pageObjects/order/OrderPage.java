package com.hellofresh.challenge.uitest.pageObjects.order;

import com.hellofresh.challenge.uitest.pageObjects.PageWithTopMenu;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

abstract class OrderPage extends PageWithTopMenu {

    @FindBy(xpath = "//li[@class='step_done step_done_last four']")
    private WebElement shippingTab;

    OrderPage(WebDriver driver, String url) {
        super(driver, url);
    }

    public boolean shippingTabVisible() {
        return shippingTab.isDisplayed();
    }
}
