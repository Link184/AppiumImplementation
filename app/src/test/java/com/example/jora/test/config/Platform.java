package com.example.jora.test.config;

public enum Platform {
    ANDROID("Android"),
    IOS("iOS"),
    FIREFOX("FirefoxOS");

    private String platformName;
    Platform(String platformName) {
        this.platformName = platformName;
    }

    String getPlatformName() {
        return platformName;
    }
}
