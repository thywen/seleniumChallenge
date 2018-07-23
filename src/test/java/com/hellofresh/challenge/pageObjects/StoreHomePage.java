package com.hellofresh.challenge.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class StoreHomePage extends BasePage {
    @FindBy(css = "a.login")
    private WebElement loginLink;

    public StoreHomePage(WebDriver driver) {
        super(driver);
    }

    public LoginPage openLoginPage() {
        loginLink.click();
        return (LoginPage) andReturn(LoginPage.class, driver);
    }

}
