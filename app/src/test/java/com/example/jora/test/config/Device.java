package com.example.jora.test.config;

public enum Device {
    ANDROID,
    IOS,
    WINDOWS;

    String getDeviceName() {
        return name().toLowerCase();
    }
}
