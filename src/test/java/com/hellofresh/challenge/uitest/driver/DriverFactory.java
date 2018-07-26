package com.hellofresh.challenge.uitest.driver;

import org.openqa.selenium.WebDriver;

public interface DriverFactory {
    WebDriver getDriver();
    void removeDriver();
}
