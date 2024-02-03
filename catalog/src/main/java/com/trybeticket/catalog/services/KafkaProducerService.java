package com.trybeticket.catalog.services;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {
  
  private final String topicName = "new-event-added";
  private final KafkaTemplate<Integer, String> kafkaTemplate;

  KafkaProducerService(KafkaTemplate<Integer, String> kafkaTemplate) {
    this.kafkaTemplate = kafkaTemplate;
  }

  public void sendEventAddedMessage(String message) {
    kafkaTemplate.send(topicName, message);
    System.out.println("Message sent to Kafka");
  }
}
