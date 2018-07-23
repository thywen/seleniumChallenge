package com.hellofresh.challenge.pageObjects.user;

import com.hellofresh.challenge.pageObjects.PageWithHeader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserProfilePage extends PageWithHeader {
    private static String URL = "controller=my-account";

    @FindBy(css = "h1")
    private WebElement heading;

    @FindBy(className = "account")
    private WebElement accountName;

    @FindBy(className = "info-account")
    private WebElement welcomeText;

    @FindBy(className = "logout")
    private WebElement logoutButton;

    public UserProfilePage(WebDriver driver) {
        super(driver, URL);
    }

    public String getHeading() {
        return heading.getText();
    }

    public String getAccountName() {
        return accountName.getText();
    }

    public String getWelcomeText() {
        return welcomeText.getText();
    }

    public boolean logoutVisible() {
        return logoutButton.isDisplayed();
    }
}
