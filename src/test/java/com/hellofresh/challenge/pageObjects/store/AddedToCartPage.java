package com.hellofresh.challenge.pageObjects.store;

import com.hellofresh.challenge.pageObjects.PageWithHeader;
import com.hellofresh.challenge.pageObjects.order.BasketPageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddedToCartPage extends PageWithHeader {
    private static String URL = "controller=product";

    @FindBy(xpath = "//*[@id='layer_cart']//a[@class and @title='Proceed to checkout']")
    private WebElement proceedToCheckoutButton;


    public AddedToCartPage(WebDriver driver) {
        super(driver, URL);
    }

    public BasketPageObject goToBasket() {
        return (BasketPageObject) andReturn(BasketPageObject.class, driver);
    }

}
