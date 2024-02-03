package com.trybeticket.catalog.utils.mappers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;;

public class ObjectSerializer {
  
  private static final ObjectMapper mapper = new ObjectMapper().registerModule(new JavaTimeModule());

  static public <T> String toString(T object) {
    try {
      return mapper.writeValueAsString(object);
    } catch (JsonProcessingException jse) {
      throw new RuntimeException(jse);
    }
    
  }
}
