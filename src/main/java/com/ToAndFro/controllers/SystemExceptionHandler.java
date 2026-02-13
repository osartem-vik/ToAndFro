package com.ToAndFro.controllers;

import com.ToAndFro.exceptions.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class SystemExceptionHandler {
    @ExceptionHandler({UserNotFoundException.class, CityNotFoundException.class, RegionNotFoundException.class})
    public ResponseEntity<String> handleNotFoundExceptions(RuntimeException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({EmailIsAlreadyTakenException.class, CityAlreadyExistsException.class, RegionAlreadyExistsException.class})
    public ResponseEntity<String> handleConflictExceptions(RuntimeException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.CONFLICT);
    }
}
