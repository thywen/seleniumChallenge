package com.hellofresh.challenge.uitest.pageObjects;

import com.hellofresh.challenge.uitest.pageObjects.user.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public abstract class PageWithHeader extends BasePage {

    @FindBy(css = "a.login")
    private WebElement loginLink;

    @FindBy(className = "logout")
    protected WebElement logoutButton;

    protected PageWithHeader(WebDriver driver, String url) {
        super(driver, url);
    }

    public LoginPage openLoginPage() {
        saveClick(loginLink);
        return andReturn(LoginPage.class);
    }


}
