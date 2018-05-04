package com.example.jora.test.config.exceptions;

public class NoPlatformSpecified extends RuntimeException {
    public NoPlatformSpecified() {
        super("The platform must be specified");
    }
}
