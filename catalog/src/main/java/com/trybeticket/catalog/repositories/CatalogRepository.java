package com.trybeticket.catalog.repositories;

import java.time.LocalDateTime;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trybeticket.catalog.entities.CatalogEvent;

public interface CatalogRepository extends JpaRepository<CatalogEvent, Long>  {
  List<CatalogEvent> findByEventDateTimeAfter(LocalDateTime when);
}
