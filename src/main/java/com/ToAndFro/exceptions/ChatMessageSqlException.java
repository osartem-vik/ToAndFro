package com.ToAndFro.exceptions;

public class ChatMessageSqlException extends RuntimeException {
    public ChatMessageSqlException(String message) {
        super(message);
    }
    public ChatMessageSqlException(String message, Throwable cause) {
        super(message, cause);
    }
}
