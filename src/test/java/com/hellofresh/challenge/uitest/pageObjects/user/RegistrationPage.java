package com.hellofresh.challenge.uitest.pageObjects.user;

import com.hellofresh.challenge.uitest.models.user.Address;
import com.hellofresh.challenge.uitest.models.user.Gender;
import com.hellofresh.challenge.uitest.pageObjects.PageWithTopMenu;
import org.joda.time.DateTime;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class RegistrationPage extends PageWithTopMenu{

    private static String URL = "my-account#account-creation";

    @FindBy(id = "id_gender1")
    private WebElement maleGenderButton;

    @FindBy(id = "id_gender2")
    private WebElement femaleGenderButton;

    @FindBy(id = "customer_firstname")
    private WebElement firstnameTextField;

    @FindBy(id = "customer_lastname")
    private WebElement lastnameTextField;

    @FindBy(id = "passwd")
    private WebElement passwordTextField;

    @FindBy(id = "days")
    private WebElement daySelector;

    @FindBy(id = "months")
    private WebElement monthSelector;

    @FindBy(id = "years")
    private WebElement yearsSelector;

    @FindBy(id = "company")
    private WebElement companyTextField;

    @FindBy(id = "address1")
    private WebElement address1TextField;

    @FindBy(id = "address2")
    private WebElement address2TextField;

    @FindBy(id = "city")
    private WebElement cityTextField;

    @FindBy(id = "id_state")
    private WebElement stateSelector;

    @FindBy(id = "postcode")
    private WebElement postcodeTextField;

    @FindBy(id = "other")
    private WebElement otherTextField;

    @FindBy(id = "phone")
    private WebElement phoneTextField;

    @FindBy(id = "phone_mobile")
    private WebElement mobilePhoneTextField;

    @FindBy(id = "alias")
    private WebElement aliasTextField;

    @FindBy(id = "submitAccount")
    private WebElement createAccountButton;

    public RegistrationPage(WebDriver driver) {
        super(driver, URL);
    }

    public RegistrationPage selectGender(Gender gender) {
        wait.until(visibilityOf(maleGenderButton));
        if (gender == Gender.MALE) {
            maleGenderButton.click();
        } else if (gender == Gender.FEMALE || gender == Gender.UNDEFINED) {
            femaleGenderButton.click();
        }
        return this;
    }

    public RegistrationPage enterName(String firstname, String lastname) {
        firstnameTextField.sendKeys(firstname);
        lastnameTextField.sendKeys(lastname);
        return this;
    }

    public RegistrationPage enterPassword(String password) {
        passwordTextField.sendKeys(password);
            return this;
    }

    public RegistrationPage selectBirthday(DateTime birthday) {
        Select yearSelect = new Select(yearsSelector);
        yearSelect.selectByValue(String.valueOf(birthday.getYear()));
        Select monthSelect = new Select(monthSelector);
        monthSelect.selectByValue(String.valueOf(birthday.getMonthOfYear()));
        Select daySelect = new Select(daySelector);
        daySelect.selectByValue(String.valueOf(birthday.getDayOfMonth()));
        return this;
    }

    public RegistrationPage enterAddress(Address address) {
        companyTextField.sendKeys(address.getCompany());
        address1TextField.sendKeys(address.getAddress1());
        address2TextField.sendKeys(address.getAddress2());
        cityTextField.sendKeys(address.getCity());
        Select select = new Select(stateSelector);
        select.selectByVisibleText(address.getState());
        postcodeTextField.sendKeys(address.getPostcode());
        otherTextField.sendKeys(address.getOther());
        phoneTextField.sendKeys(address.getPhone());
        mobilePhoneTextField.sendKeys(address.getMobilePhone());
        aliasTextField.sendKeys(address.getAddressAlias());
        return this;
    }

    public UserProfilePage confirmRegistration() {
        createAccountButton.click();
        return andReturn(UserProfilePage.class);
    }
}
