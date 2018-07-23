package com.hellofresh.challenge.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    WebDriver driver;

    BasePage(WebDriver driver) {
        this.driver = driver;
    }

    BasePage andReturn(Class<?> pageObject, WebDriver driver) {
        return (BasePage) PageFactory.initElements(driver, pageObject);
    }
}
