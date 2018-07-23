package com.hellofresh.challenge.pageObjects;

import org.openqa.selenium.WebDriver;

public class StoreHomePage extends PageWithHeader {
    private static String URL = "index.php";

    public StoreHomePage(WebDriver driver) {
        super(driver, URL);
    }

}
