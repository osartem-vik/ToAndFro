package com.ToAndFro.exceptions;

public class CityOperationException extends RuntimeException {
    public CityOperationException(String message) {
        super(message);
    }

    public CityOperationException(String message, Throwable cause) {
        super(message, cause);
    }
}
