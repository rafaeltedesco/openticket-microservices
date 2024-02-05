package com.trybeticket.catalog.services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.trybeticket.catalog.dtos.CatalogResponseDto;
import com.trybeticket.catalog.repositories.CatalogRepository;

@Service
public class CatalogService {

  private CatalogRepository catalogRepository;

  public CatalogService(CatalogRepository catalogRepository) {
    this.catalogRepository = catalogRepository;
  }

  public List<CatalogResponseDto> getAvailableCatalogEvents(LocalDateTime when) {
    return catalogRepository.findByEventDateTimeAfter(when)
      .stream().map(CatalogResponseDto::fromEntity).toList();
  }
}
