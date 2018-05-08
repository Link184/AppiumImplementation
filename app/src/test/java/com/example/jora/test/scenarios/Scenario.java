package com.example.jora.test.scenarios;

import com.example.jora.test.config.AppiumWrapper;

import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;

import javax.annotation.Nullable;

/**
 * Top level scenario layer.
 */
public interface Scenario {

    /**
     * Driver initialization. Can be easily get with {{@link AppiumWrapper}}.
     * @param remoteAddress nullable remote address. is the address of remotely/locally
     *                      started Appium server
     * @throws MalformedURLException in case which there are some problems with URL.
     */
    WebDriver initDriver(@Nullable  String remoteAddress) throws MalformedURLException;

    /**
     * AppiumWrapper initialization. Just give me a wrapper.
     */
    AppiumWrapper initWrapper();
}
