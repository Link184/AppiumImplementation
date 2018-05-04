package com.example.jora.test.config;

import com.example.jora.test.config.exceptions.NoPlatformSpecified;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import javax.annotation.Nullable;

import io.appium.java_client.android.AndroidDriver;

public class AppiumWrapper {
    private static final String APP_KEY = "app";
    private static final String PLATFORM_KEY = "platformName";
    private static final String DEVICE_KEY = "deviceName";
    private static final String BROWSER_KEY = "browserName";
    private static final String VERSION_KEY = "version";
    private static final String PACKAGE_KEY = "appPackage";
    private static final String ACTIVITY_KEY = "appActivity";

    private final Map<String, Object> capabilities;
    private WebDriver driver;

    private AppiumWrapper() {
        capabilities = new HashMap<>();
    }

    @Nullable
    public Platform getPlatform() {
        return (Platform) capabilities.get(PLATFORM_KEY);
    }
    public static class Builder {
        private final AppiumWrapper appiumWrapper;

        public Builder(Platform platform, Device device, String packageName) {
            this.appiumWrapper = new AppiumWrapper();
            this.appiumWrapper.capabilities.put(PLATFORM_KEY, platform.getPlantformName());
            this.appiumWrapper.capabilities.put(DEVICE_KEY, device.getDeviceName());
            this.appiumWrapper.capabilities.put(PACKAGE_KEY, packageName);
        }

        public final Builder setApplicationBinaryFile(File file) {
            appiumWrapper.capabilities.put(APP_KEY, file);
            return this;
        }

//        public final Builder setDeviceName(String deviceName) {
//            appiumWrapper.deviceName = deviceName;
//            return this;
//        }

        public final Builder setVersion(Version version) {
            appiumWrapper.capabilities.put(VERSION_KEY, version.getVersionName());
            return this;
        }

        public final Builder setPlatform(Platform platform) {
            appiumWrapper.capabilities.put(PLATFORM_KEY, platform.getPlantformName());
            return this;
        }

        public final Builder setBrowser(Browser browser) {
            appiumWrapper.capabilities.put(BROWSER_KEY, browser.getBrowserName());
            return this;
        }

        public final Builder setActivityName(String activityName) {
            appiumWrapper.capabilities.put(ACTIVITY_KEY, activityName);
            return this;
        }

        @Nullable
        public final <D extends WebDriver> D buildDriver(URL url) {
            Platform platform = appiumWrapper.getPlatform();
            if (platform == null) {
                throw new NoPlatformSpecified();
            }
            switch (platform) {
                case ANDROID:
                    appiumWrapper.driver = new AndroidDriver(url, new DesiredCapabilities(appiumWrapper.capabilities));
                    appiumWrapper.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
                    return (D) appiumWrapper.driver;
                case IOS:
                    return null;
                case FIREFOX:
                    return null;
            }

            return null;
        }
    }
}
