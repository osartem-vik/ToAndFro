package com.ToAndFro.exceptions;

public class UserSqlException extends RuntimeException {
    public UserSqlException(String message) {
        super(message);
    }

    public UserSqlException(String message, Throwable cause) {
        super(message, cause);
    }
}
