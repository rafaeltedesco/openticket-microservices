package com.trybeticket.catalog.dtos;

import java.time.LocalDateTime;

public record CatalogRequestDto(String name, LocalDateTime eventDateTime, Integer ticketsAvailable) {
  
}
