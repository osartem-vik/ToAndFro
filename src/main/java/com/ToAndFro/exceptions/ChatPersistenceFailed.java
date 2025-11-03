package com.ToAndFro.exceptions;

public class ChatPersistenceFailed extends RuntimeException {

    public ChatPersistenceFailed(String message) {
        super(message);
    }
    public ChatPersistenceFailed(String message, Throwable cause) {
        super(message, cause);
    }

}
