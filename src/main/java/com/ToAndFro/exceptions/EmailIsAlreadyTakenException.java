package com.ToAndFro.exceptions;

public class EmailIsAlreadyTakenException extends RuntimeException {
    public EmailIsAlreadyTakenException(String message) {
        super(message);
    }
}
