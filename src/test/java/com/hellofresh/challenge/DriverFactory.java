package com.hellofresh.challenge;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
    private DriverFactory() {

    }

    private static DriverFactory instance = new DriverFactory();

    public static DriverFactory getInstance() {
        return instance;
    }

    private ThreadLocal<WebDriver> chromeDriver = new ThreadLocal<WebDriver>() {
        @Override
        protected WebDriver initialValue() {
            System.setProperty("webdriver.chrome.driver",
                    "src/test/resources/chromedriver");
            return new ChromeDriver();
        }
    };

    private ThreadLocal<WebDriver> firefoxDriver = new ThreadLocal<WebDriver>() {
        @Override
        protected WebDriver initialValue() {
            System.setProperty("webdriver.gecko.driver",
                    "src/test/resources/geckodriver");
            return new FirefoxDriver();
        }
    };



    public WebDriver getDriver(Driver driver) {
        if (driver == Driver.CHROMEDRIVER) {
            return chromeDriver.get();
        } else if (driver == Driver.FIREFOXDRIVER) {
            return firefoxDriver.get();
        } else {
            throw new IllegalArgumentException("Unknown Driver");
        }
    }

    void removeDriver(Driver driver) {
        if (driver == Driver.CHROMEDRIVER) {
            chromeDriver.get().close();
            chromeDriver.remove();
        } else if (driver == Driver.FIREFOXDRIVER) {
            firefoxDriver.get().close();
            firefoxDriver.remove();
        } else {
            throw new IllegalArgumentException("Unknown Driver");
        }
    }
}
