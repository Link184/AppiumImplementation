package com.example.jora.test.scenarios;

import com.example.jora.test.config.AppiumWrapper;
import com.example.jora.test.config.Device;
import com.example.jora.test.config.Platform;
import com.example.jora.test.config.Version;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class AndroidScenario {
    private final String defaultRemoteAddress = "http://127.0.0.1:4723/wd/hub";
    protected final AndroidDriver<AndroidElement> androidDriver;

    public AndroidScenario() throws MalformedURLException {
        this.androidDriver =
                new AppiumWrapper.Builder(Platform.ANDROID, Device.ANDROID, "com.example.jora.test")
                .setActivityName("com.example.jora.test.MainActivity")
                .setApplicationBinaryFile(new File("/home/jora/StudioProjects/Test/app/build/outputs/apk/debug",
                        "app-debug.apk"))
                .setVersion(Version.N_2)
                .buildDriver(new URL(defaultRemoteAddress));
    }

    public AndroidScenario(String remoteAddress) throws MalformedURLException {
        this.androidDriver =
                new AppiumWrapper.Builder(Platform.ANDROID, Device.ANDROID,"com.example.jora.test")
                .setActivityName("com.example.jora.test.MainActivity")
                .setApplicationBinaryFile(new File("/home/jora/StudioProjects/Test/app/build/outputs/apk/debug",
                        "app-debug.apk"))
                .setVersion(Version.N_2)
                .buildDriver(new URL(remoteAddress));
    }
}
