package com.hellofresh.challenge.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

abstract class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;
    private String url;

    BasePage(WebDriver driver, String url) {
        this.driver = driver;
        this.url = url;
        this.wait =  new WebDriverWait(driver, 10, 50);
    }

    protected BasePage andReturn(Class<?> pageObject, WebDriver driver) {
        return (BasePage) PageFactory.initElements(driver, pageObject);
    }

    public boolean isCorrectUrl() {
        return driver.getCurrentUrl().contains(url);
    }
}
