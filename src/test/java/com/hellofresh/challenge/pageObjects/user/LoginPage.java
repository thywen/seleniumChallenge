package com.hellofresh.challenge.pageObjects.user;

import com.hellofresh.challenge.models.user.User;
import com.hellofresh.challenge.pageObjects.PageWithTopMenu;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageWithTopMenu {
    private static String URL = "controller=authentication";

    @FindBy(id = "email")
    private WebElement emailField;

    @FindBy(id = "passwd")
    private WebElement passwordField;

    @FindBy(id = "SubmitLogin")
    private WebElement loginButton;

    @FindBy(id = "email_create")
    private WebElement createNewAccountEmail;

    @FindBy(id = "SubmitCreate")
    private WebElement createNewAccountButton;

    public LoginPage(WebDriver driver) {
        super(driver, URL);
    }

    public UserProfilePage logInUser(User user) {
        emailField.sendKeys(user.getEmail());
        passwordField.sendKeys(user.getPassword());
        loginButton.click();
        return andReturn(UserProfilePage.class);
    }

    public RegistrationPage createUserWith(String email) {
        createNewAccountEmail.sendKeys(email);
        createNewAccountButton.click();
        return andReturn(RegistrationPage.class);
    }
}
