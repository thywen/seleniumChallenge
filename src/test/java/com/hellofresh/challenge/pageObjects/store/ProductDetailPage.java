package com.hellofresh.challenge.pageObjects.store;

import com.hellofresh.challenge.pageObjects.PageWithHeader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailPage extends PageWithHeader{
    private static String URL = "controller=product";

    @FindBy(css = "p#add_to_cart button")
    private WebElement addToCartButton;

    public ProductDetailPage(WebDriver driver) {
        super(driver, URL);
    }


}
