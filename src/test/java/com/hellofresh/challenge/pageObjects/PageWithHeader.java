package com.hellofresh.challenge.pageObjects;

import com.hellofresh.challenge.pageObjects.user.LoginPage;
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
        loginLink.click();
        return andReturn(LoginPage.class);
    }


}
