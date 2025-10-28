package com.ToAndFro.exceptions;

public class UserInsertException extends RuntimeException {
    public UserInsertException(String message) {
        super(message);
    }

    public UserInsertException(String message, Throwable cause) {
        super(message, cause);
    }
}
