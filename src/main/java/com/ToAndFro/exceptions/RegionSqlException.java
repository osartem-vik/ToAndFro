package com.ToAndFro.exceptions;

public class RegionSqlException extends RuntimeException {
    public RegionSqlException(String message) {
        super(message);
    }

    public RegionSqlException(String message, Throwable cause) {
        super(message, cause);
    }
}
