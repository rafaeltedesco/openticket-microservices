package com.trybeticket.catalog.entities.exceptions;

public class InvalidDateException extends RuntimeException {

  public InvalidDateException(String message) {
    super(message);
  }
}
