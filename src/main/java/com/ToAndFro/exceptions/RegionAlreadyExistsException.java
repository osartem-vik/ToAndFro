package com.ToAndFro.exceptions;

public class RegionAlreadyExistsException extends RuntimeException {
    public RegionAlreadyExistsException(String message) {
        super(message);
    }
}
