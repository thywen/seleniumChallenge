package com.hellofresh.challenge.uitest.pageObjects;

import com.hellofresh.challenge.uitest.models.Category;
import com.hellofresh.challenge.uitest.pageObjects.store.ProductsOverviewPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

abstract public class PageWithTopMenu extends PageWithHeader {

    @FindBy(linkText = "Women")
    private WebElement womenLink;

    protected PageWithTopMenu(WebDriver driver, String url) {
        super(driver, url);
    }


    public ProductsOverviewPage selectCategory(Category category) {
        switch (category) {
            case WOMAN:
                womenLink.click();
            default:
                return andReturn(ProductsOverviewPage.class);
        }
    }
}
