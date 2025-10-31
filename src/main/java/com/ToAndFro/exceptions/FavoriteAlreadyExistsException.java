package com.ToAndFro.exceptions;

public class FavoriteAlreadyExistsException extends RuntimeException {
    public FavoriteAlreadyExistsException(String message) {
        super(message);
    }

    public FavoriteAlreadyExistsException(String message, Throwable cause) {
        super(message, cause);
    }
}