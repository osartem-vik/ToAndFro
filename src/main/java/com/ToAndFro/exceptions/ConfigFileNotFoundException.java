package com.ToAndFro.exceptions;

import java.io.IOException;

public class ConfigFileNotFoundException extends IOException {
    public ConfigFileNotFoundException(String message) {
        super(message);
    }

    public ConfigFileNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}