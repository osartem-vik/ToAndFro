package com.ToAndFro.exceptions;

public class ChatMessagePersistenceFailed extends RuntimeException {
    public ChatMessagePersistenceFailed(String message) {
        super(message);
    }
    public ChatMessagePersistenceFailed(String message, Throwable cause) {
        super(message, cause);
    }
}
