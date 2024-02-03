package com.trybeticket.catalog.controllers;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.web.bind.annotation.RestController;

import com.trybeticket.catalog.dtos.CatalogRequestDto;
import com.trybeticket.catalog.dtos.CatalogResponseDto;
import com.trybeticket.catalog.services.CatalogService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.HttpStatus;


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
    return ResponseEntity.status(HttpStatus.OK).body(availableEvents);
  }

  @PostMapping()
  public ResponseEntity<CatalogResponseDto> createEvent(@RequestBody CatalogRequestDto eventCreationDto) {
      CatalogResponseDto createdEvent = this.catalogService.createEvent(eventCreationDto);
      return ResponseEntity.status(HttpStatus.CREATED).body(createdEvent);
  }
}
