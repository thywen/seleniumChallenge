package com.hellofresh.challenge.uitest.pageObjects.store;

import com.hellofresh.challenge.uitest.pageObjects.PageWithTopMenu;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailPage extends PageWithTopMenu {
    private static String URL = "controller=product";

    @FindBy(css = "p#add_to_cart button")
    private WebElement addToCartButton;

    public ProductDetailPage(WebDriver driver) {
        super(driver, URL);
    }

    public AddedToCartPage addItemToCart() {
        addToCartButton.click();
        return andReturn(AddedToCartPage.class);
    }
}
