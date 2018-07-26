package com.hellofresh.challenge.uitest.driver;

import org.openqa.selenium.WebDriver;

public class DriverService {
    private ChromeWebDriverFactory chromeWebDriverFactory;
    private FirefoxDriverFactory firefoxDriverFactory;
    private DriverService() {
        chromeWebDriverFactory = new ChromeWebDriverFactory();
        firefoxDriverFactory = new FirefoxDriverFactory();
    }

    private static DriverService instance = new DriverService();

    public static DriverService getInstance() {
        return instance;
    }

    public WebDriver getDriver(Driver driver) {
        if (driver == Driver.CHROMEDRIVER) {
            return chromeWebDriverFactory.getDriver();
        } else if (driver == Driver.FIREFOXDRIVER) {
            return firefoxDriverFactory.getDriver();
        } else {
            throw new IllegalArgumentException("Unknown Driver");
        }
    }

    public void removeDriver(Driver driver) {
        if (driver == Driver.CHROMEDRIVER) {
            chromeWebDriverFactory.removeDriver();
        } else if (driver == Driver.FIREFOXDRIVER) {
            firefoxDriverFactory.removeDriver();
        } else {
            throw new IllegalArgumentException("Unknown Driver");
        }
    }
}
