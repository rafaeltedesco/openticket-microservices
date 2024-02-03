package com.trybeticket.catalog;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.TopicBuilder;

@EnableKafka
@SpringBootApplication
public class CatalogApplication {
  
  public static void main(String[] args) {
    SpringApplication.run(CatalogApplication.class, args);
  }

  @Bean
  NewTopic newEventAdded() {
    return TopicBuilder.name("new-event-added")
        .partitions(1)
        .replicas(1)
        .build();
  }
}
