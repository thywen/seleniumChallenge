package com.hellofresh.challenge.uitest.pageObjects.store;

import com.hellofresh.challenge.uitest.pageObjects.PageWithHeader;
import com.hellofresh.challenge.uitest.pageObjects.order.BasketPage;
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

    public BasketPage goToBasket() {
        saveClick(proceedToCheckoutButton);
        return andReturn(BasketPage.class);
    }

}
