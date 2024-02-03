package com.trybeticket.catalog.dtos;

import java.time.LocalDateTime;

import com.trybeticket.catalog.entities.CatalogEvent;

public record CatalogResponseDto(Long id, String name, LocalDateTime eventDateTime) {
  public static CatalogResponseDto fromEntity(CatalogEvent catalog) {
    return new CatalogResponseDto(catalog.getId(), catalog.getName(), catalog.getEventDateTime());
  }
}
