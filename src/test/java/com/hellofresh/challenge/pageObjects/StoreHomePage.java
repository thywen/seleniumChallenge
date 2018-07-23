package com.hellofresh.challenge.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class StoreHomePage extends BasePage {
    private static String URL = "index.php";

    @FindBy(css = "a.login")
    private WebElement loginLink;

    public StoreHomePage(WebDriver driver) {
        super(driver, URL);
    }

    public LoginPage openLoginPage() {
        loginLink.click();
        return (LoginPage) andReturn(LoginPage.class, driver);
    }

}
