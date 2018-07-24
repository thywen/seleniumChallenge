package com.hellofresh.challenge.pageObjects.store;

import com.hellofresh.challenge.pageObjects.PageWithHeader;
import com.hellofresh.challenge.pageObjects.order.BasketPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class AddedToCartPage extends PageWithHeader {
    private static String URL = "controller=product";

    @FindBy(xpath = "//*[@id='layer_cart']//a[@class and @title='Proceed to checkout']")
    private WebElement proceedToCheckoutButton;


    public AddedToCartPage(WebDriver driver) {
        super(driver, URL);
    }

    public BasketPage goToBasket() {
        wait.until(visibilityOf(proceedToCheckoutButton)).click();
        return (BasketPage) andReturn(BasketPage.class);
    }

}
