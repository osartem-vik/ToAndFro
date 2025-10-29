package com.ToAndFro.exceptions;

public class ListingSqlException extends RuntimeException {
    public ListingSqlException(String message) {
        super(message);
    }

    public ListingSqlException(String message, Throwable cause) {
        super(message, cause);
    }
}
