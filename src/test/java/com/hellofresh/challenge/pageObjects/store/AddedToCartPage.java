package com.hellofresh.challenge.pageObjects.store;

import com.hellofresh.challenge.pageObjects.PageWithHeader;
import org.openqa.selenium.WebDriver;

public class AddedToCartPage extends PageWithHeader {
    private static String URL = "controller=product";


    public AddedToCartPage(WebDriver driver) {
        super(driver, URL);
    }

}
