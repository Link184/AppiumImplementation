package com.example.jora.test.config;

import com.example.jora.test.config.exceptions.NoPlatformSpecified;
import com.example.jora.test.utils.EnumUtil;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import javax.annotation.Nullable;

import io.appium.java_client.android.AndroidDriver;

/**
 * A wrapper which provides a builder for a Appium driver.
 */
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
        return (Platform) EnumUtil.parseByValue(Platform.class, capabilities.get(PLATFORM_KEY), "platformName");
    }

    public String getPackageName() {
        return (String) capabilities.get(PACKAGE_KEY);
    }

    public Version getVersion() {
        return (Version) EnumUtil.parseByValue(Version.class, capabilities.get(VERSION_KEY), "versionName");
    }

    public Browser getBrowser() {
        return Browser.valueOf(capabilities.get(BROWSER_KEY).toString().toUpperCase());
    }

    @Nullable
    public final <D extends WebDriver> D buildDriver(URL url) {
        Platform platform = getPlatform();
        if (platform == null) {
            throw new NoPlatformSpecified();
        }
        switch (platform) {
            case ANDROID:
                driver = new AndroidDriver(url, new DesiredCapabilities(capabilities));
                driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
                return (D) driver;
            case IOS:
                return null;
            case FIREFOX:
                return null;
        }

        return null;
    }

    public static class Builder {
        private final AppiumWrapper appiumWrapper;

        /**
         * @param platform required field to pass platform to Appium api.
         * @param device required field to pass device to Appium api.
         * @param packageName required field to pass packageName to Appium api.
         */
        public Builder(Platform platform, Device device, String packageName) {
            this.appiumWrapper = new AppiumWrapper();
            this.appiumWrapper.capabilities.put(PLATFORM_KEY, platform.getPlatformName());
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
            appiumWrapper.capabilities.put(PLATFORM_KEY, platform.getPlatformName());
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

        public final AppiumWrapper build() {
            return appiumWrapper;
        }
    }
}
