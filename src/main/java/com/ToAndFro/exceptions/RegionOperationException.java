package com.ToAndFro.exceptions;

public class RegionOperationException extends RuntimeException {
    public RegionOperationException(String message) {
        super(message);
    }

    public RegionOperationException(String message, Throwable cause) {
        super(message, cause);
    }
}
