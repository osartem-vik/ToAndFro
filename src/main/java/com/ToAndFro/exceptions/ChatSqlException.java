package com.ToAndFro.exceptions;

public class ChatSqlException extends RuntimeException {

    public ChatSqlException(String message) {
        super(message);
    }
    public ChatSqlException(String message, Throwable cause) {
        super(message, cause);
    }

}
