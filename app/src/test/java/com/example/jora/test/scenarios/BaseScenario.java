package com.example.jora.test.scenarios;

import com.example.jora.test.config.AppiumWrapper;

import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;
import java.net.URL;

import javax.annotation.Nullable;

/**
 * Base abstract scenario. Intermediate scenario layer, compatible with all platforms.
 */
public abstract class BaseScenario implements Scenario {
    /**
     * Useful class which provide easy access to all Appium capabilities.
     */
    protected AppiumWrapper appiumWrapper;

    public BaseScenario() {
        this.appiumWrapper = initWrapper();
    }

    @Override
    public WebDriver initDriver(@Nullable String remoteAddress) throws MalformedURLException {
        return appiumWrapper.buildDriver(new URL(remoteAddress));
    }
}
