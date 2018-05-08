package com.example.jora.test.scenarios;

import com.example.jora.test.config.AppiumWrapper;
import com.example.jora.test.config.Device;
import com.example.jora.test.config.Platform;
import com.example.jora.test.config.Version;

import java.io.File;
import java.net.MalformedURLException;

import javax.annotation.Nullable;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

/**
 * Lower level scenario. Compatible only with android devices.
 */
public abstract class AndroidScenario extends BaseScenario {
    private final String defaultRemoteAddress = "http://127.0.0.1:4723/wd/hub";
    protected final AndroidDriver<AndroidElement> driver;

    public AndroidScenario() throws MalformedURLException {
        this(null);
    }

    public AndroidScenario(@Nullable String remoteAddress) throws MalformedURLException {
        this.driver = (AndroidDriver<AndroidElement>) initDriver(remoteAddress != null
                ? remoteAddress
                : defaultRemoteAddress);
    }

    @Override
    public AppiumWrapper initWrapper() {
        return new AppiumWrapper.Builder(Platform.ANDROID, Device.ANDROID, "com.example.jora.test")
                .setActivityName("com.example.jora.test.MainActivity")
                .setApplicationBinaryFile(new File("/home/jora/StudioProjects/Test/app/build/outputs/apk/debug",
                        "app-debug.apk"))
                .setVersion(Version.N_2)
                .build();
    }
}
