package com.trybeticket.catalog.services;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Description;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;

import com.trybeticket.catalog.dtos.CatalogResponseDto;
import com.trybeticket.catalog.entities.CatalogEvent;
import com.trybeticket.catalog.repositories.CatalogRepository;

@SpringBootTest
@ContextConfiguration
@ActiveProfiles("test")
public class CatalogServiceTest {
  
  @Autowired
  private CatalogService catalogService;

  @BeforeAll
  static void setup(@Autowired CatalogRepository catalogRepository) {
    catalogRepository.save(new CatalogEvent(1l, "show 1", LocalDateTime.of(2024, 02, 02, 10, 20, 00), 50));
    catalogRepository.save(new CatalogEvent(2l, "show 2", LocalDateTime.of(2024, 03, 22, 13, 20, 00), 25));
  }

  @AfterAll
  static void tearDown(@Autowired CatalogRepository catalogRepository) {
    catalogRepository.deleteAll();
  }

  @Test
  @Description("Should return a list of all available events")
  void getAvailableCatalogEventsWhereWhenIsBeforeAllEvents() {
    List<CatalogResponseDto> expectedEvents = List.of(
      new CatalogEvent(1l, "show 1", LocalDateTime.of(2024, 02, 02, 10, 20, 00), 50),
      new CatalogEvent(2l, "show 2", LocalDateTime.of(2024, 03, 22, 13, 20, 00), 25)
    ).stream().map(CatalogResponseDto::fromEntity).toList();
    List<CatalogResponseDto> availableEvents = catalogService.getAvailableCatalogEvents(LocalDateTime.of(2024, 01, 02, 8, 00, 00));
    assert availableEvents.size() == 2;
    assertArrayEquals(expectedEvents.toArray(), availableEvents.toArray());
  }

  @Test
  @Description("Should return a list of available events that are after the given date")
  void getAvailableCatalogEventsWhereWhenIsBeforeOnlyOneEvent() {
    List<CatalogResponseDto> expectedEvents = List.of(
      new CatalogEvent(2l, "show 2", LocalDateTime.of(2024, 03, 22, 13, 20, 00), 25)
    ).stream().map(CatalogResponseDto::fromEntity).toList();
    List<CatalogResponseDto> availableEvents = catalogService.getAvailableCatalogEvents(LocalDateTime.of(2024, 02, 02, 10, 20, 00));
    assert availableEvents.size() == 1;
    assertArrayEquals(expectedEvents.toArray(), availableEvents.toArray());
  }
}
