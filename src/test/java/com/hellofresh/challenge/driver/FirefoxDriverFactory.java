package com.hellofresh.challenge.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxDriverFactory implements DriverFactory {

    public WebDriver getDriver() {
        return driver.get();
    }

    public void removeDriver() {
        driver.get().close();
        driver.remove();
    }

    private ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>() {
        @Override
        protected WebDriver initialValue() {
            System.setProperty("webdriver.gecko.driver",
                    "src/test/resources/geckodriver");
            return new FirefoxDriver();
        }
    };
}
