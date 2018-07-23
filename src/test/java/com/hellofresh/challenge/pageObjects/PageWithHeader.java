package com.hellofresh.challenge.pageObjects;

import com.hellofresh.challenge.models.Category;
import com.hellofresh.challenge.pageObjects.store.ProductsOverviewPage;
import com.hellofresh.challenge.pageObjects.user.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public abstract class PageWithHeader extends BasePage {

    @FindBy(linkText = "Women")
    private WebElement womenLink;

    @FindBy(css = "a.login")
    private WebElement loginLink;

    @FindBy(className = "logout")
    protected WebElement logoutButton;

    protected PageWithHeader(WebDriver driver, String url) {
        super(driver, url);
    }

    public LoginPage openLoginPage() {
        loginLink.click();
        return (LoginPage) andReturn(LoginPage.class, driver);
    }

    public ProductsOverviewPage selectCategory(Category category) {
        switch (category) {
            case WOMAN:
                womenLink.click();
            default:
                return (ProductsOverviewPage) andReturn(ProductsOverviewPage.class, driver);
        }
    }
}
