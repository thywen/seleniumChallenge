package com.hellofresh.challenge.pageObjects.order;

import com.hellofresh.challenge.pageObjects.PageWithTopMenu;
import org.openqa.selenium.WebDriver;

public class OrderConfirmationScreen extends PageWithTopMenu {
    private static String URL = "controller=payment";

    public OrderConfirmationScreen(WebDriver driver) {
        super(driver, URL);
    }


}
