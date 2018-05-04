package com.example.jora.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.android.AndroidDriver;

/**
 * Created by I on 3/16/2018.
 */

public class SetupDesiredCapabilities {

    private String activity;

    public WebDriver getDriver() {
        return driver;
    }

   // private WebDriver driver;
    private AndroidDriver driver;

    public SetupDesiredCapabilities(String activity) throws MalformedURLException {
        this.activity = activity;
        //location of the app
        File app = new File("/home/jora/StudioProjects/Test/app/build/outputs/apk/debug",
                "app-debug.apk");

        // Created object of DesiredCapabilities class.
        DesiredCapabilities capabilities = new DesiredCapabilities();

//        capabilities.setCapability("device","Android");

        capabilities.setCapability("app", app.getAbsolutePath());

        // Set android deviceName desired capability. Set your device name.
        capabilities.setCapability("deviceName", "Pixel XL");

        // Set BROWSER_NAME desired capability. It's Android in our case here.
        capabilities.setCapability(CapabilityType.BROWSER_NAME, "Android");

        // Set android VERSION desired capability. Set your mobile device's OS version.
        capabilities.setCapability(CapabilityType.VERSION, "7.1.1");

        // Set android platformName desired capability. It's Android in our case here.
        capabilities.setCapability("platformName", "Android");

        // Set android appPackage desired capability. It is
        // com.android.calculator2 for calculator application.
        // Set your application's appPackage if you are using any other app.
        capabilities.setCapability("appPackage", "com.example.jora.test");

//
        // Set android appActivity desired capability. It is
        // com.android.calculator2.Calculator for calculator application.
        // Set your application's appPackage if you are using any other app.
        capabilities.setCapability("appActivity", "com.example.jora.test.MainActivity");
        // capabilities.setCapability("appActivity", "com.muume.ui.activity.LoginActivity");

        // Created object of RemoteWebDriver will all set capabilities.
        // Set appium server address and port number in URL string.
        // It will launch calculator app in android device.
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

}



