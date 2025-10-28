package com.ToAndFro.exceptions;

public class CitySqlException extends RuntimeException {
    public CitySqlException(String message) {
        super(message);
    }
    public CitySqlException(String message, Throwable cause) {
        super(message, cause);
    }
}
