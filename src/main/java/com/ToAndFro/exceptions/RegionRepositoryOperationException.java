package com.ToAndFro.exceptions;

public class RegionRepositoryOperationException extends RuntimeException {
    public RegionRepositoryOperationException(String message) {
        super(message);
    }

    public RegionRepositoryOperationException(String message, Throwable cause) {
        super(message, cause);
    }
}
