package com.example.jora.test.config;

public enum Browser {
    SAFARI,
    CHROMIUM,
    CHROME,
    BROWSER;

    String getBrowserName() {
        return name().toLowerCase();
    }
}
