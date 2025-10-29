package com.ToAndFro.exceptions;

public class FavoriteRepositoryException extends RuntimeException {
  public FavoriteRepositoryException(String message) {
    super(message);
  }

  public FavoriteRepositoryException(String message, Throwable cause) {
    super(message, cause);
  }
}