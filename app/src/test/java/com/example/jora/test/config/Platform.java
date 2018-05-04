package com.example.jora.test.config;

public enum Platform {
    ANDROID("Android"),
    IOS("iOS"),
    FIREFOX("FirefoxOS");

    private String plantformName;
    Platform(String platformName) {
        this.plantformName = platformName;
    }

    String getPlantformName() {
        return plantformName;
    }
}
