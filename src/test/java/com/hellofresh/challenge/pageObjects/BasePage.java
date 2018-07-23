package com.hellofresh.challenge.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

abstract class BasePage {
    protected WebDriver driver;
    private String url;

    BasePage(WebDriver driver, String url) {
        this.driver = driver;
        this.url = url;
    }

    protected BasePage andReturn(Class<?> pageObject, WebDriver driver) {
        return (BasePage) PageFactory.initElements(driver, pageObject);
    }

    public boolean isCorrectUrl() {
        return driver.getCurrentUrl().endsWith(url);
    }
}
