package com.hellofresh.challenge;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {
    private DriverFactory() {

    }

    private static DriverFactory instance = new DriverFactory();

    static DriverFactory getInstance() {
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


    WebDriver getChromeDriver() {
        return chromeDriver.get();
    }

    void removeChromeDriver() {
        chromeDriver.get().close();
        chromeDriver.remove();
    }
}
