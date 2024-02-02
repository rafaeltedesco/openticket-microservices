package com.trybeticket.catalog.controllers;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.web.bind.annotation.RestController;

import com.trybeticket.catalog.dtos.CatalogResponseDto;
import com.trybeticket.catalog.services.CatalogService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/catalog")
public class CatalogController {

  private CatalogService catalogService;

  public CatalogController(CatalogService catalogService) {
    this.catalogService = catalogService;
  }

  @GetMapping()
  public ResponseEntity<List<CatalogResponseDto>> getAvaliableCatalogEvents() {
    List<CatalogResponseDto> availableEvents = this.catalogService.getAvailableCatalogEvents(LocalDateTime.now());
    return ResponseEntity.ok().body(availableEvents);
  }

}
