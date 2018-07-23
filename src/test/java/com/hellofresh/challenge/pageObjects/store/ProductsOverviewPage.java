package com.hellofresh.challenge.pageObjects.store;

import com.hellofresh.challenge.pageObjects.PageWithTopMenu;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsOverviewPage extends PageWithTopMenu {
    private static String URL = "controller=category";

    public ProductsOverviewPage(WebDriver driver) {
        super(driver, URL);
    }

    public void selectItem(String itemtitle) {
        driver.findElement(By.xpath(buildXpathForItem(itemtitle))).click();
    }

    public ProductDetailPage openItem(String itemtitle) {
        driver.findElement(By.xpath(buildXpathForItem(itemtitle))).click();
        return (ProductDetailPage) andReturn(ProductDetailPage.class, driver);
    }

    private String buildXpathForItem(String itemtitle) {
        return String.format("//a[@title='%s']/ancestor::li", itemtitle);
    }

}
