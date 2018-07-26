package com.hellofresh.challenge.uitest.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

abstract class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;
    private String url;

    BasePage(WebDriver driver, String url) {
        this.driver = driver;
        this.url = url;
        this.wait =  new WebDriverWait(driver, 10, 50);
    }

    protected <T extends BasePage> T andReturn(Class<T> pageObject) {
        return PageFactory.initElements(driver, pageObject);
    }

    protected void saveClick(WebElement element) {
        wait.until(visibilityOf(element)).click();
    }

    public boolean isCorrectUrl() {
        return driver.getCurrentUrl().contains(url);
    }
}
