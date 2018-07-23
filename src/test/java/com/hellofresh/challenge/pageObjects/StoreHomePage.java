package com.hellofresh.challenge.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class StoreHomePage extends PageWithHeader {
    private static String URL = "index.php";

    public StoreHomePage(WebDriver driver) {
        super(driver, URL);
    }

}
