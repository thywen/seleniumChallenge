package com.hellofresh.challenge.driver;

import org.openqa.selenium.WebDriver;

public interface DriverFactory {
    WebDriver getDriver();
    void removeDriver();
}
