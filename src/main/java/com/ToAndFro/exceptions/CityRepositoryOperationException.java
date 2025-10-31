package com.ToAndFro.exceptions;

public class CityRepositoryOperationException extends RuntimeException {
    public CityRepositoryOperationException(String message) {
        super(message);
    }

    public CityRepositoryOperationException(String message, Throwable cause) {
        super(message, cause);
    }
}
