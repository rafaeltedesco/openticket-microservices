package com.trybeticket.catalog.services;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.trybeticket.catalog.entities.CatalogEvent;
import com.trybeticket.catalog.repositories.CatalogRepository;

@Service
public class KafkaConsumerService {
  
  private final String topicName = "new-event-added";
  private CatalogRepository catalogRepository;

  public KafkaConsumerService(CatalogRepository catalogRepository) {
    this.catalogRepository = catalogRepository;
  }

  @KafkaListener(topics = topicName, groupId = "catalog")
  void consume(ConsumerRecord<String, String> record) {
    System.out.println("Consumed message from topic " + topicName); 
    System.out.println("Message: " + record.value());
    ObjectMapper objectMapper = new ObjectMapper().registerModule(new JavaTimeModule());
    try {
      CatalogEvent catalogEvent = objectMapper.readValue(record.value(), CatalogEvent.class);
      if (!catalogEvent.isValidateDate()) {
        System.out.println("CatalogEvent date is not valid");
        return;
      }
      catalogRepository.save(catalogEvent);
      System.out.println("CatalogEvent saved: " + catalogEvent.toString());
    } catch (JsonProcessingException e) {
      System.out.println(e.getMessage());
      System.out.println("Error converting message to CatalogEvent");
    }
  }
}
