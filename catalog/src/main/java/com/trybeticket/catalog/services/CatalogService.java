package com.trybeticket.catalog.services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.trybeticket.catalog.dtos.CatalogRequestDto;
import com.trybeticket.catalog.dtos.CatalogResponseDto;
import com.trybeticket.catalog.entities.CatalogEvent;
import com.trybeticket.catalog.entities.exceptions.InvalidDateException;
import com.trybeticket.catalog.repositories.CatalogRepository;
import com.trybeticket.catalog.utils.mappers.ObjectSerializer;

@Service
public class CatalogService {

  private CatalogRepository catalogRepository;
  private KafkaProducerService kafkaProducerService;

  public CatalogService(CatalogRepository catalogRepository, KafkaProducerService kafkaProducerService) {
    this.catalogRepository = catalogRepository;
    this.kafkaProducerService = kafkaProducerService;
  }

  public List<CatalogResponseDto> getAvailableCatalogEvents(LocalDateTime when) {
    return catalogRepository.findByEventDateTimeAfter(when)
      .stream().map(CatalogResponseDto::fromEntity).toList();
  }

  public CatalogResponseDto createEvent(CatalogRequestDto eventCreationDto) {
    CatalogEvent event = CatalogEvent.fromDto(eventCreationDto);
    if (event.isValidateDate() == false) {
      throw new InvalidDateException("Event date must be in the future");
    }
    CatalogEvent newEvent = catalogRepository.save(event);

    kafkaProducerService.sendEventAddedMessage(ObjectSerializer.toString(newEvent));

    return CatalogResponseDto.fromEntity(newEvent);
  }
}
