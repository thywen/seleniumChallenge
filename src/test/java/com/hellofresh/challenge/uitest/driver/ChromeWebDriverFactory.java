package com.hellofresh.challenge.uitest.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeWebDriverFactory implements DriverFactory {
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
            System.setProperty("webdriver.chrome.driver",
                    "src/test/resources/chromedriver");
            return new ChromeDriver();
        }
    };
}
