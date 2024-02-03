package com.trybeticket.catalog.exceptionHandlers;

import java.util.Map;
import java.util.HashMap;

import java.time.format.DateTimeParseException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.trybeticket.catalog.entities.exceptions.InvalidDateException;

@RestControllerAdvice
public class CatalogExceptionHandler {

  @ExceptionHandler(InvalidDateException.class)
  public ResponseEntity<Map<String, String>> handleInvalidDateException(InvalidDateException e) {
    return ResponseEntity.badRequest().body(new HashMap<String, String>(){
      {
        put("message", e.getMessage());
      }
    });
  }

  @ExceptionHandler(DateTimeParseException.class)
  public ResponseEntity<Map<String, String>> handleDateTimeParseException(DateTimeParseException e) {
    return ResponseEntity.badRequest().body(new HashMap<String, String>(){
      {
        put("message", "Invalid date format");
      }
    });
  }
}
