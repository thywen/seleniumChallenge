package com.hellofresh.challenge.pageObjects.user;

import com.hellofresh.challenge.pageObjects.PageWithTopMenu;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserProfilePage extends PageWithTopMenu {
    private static String URL = "controller=my-account";

    @FindBy(css = "h1")
    private WebElement heading;

    @FindBy(className = "account")
    private WebElement accountName;

    @FindBy(className = "info-account")
    private WebElement welcomeText;

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
