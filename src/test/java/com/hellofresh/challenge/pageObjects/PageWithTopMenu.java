package com.hellofresh.challenge.pageObjects;

import org.openqa.selenium.WebDriver;

abstract public class PageWithTopMenu extends PageWithHeader {
    protected PageWithTopMenu(WebDriver driver, String url) {
        super(driver, url);
    }
}
