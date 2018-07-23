package com.hellofresh.challenge.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class StoreHomePage {
    @FindBy(css = "a.login")
    private WebElement loginLink;

    public void openLoginPage(){
        loginLink.click();
    }

}
