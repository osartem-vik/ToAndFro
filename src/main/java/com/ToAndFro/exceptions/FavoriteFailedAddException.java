package com.ToAndFro.exceptions;

public class FavoriteFailedAddException extends RuntimeException {
  public FavoriteFailedAddException(String message) {
    super(message);
  }

  public FavoriteFailedAddException(String message, Throwable cause) {
    super(message, cause);
  }
}